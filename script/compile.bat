@ECHO OFF
TITLE mouse-automation-compile
CD ..
IF EXIST bin (RMDIR /S /Q bin)
MKDIR bin
CD bin
javac -d .\ ..\src\com\aizuddindeyn\mouse\*.java
jar cfm mouse-app.jar ..\src\com\aizuddindeyn\mouse\app.mf com\aizuddindeyn\mouse\*.class
CD ..\script