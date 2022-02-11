/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.service.impl.real;



/**
 *
 * @author Alexandra
 */

/*
public class AuthServiceImpl implements AuthService {

    private String login;
    private String password;
    private HttpClient http;
    private String url;
    private String uuid;
    private String csrfToken;
    private String csrfHeader;
    private String sessionId;
    private User user;
    private String ou;
    private CookieStore httpCookieStore;
    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    private final static Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Override
    public synchronized User getUser() {
        return user;
    }

    @Override
    public String getSessionId() {
        return sessionId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getUuid() {
        return uuid;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void close() {
        executor.shutdown();
        httpCookieStore.clear();
        executor = Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public synchronized void authenticate() throws Exception {
        HttpEntity loginPageEntity = null;
        HttpEntity userInfoEntity = null;
        HttpEntity authPostEntity = null;
        HttpEntity csrfEntity = null;
        try {
            URI baseUrl = URI.create(url);
            httpCookieStore = new BasicCookieStore();
            SSLContext sslContext = SSLContexts.custom()
                    .useTLS()
                    .build();
            SSLConnectionSocketFactory scsf = new SSLConnectionSocketFactory(sslContext, new AllowAllHostnameVerifier());
            RequestConfig defaultRequestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.BEST_MATCH).setExpectContinueEnabled(true).setStaleConnectionCheckEnabled(true).setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST)).setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC)).build();
            http = HttpClientBuilder.create().setDefaultCookieStore(httpCookieStore).setSSLSocketFactory(scsf).build();
            RequestConfig requestConfig = RequestConfig.copy(defaultRequestConfig).setSocketTimeout(5000).setConnectTimeout(5000).setConnectionRequestTimeout(5000).build();
            HttpGet loginPageGet = new HttpGet(baseUrl.resolve("./pubsub"));
            loginPageGet.setConfig(requestConfig);
            HttpResponse loginPage = http.execute(loginPageGet);
            loginPageEntity = loginPage.getEntity();
            String loginText = EntityUtils.toString(loginPageEntity);
            Document doc = Jsoup.parse(loginText);
            Elements meta = doc.select("meta");
            csrfToken = meta.select("[name=_csrf]").attr("content");
            csrfHeader = meta.select("[name=_csrf_header]").attr("content");
            uuid = UUID.randomUUID().toString();
            EntityUtils.consumeQuietly(loginPageEntity);
            loginPageEntity = null;
            HttpPost authPost = new HttpPost(baseUrl.resolve("./login/check"));
            authPost.setHeader(csrfHeader, csrfToken);
            List<NameValuePair> nameValuePairs = new ArrayList<>();
            nameValuePairs.add(new BasicNameValuePair("username", login));
            nameValuePairs.add(new BasicNameValuePair("password", password));
            authPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            authPost.setConfig(requestConfig);
            HttpResponse authResponse = http.execute(authPost);
            authPostEntity = authResponse.getEntity();
            String location = authResponse.getFirstHeader("Location").getValue();
            if (location != null && location.endsWith("failed/")) {
                logger.error("failed to authenticate");
                throw new RuntimeException("failed to authenticate");
            }
            for (Cookie cookie : httpCookieStore.getCookies()) {
                if ("JSESSIONID".equals(cookie.getName())) {
                    sessionId = cookie.getValue();
                }
                if ("ou".equals(cookie.getName())) {
                    ou = cookie.getValue();
                }
            }
            EntityUtils.consumeQuietly(authPostEntity);
            authPostEntity = null;

            Gson gson = new Gson();

            HttpGet csrfInfoGet = new HttpGet(baseUrl.resolve("./remote/egais/csrf"));
            csrfEntity = http.execute(csrfInfoGet).getEntity();
            try {
                Map<String, String> csrf = gson.fromJson(new InputStreamReader(csrfEntity.getContent()), new TypeToken<Map<String, String>>() {
                }.getType());
                csrfHeader = csrf.get("headerName");
                csrfToken = csrf.get("token");
            } catch (JsonException | JsonSyntaxException ex) {
                logger.error(ex.getMessage(), ex);
                throw new RuntimeException(ex);
            }
            EntityUtils.consumeQuietly(csrfEntity);
            csrfEntity = null;
            HttpGet userInfoGet = new HttpGet(baseUrl.resolve("./remote/egais/auth/get"));
            userInfoEntity = http.execute(userInfoGet).getEntity();
            try {
                user = gson.fromJson(new InputStreamReader(userInfoEntity.getContent()), User.class);
            } catch (JsonIOException | JsonSyntaxException ex) {
                logger.error(ex.getMessage(), ex);
                throw new RuntimeException(ex);
            }
            EntityUtils.consumeQuietly(userInfoEntity);
            userInfoEntity = null;
            executor.scheduleAtFixedRate(new Runnable() {

                @Override
                public void run() {
                    try {
                        RequestConfig defaultRequestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.BEST_MATCH).setExpectContinueEnabled(true).setStaleConnectionCheckEnabled(true).setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST)).setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC)).build();
                        RequestConfig requestConfig = RequestConfig.copy(defaultRequestConfig).setSocketTimeout(5000).setConnectTimeout(5000).setConnectionRequestTimeout(5000).build();
                        logger.info("Sending heartbeat to server");
                        URI baseUrl = URI.create(url);
                        HttpGet ping = new HttpGet(baseUrl.resolve("./remote/egais/ping"));
                        ping.setHeader(csrfHeader, csrfToken);
                        ping.setConfig(requestConfig);
                        HttpResponse response = http.execute(ping);
                        String body = IOUtils.toString(response.getEntity().getContent());
                        logger.info("ping response is {} with body {}", response, body);
                        if (!"{}".equals(body)) {
                            logger.error("error at ping answer");
                            EventBusHolder.getEventBus("connectionBus").post(new RuntimeException("invalid ping response body"));
                        }
                        EntityUtils.consumeQuietly(response.getEntity());
                    } catch (Exception ex) {
                        if (ex != null && ex.getMessage() != null) {
                            logger.error(ex.getMessage(), ex);
                            EventBusHolder.getEventBus("connectionBus").post(ex);
                        } else {
                            logger.error("unknown error at sending heartbeat");
                        }
                    } catch (Throwable th) {
                        if (th != null && th.getMessage() != null) {
                            logger.error(th.getMessage(), th);
                            EventBusHolder.getEventBus("connectionBus").post(th);
                        } else {
                            logger.error("unknown error at sending heartbeat");
                        }
                    }
                }
            }, 0, 30, TimeUnit.SECONDS);

        } finally {
            if (loginPageEntity != null) {
                EntityUtils.consumeQuietly(loginPageEntity);
            }
            if (userInfoEntity != null) {
                EntityUtils.consumeQuietly(userInfoEntity);
            }
            if (authPostEntity != null) {
                EntityUtils.consumeQuietly(authPostEntity);
            }
            if (csrfEntity != null) {
                EntityUtils.consumeQuietly(csrfEntity);
            }
        }
    }

    @Override
    public CookieStore getCookieStore() {
        return httpCookieStore;
    }

    @Override
    public String getOU() {
        return ou;
    }

    @Override
    public Header getCsrf() {

        HttpEntity csrfPageEntity = null;
        Header header = null;
        try {
            URI baseUrl = URI.create(url);
            HttpGet pageGetCsrf = new HttpGet(baseUrl.resolve("./public/egais/csrf"));
            HttpResponse csrfPage = http.execute(pageGetCsrf);
            csrfPageEntity = csrfPage.getEntity();
            Gson gson = new Gson();
            Map<String, String> csrf = gson.fromJson(new InputStreamReader(csrfPageEntity.getContent()), new TypeToken<Map<String, String>>() {
            }.getType());
            csrfHeader = csrf.get("headerName");
            csrfToken = csrf.get("token");
            header = new BasicHeader(csrfHeader, csrfToken);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        } finally {
            if (csrfPageEntity != null) {
                EntityUtils.consumeQuietly(csrfPageEntity);
            }
        }
        return header;
    }

    @Override
    public void init(String url, String cred) {
        setLogin(cred);
        setPassword(cred);
        setUrl(url);
    }

}
*/