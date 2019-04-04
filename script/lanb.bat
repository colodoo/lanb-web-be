@echo ofF
chcp 65001

set projectName=%1

if "%projectName%"=="" (

  echo Project name is `NULL`

) else (

  if exist pom_tmp.xml (rm pom_tmp.xml)
  if exist .project_tmp (rm rm .project_tmp)

  setlocal EnableDelayedExpansion
  for /f "delims=" %%i in (.project) do (
    set var=%%i
    set "var=!var:lanb-web-be=%projectName%!"
    echo !var!>>.project_tmp
  )

  for /f "delims=" %%i in (pom.xml) do (
    set var=%%i
    set var=!var:LanbWeb=%projectName%!
    echo !var!>>pom_tmp.xml
  )

  echo yes|move pom_tmp.xml ..\pom.xml
  echo yes|move .project_tmp ..\.project

)

echo Please input `chcp 936` by yourself