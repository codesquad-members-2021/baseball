# kill -kill `lsof -t -i tcp:3306`
# rm -rf ./db/data/

docker stop $(docker ps -aq) ;
docker rm $(docker ps -aq);
# docker rmi $(docker images -aq) --force;
docker system prune --force;
docker system prune --volumes --force;
