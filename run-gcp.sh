#!/bin/bash

#build the all the services
mvn clean install

#build docker images for each of the service
docker build -t gcr.io/striking-shift-248504/eureka-server eureka-server/.
docker build -t gcr.io/striking-shift-248504/employee-service employee-service/.
docker build -t gcr.io/striking-shift-248504/api-gateway api-gateway/.

#push all the images to container registry
docker push  gcr.io/striking-shift-248504/eureka-server
docker push  gcr.io/striking-shift-248504/employee-service
docker push  gcr.io/striking-shift-248504/api-gateway

#run the services in kubernates cluster
kubectl run  eureka-server  --image=gcr.io/striking-shift-248504/eureka-server  --port=8761
kubectl run  api-gateway   --image=gcr.io/striking-shift-248504/api-gateway --port=8010
kubectl run  employee-service   --image=gcr.io/striking-shift-248504/employee-service --port=8011

#expose running service for the public access.
kubectl expose deployment eureka-server --type=LoadBalancer --port 8761 --target-port 8761
kubectl expose deployment api-gateway --type=LoadBalancer --port 8010 --target-port 8010







