@ECHO OFF

REM create bin directory if it doesn't exist
if not exist ..\bin mkdir ..\bin

REM delete output from previous run
del ACTUAL.TXT
del ACTUAL-2.TXT
del ACTUAL-3.TXT
del ACTUAL-4.TXT
del ACTUAL-5.TXT
rm "../../../data/duke.txt"

REM compile the code into the bin folder
javac  -cp ..\src -Xlint:none -d ..\bin ..\src\main\java\*.java
IF ERRORLEVEL 1 (
    echo ********** BUILD FAILURE **********
    exit /b 1
)
REM no error here, errorlevel == 0

REM run the program, feed commands from input.txt file and redirect the output to the ACTUAL.TXT
java -classpath ..\bin Duke < input.txt > ACTUAL.TXT
java -classpath ..\bin Duke < input-2.txt > ACTUAL-2.TXT
java -classpath ..\bin Duke < input-3.txt > ACTUAL-3.TXT
java -classpath ..\bin Duke < input-4.txt > ACTUAL-4.TXT
java -classpath ..\bin Duke < input-5.txt > ACTUAL-5.TXT

REM compare the output to the expected output
FC ACTUAL.TXT EXPECTED.TXT
FC ACTUAL-2.TXT EXPECTED-2.TXT
FC ACTUAL-3.TXT EXPECTED-3.TXT
FC ACTUAL-4.TXT EXPECTED-4.TXT
FC ACTUAL-5.TXT EXPECTED-5.TXT
