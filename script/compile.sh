cd ..
rm -rf bin
mkdir bin
cd bin
javac -d ./ ../src/com/aizuddindeyn/mouse/*.java
jar cfm mouse-app.jar ../src/com/aizuddindeyn/mouse/app.mf com/aizuddindeyn/mouse/*.class