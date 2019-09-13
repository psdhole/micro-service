#!/bin/bash

cd employee-service 
mvn clean install 
docker build -t gcr.io/striking-shift-248504/employee-service . 
docker push  gcr.io/striking-shift-248504/employee-service 

cd ../eureka-server 
mvn clean install 
docker build -t gcr.io/striking-shift-248504/eureka-server . 
docker push  gcr.io/striking-shift-248504/eureka-server 

cd ../api-gateway 
mvn clean install 
docker build -t gcr.io/striking-shift-248504/api-gateway . 
docker push  gcr.io/striking-shift-248504/api-gateway 