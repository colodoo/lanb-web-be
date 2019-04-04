@echo off
chcp 65001

if "%1%"=="" (

  echo Project name is `NULL`

) else (  
  
  if exist pom_tmp.xml (rm pom_tmp.xml)
  if exist rm .project_tmp (rm rm .project_tmp)

  setlocal EnableDelayedExpansion
  for /f "delims=" %%i in (.project) do (
    set var=%%i
    set "var=!var:lanb-web-be=%1%!"
    echo !var!>>.project_tmp
  )

  for /f "delims=" %%i in (pom.xml) do (
    set var=%%i
    set var=!var:LanbWeb=%1%!
    echo !var!>>pom_tmp.xml
  )

  echo yes|move pom_tmp.xml ..\pom.xml
  echo yes|move .project_tmp ..\.project
  
)