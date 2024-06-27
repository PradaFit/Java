@echo off
REM PradaFit's Port Scanner

REM Path to your JDK Installation folder
set JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-21.0.3.9-hotspot
set PATH=%JAVA_HOME%\bin;%PATH%

REM Navigate to the dir. contaiing the java file(s)
cd /d "%~dp0"

REM Compile the Java program (if not already compiled)
javac PortScanner.java

REM Run the Java program
java PortScanner %*

pause