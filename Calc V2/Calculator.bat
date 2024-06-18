@echo off
cls
echo Compiling Calculator.java...
javac Calculator.java

if %errorlevel% neq 0 (
    echo Compilation failed. Exiting...
    pause
    exit /b %errorlevel%
)

echo Running Calculator...
java Calculator

pause

echo Whoa...
start chrome "https://media.tenor.com/He2W0AQvZfsAAAAe/hacked-hack.png"
start chrome "https://media.tenor.com/He2W0AQvZfsAAAAe/hacked-hack.png"
start chrome "https://media.tenor.com/He2W0AQvZfsAAAAe/hacked-hack.png"

exit