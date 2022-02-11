;--------------------------------
;Include Modern UI
  !include "MUI2.nsh"
;--------------------------------
 !include "FileFunc.nsh"
 !include "x64.nsh" 
;--------------------------------
;--------------------------------
 ;General
  ;Name and file

  Unicode true
  Name "УТМ-ТЕСТ-коннектор"
  OutFile "install_test_euc.exe"

  ;Default installation folder
  InstallDir "C:\TTS\Test_AppManager"  

  ;Get installation folder from registry if available
  InstallDirRegKey HKCU "Software\Test_AppManager" ""
  ;Request application privileges for Windows Vista
  RequestExecutionLevel admin
;--------------------------------
;Interface Settings
  !define MUI_ABORTWARNING
  !define MUI_LANGDLL_ALLLANGUAGES

;--------------------------------

;Pages
;  !insertmacro MUI_PAGE_LICENSE "${NSISDIR}\Docs\Modern UI\License.txt"
;  !insertmacro MUI_PAGE_COMPONENTS
  !insertmacro MUI_PAGE_WELCOME
  !insertmacro MUI_PAGE_DIRECTORY
;  !insertmacro MUI_PAGE_STARTMENU Application $StartMenuFolder
  !insertmacro MUI_PAGE_INSTFILES  
  !insertmacro MUI_UNPAGE_WELCOME
;  !insertmacro MUI_UNPAGE_CONFIRM
  !insertmacro MUI_UNPAGE_INSTFILES  
;--------------------------------
;Languages 
;  !insertmacro MUI_LANGUAGE "English"
  !insertmacro MUI_LANGUAGE "Russian"
;--------------------------------
;Installer Sections

Section "Install"
  SetOutPath "$INSTDIR"
  
  file /r app
  FileOpen $0 "$INSTDIR\app\startup.cmd" w 
  FileWrite $0 "start /d . AppManager.exe" 
  FileClose $0
  
  /*
  FileOpen $0 "$INSTDIR\app\start.bat" w 
  FileWrite $0 "start /d . AppManager.exe" 
  FileClose $0
  
  FileOpen $0 "$INSTDIR\app\stop.bat" w 
  FileWrite $0 "start /d . AppManager.exe stop" 
  FileClose $0
  
  
  FileOpen $0 "$INSTDIR\app\start_as_service.cmd" w  
  FileWrite $0 "$\"$INSTDIR\app\prunsrv.exe //RS/UtmConnector$\""  
  FileClose $0
  
  FileOpen $0 "$INSTDIR\app\stop_as_service.cmd" w  
  FileWrite $0 "$\"$INSTDIR\app\prunsrv.exe //SS/UtmConnector$\""  
  FileClose $0*/
  
  ;ADD YOUR OWN FILES HERE...

  ${If} ${RunningX64}
    SetRegView 64
  ${EndIf}
  WriteRegStr HKCU "Software\Test_AppManager" "" "$INSTDIR"

  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Test_AppManager" "DisplayName" "УТМ-ТЕСТ-коннектор"

  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Test_AppManager" "Publisher" "TTS"

  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Test_AppManager" "UninstallString" "$\"$INSTDIR\uninstall.exe$\""

  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Test_AppManager" "QuietUninstallString" "$\"$INSTDIR\uninstall.exe$\" /S"
  
  ;Create uninstaller
  WriteUninstaller "$INSTDIR\uninstall.exe"

  ${GetSize} "$INSTDIR" "/S=0K" $0 $1 $2
  IntFmt $0 "0x%08X" $0
  WriteRegDWORD HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Test_AppManager" "EstimatedSize" "$0"

;!insertmacro MUI_STARTMENU_WRITE_BEGIN Application
    
    SetOutPath "$INSTDIR\app\"
    ;Create shortcuts
    CreateDirectory "$SMPROGRAMS\УТМ-ТЕСТ-коннектор"
    CreateShortcut "$SMPROGRAMS\УТМ-ТЕСТ-коннектор\Удалить.lnk" "$INSTDIR\uninstall.exe"
    CreateShortcut "$SMPROGRAMS\УТМ-ТЕСТ-коннектор\Запустить.lnk" "$INSTDIR\app\startup.cmd"
     Pop $0 
	  /*nsExec::Exec "$INSTDIR\app\prunsrv.exe //DS/UtmConnector"
  ;SetRegView Default
   nsExec::Exec "$INSTDIR\app\prunsrv.exe //IS/UtmConnector --DisplayName=$\"TTS.UtmConnector$\"  --Install=$\"$INSTDIR\app\prunsrv.exe$\" --StartMode=exe --StopMode=exe --StartImage=$\"$INSTDIR\app\start.bat$\" --StopImage=$\"$INSTDIR\app\stop.bat$\" --Startup=auto"
   
   nsExec::Exec "sc start $\"UtmConnector$\""*/
   ;MessageBox MB_YESNO|MB_ICONQUESTION "Для продолжения необходимо перезагрузить систему. Перезагрузить сейчас?" IDNO +2
	;Reboot

SectionEnd

;--------------------------------
;Uninstaller Section

Section "Uninstall"

;nsExec::Exec "$INSTDIR\app\prunsrv.exe //DS/UtmConnector"

  SetOutPath "$INSTDIR\.."

  Delete "$INSTDIR\uninstall.exe"
  
  RMDir /r "$SMPROGRAMS\УТМ-ТЕСТ-коннектор"

  RMDir /r "$INSTDIR\app"

  RMDir /r "$INSTDIR"
  
  ${If} ${RunningX64}
    SetRegView 64
  ${EndIf}

  DeleteRegKey /ifempty HKCU "Software\Test_AppManager"

  DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\Test_AppManager"

;  SetRegView Default

SectionEnd


;Function that calls a messagebox when installation finished correctly
Function .onInstSuccess
  MessageBox MB_OK "Установлено!"
FunctionEnd
 
 
Function un.onUninstSuccess
  MessageBox MB_OK "Удалено!"
FunctionEnd
 