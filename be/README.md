# Backend

백엔드를 위한 디렉토리

## 배포

### Spring

```sh
kill -kill `lsof -t -i tcp:8080`

./gradlew build

nohup java -jar ./build/libs/파일명.jar
```

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
