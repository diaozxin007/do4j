#!/bin/sh
#JAVA_OPTS='-Xms128m -Xmx512m -XX:NewSize=128m -XX:MaxNewSize=512m -XX:MetaspaceSize=64m -XX:MaxMetaspaceSize=128m -XX:NewRatio=2 -XX:MaxTenuringThreshold=8 -XX:+DisableExplicitGC'
RESOURCE_NAME=target/do4j.jar
LOG_NAME=do4j.log
MAX_TIMEOUT=20

cd do4j

git pull

mvn clean package -DskipTests=true

tpid=`ps -ef|grep $RESOURCE_NAME|grep -v grep|grep -v kill|awk '{print $2}'`

if [ ${tpid} ]; then
        echo 'Stop Process...'
        kill -15 $tpid
fi

for((i=0;i<$MAX_TIMEOUT;i++))
do
        sleep 1
        tpid=`ps -ef|grep $RESOURCE_NAME|grep -v grep|grep -v kill|awk '{print $2}'`
        if [ ${tpid} ]; then
                echo 'App Stoping...'
        else
                break
        fi
done

if [ ${tpid} ]; then
        echo 'Kill Process!'
        kill -9 $tpid
else
        echo 'Stop Success!'
fi

tpid=`ps -ef|grep $RESOURCE_NAME|grep -v grep|grep -v kill|awk '{print $2}'`

if [ ${tpid} ]; then
    echo 'App is running.'
else
    echo 'App is NOT running.'
fi

rm -f tpid

echo 'App is Starting...'
nohup java $JAVA_OPTS -jar $RESOURCE_NAME --spring.profiles.active=prod >$LOG_NAME 2>&1 &
echo $! > tpid
echo Start Success!