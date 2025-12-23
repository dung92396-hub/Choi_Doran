@echo off
echo Building Netflix JavaFX App...
cd /d "%~dp0"

REM First clean and compile
call mvn clean compile javafx:run -DskipTests

pause

