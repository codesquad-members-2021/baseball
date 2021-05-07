echo "@@@@ Start build"

# 빌드할 때 테스트를 하지 않는다.
./gradlew build -x test

# 자바 프로세스를 보는 명령어
# TOMCAT_PROCESS=`jps | grep qna | cut -d" " -f1`
TOMCAT_PROCESS=`lsof -t -i tcp:8080`

if [ -z "$TOMCAT_PROCESS" ]
then
    echo "@@@@ No Tomcat process"
else
    echo "@@@@ Tomcat is killed"
    kill $TOMCAT_PROCESS
fi

nohup java -jar ./build/libs/baseball.jar & >> log.txt 2>&1
