#!/bin/bash

echo "mall2-admin服务  重启开始............."
SERVER_JAR_NAME="/data/cloud/nbsaas-mall2-admin.jar"

ID=$(ps -ef | grep "$SERVER_JAR_NAME" | grep -v "grep" | awk '{print $2}')
echo $ID
for id in $ID; do
  kill -9 $id
  echo "killed $id"
done

echo "重启服务中............."
nohup java   -Xms386m -Xmx3024m -Xmn256m  -Xloggc:./logs/admin.log -Dfile.encoding=utf-8 -jar  $SERVER_JAR_NAME >./logs/admin.out 2>&1 &
echo "mall2-admin服务 重启成功............."
