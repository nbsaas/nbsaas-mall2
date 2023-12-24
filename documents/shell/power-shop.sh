#!/bin/bash

echo "mall-shop服务  重启开始............."
SERVER_JAR_NAME="/data/cloud/nbsaas-power-shop.jar"

ID=$(ps -ef | grep "$SERVER_JAR_NAME" | grep -v "grep" | awk '{print $2}')
echo $ID
for id in $ID; do
  kill -9 $id
  echo "killed $id"
done

echo "重启服务中............."
nohup java   -Xms386m -Xmx3024m -Xmn256m  -Dfile.encoding=utf-8 -jar  $SERVER_JAR_NAME >./logs/shop.out 2>&1 &
echo "mall-shop服务 重启成功............."
