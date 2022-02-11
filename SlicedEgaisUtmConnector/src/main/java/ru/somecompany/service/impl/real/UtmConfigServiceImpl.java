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
public class UtmConfigServiceImpl implements UtmConfigService {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(UtmConfigServiceImpl.class);
    @Autowired
    private AuthService authService;

    @Autowired
    private KeyService keyService;

    private Map<String, String> conf;

    @Override
    public Map<String, String> getUtmConfig() {
        return conf;
    }

    @Override
    public Map<String, String> refreshConfig() throws Exception {
        URI baseUrl = URI.create(keyService.getUrl());
        SSLContext sslContext = SSLContexts.custom()
                .useTLS()
                .build();
        SSLConnectionSocketFactory scsf = new SSLConnectionSocketFactory(sslContext, new AllowAllHostnameVerifier());
        HttpClient http = HttpClientBuilder.create().setDefaultCookieStore(authService.getCookieStore()).setSSLSocketFactory(scsf).build();

        Gson gson = new Gson();
        HttpGet getConfigUrl = new HttpGet(baseUrl.resolve("./remote/egais/preset/all"));
        HttpResponse response = http.execute(getConfigUrl);
        String res = IOUtils.toString(response.getEntity().getContent());
        conf = gson.fromJson(res, new TypeToken<Map<String, String>>() {
        }.getType());
        logger.info("refreshing utm config");
        for (Map.Entry<String, String> e : conf.entrySet()) {
            logger.info(e.getKey()+" : "+e.getValue());
        }
        EntityUtils.consumeQuietly(response.getEntity());
        return conf;
    }

}*/
