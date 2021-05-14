#!/usr/bin/bash

cd /home/ec2-user/FE
cd /home/ec2-user/FE/baseball

echo "fetch 시작"

git fetch

LOCAL=`git rev-parse HEAD`
REMOTE=`git rev-parse origin/dev/FE`

if [[ $LOCAL == $REMOTE ]]; then
        echo "빌드할 필요가 없습니다."
        exit 0
fi

echo "merge 시작"

git merge

cd /home/ec2-user/FE/baseball/fe

yarn run build --prod  # 이 부분 스크립트가 명령어를 찾지 못함 ㅠㅠ 나중에 알아보자

echo "빌드 시작"

sudo service nginx restart;
