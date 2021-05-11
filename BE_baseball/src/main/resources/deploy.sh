# 설정
LINE='#########################################################'
파SERVADDR='ec2-3-35-226-74.ap-northeast-2.compute.amazonaws.com' #배포할 AWS EC2 서버
KEYFILE='~/Downloads/Dong210511.pem' # 내 개발콤퓨터에서 AWS key 위치
AUTOINJECT_JAR=1 #1:자동으로 scp명령어로 밀어넣기, #0=안밀어넣고 명령어만 보여주고 끝내기
NGINX_SETUP = '/Users/gimdonghun/Workspace/baseball/BE_baseball/src/main/resources/nginx.sh'
#
echo $LINE
echo "## DongDong's 바이너리파일 밀어넣기 스크립트 "
echo "## >>  프로젝트 : baseball  << "
echo $LINE

cd ../../../
./gradlew build -x test
cd build/libs
BINFILE=`ls | grep *.jar`
echo $BINFILE
echo $LINE

if [ ${AUTOINJECT_JAR} -eq 1 ];then
    scp -i $KEYFILE $BINFILE ubuntu@$SERVADDR:/home/ubuntu
    scp -i $KEYFILE $NGINX_SETUP ubuntu@$SERVADDR:/home/ubuntu

    echo "JAR FILE SEND OK...!"

    echo ""
    echo "## tip!"
    echo ""
    echo "#how to run?"
    echo "nohup java -jar ${BINFILE} &"
    echo ""
    echo "#how to show log file?"
    echo "tail -F nohup.out"
    echo ""
    echo "#java start fail?"
    echo "ps -ef | grep java"
    echo ""
    echo "go EC2 SERVER"
    echo $LINE

    ssh -i $KEYFILE ubuntu@$SERVADDR
fi






