@echo off
set workspace=/Users/pc/workspace/Juan.Robisco.SVC.miw.upm.es
::Las variables de entorno se pueden configurar directamente en Windows cuando se tienen los permisos necesarios
set JAVA_HOME=/Program Files/Java/jdk1.8.0_101
set M2_HOME=/Users/pc/apache-maven-3.3.9
set PATH=%PATH%;%JAVA_HOME%\bin;%M2_HOME%\bin
echo -----------------------------------------
echo . (C) MIW
echo -----------------------------------------
echo .
echo Workspace --- %workspace%
echo JAVA_HOME --- %JAVA_HOME%
echo M2_HOME   --- %M2_HOME%
echo .
cd %workspace%
echo ============ mvn clean test (profile: develop) =======================================================
echo .
call mvn clean test
pause

