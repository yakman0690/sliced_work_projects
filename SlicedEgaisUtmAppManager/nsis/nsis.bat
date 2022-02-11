rd /s /q nsis\app
mkdir nsis\app
xcopy /y updater.pr nsis\app
xcopy /y target\AppManager.exe nsis\app
xcopy /s /e /y jre nsis\app\jre\
xcopy /y nsis\prunsrv.exe nsis\app
makensis nsis\build.nsi