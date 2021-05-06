# Backend

백엔드를 위한 디렉토리

## 배포

### Spring

crontab 으로 deploy.sh 를 주기적으로 실행한다.

#### Nginx

- [출처: Dong 의 블로그](https://velog.io/@d-h-k/NGINX)

```
sudo apt update && sudo apt upgrade - y && sudo apt clean
sudo apt install nginx -y
sudo service nginx restart

sudo echo "server {
    listen 80;
    listen [::]:80;
    server_name baseball.pyro-squad.com;
    location / {
        proxy_pass http://localhost:8080;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header Host $http_host;
    }
}" >> /etc/nginx/sites-available/test.conf

sudo ln -s /etc/nginx/sites-available/test.conf /etc/nginx/sites-enabled
sudo rm /etc/nginx/sites-enabled/default
sudo service nginx reload
sudo service nginx restart
```

### 2021-05-06 목 수업 내용

`openjdk-8-*` 을 설치해보고, 자바버전 관리가 어렵다면 sdkman 을 사용해보자.

AWS 개발자 도구의 CodeBuild, CodeDeploy 를 활용해보자

CPU Credit 이 0 이 되면, ec2의 CPU 를 5%밖에 사용 못한다. 바로 이래서 서버가 갑자기 죽는다.<br>
CPU Credit 은 ec2가 놀고 있을 때, 시간이 지남에 따라 쌓인다.<br>
보통 AWS 서버가 갑자기 죽는 이유는 메모리 부족보다, CPU Credit 부족 때문인 경우가 많다.

코드 빌드와 람다는 횟수 제한만 있을 뿐, 기간 제한 없이 평생 무료이다.

```sh
# 특정 브랜치를 특정 커밋으로 강제로 이동
git branch -f 브랜치명 커밋해쉬

# 혹시라도 브랜치를 실수로 삭제했다면, HEAD 의 움직임을 추적하자
git reflog
```
