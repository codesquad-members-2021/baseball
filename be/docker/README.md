# Docker 안내서

## Docker Clear

```sh
cd ./be/docker
rm -rf ./db/data

sh ./docker-clear.sh
```

## Docker Compose

```sh
cd ./be/docker

# start
sh docker-start.sh

# view logs
docker-compose logs

# stop
docker-compose down
```

## API 접속

뒤에 api 를 붙이면 8080 포트의 Spring API 와 연결된다.

`http://localhost/api`

## React 웹 접속

api 를 붙이지 않은 일반 url 은 3000 포트의 React 앱과 연결된다.

`http://localhost/login`

## DB 접속

```sh
mysql -h 127.0.0.1 -u root -p
# 비밀번호: root1234

mysql -h 127.0.0.1 -u pyro -p
# 비밀번호: pyro1234

mysql -h 127.0.0.1 -u robin -p
# 비밀번호: robin1234
```

혹은 `http://localhost:9984` 에 브라우저로 접속
