#!/bin/bash

cd /home/pushparaj_dhole23/micro-service/eureka-server 
mvn clean install 
docker build -t gcr.io/striking-shift-248504/eureka-server . 
docker push  gcr.io/striking-shift-248504/eureka-server 
kubectl run  eureka-server  --image=gcr.io/striking-shift-248504/eureka-server  --port=8761

cd /home/pushparaj_dhole23/micro-service/employee-service 
mvn clean install 
docker build -t gcr.io/striking-shift-248504/employee-service . 
docker push  gcr.io/striking-shift-248504/employee-service 
kubectl run  employee-service   --image=gcr.io/striking-shift-248504/employee-service   --port=8011


cd /home/pushparaj_dhole23/micro-service/api-gateway 
mvn clean install 
docker build -t gcr.io/striking-shift-248504/api-gateway . 
docker push  gcr.io/striking-shift-248504/api-gateway 
kubectl run  api-gateway   --image=gcr.io/striking-shift-248504/api-gateway    --port=8010