@echo off
setlocal
set DIRNAME=%~dp0
"%JAVA_HOME%\bin\java" -jar "%DIRNAME%\.mvn\wrapper\maven-wrapper.jar" %*
