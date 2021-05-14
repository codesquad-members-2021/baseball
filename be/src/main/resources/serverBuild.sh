#!/usr/bin/bash
cd /home/ec2-user/baseball
cd /home/ec2-user/be

echo "fetch 시작"

git fetch

LOCAL=`git rev-parse HEAD`
REMOTE=`git rev-parse origin/dev/BE`

if [[ $LOCAL == $REMOTE ]]; then
        echo "빌드할 필요가 없습니다."
        exit 0
fi

echo "merge 시작"

git merge

echo "Kill tomcat"

BOOT=`jps | grep baseball | cut -d " " -f1`

kill $BOOT

echo "빌드 시작"

./gradlew build -x test

java -jar build/libs/baseball-0.0.1-SNAPSHOT.jar &
