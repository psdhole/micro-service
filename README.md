# micro-service
micro-services

## How to

#Set GCP project
    
	gcloud config set project <project-id>
	
	e.g.
	
		gcloud config set project striking-shift-248504

#Create cluster

    gcloud container clusters create gcp-boot-demo --num-nodes 2  --machine-type n1-standard-1  --zone us-central1-c 

#get cluster credentials

    gcloud container clusters get-credentials  --zone us-central1-a	 gcp-boot-demo-cluster

#Build and run the service

	- Go to the service dir
		
        cd <path>/micro-service/employee-service	
		
	- Build the service
				
	    mvn clean install
		
	- Create docker image for the service	
		
		docker build -t gcr.io/striking-shift-248504/eureka-server .
	
	- Push the image to container registry so that it will be available while running it in kubernatee cluster. 
	
		First, configure Docker command-line tool to authenticate to Container Registry (you need to run this only once):
	
			gcloud auth configure-docker

		Push the images with below command
		
			docker push gcr.io/striking-shift-248504/eureka-server .

	- Run the service in kubernates POD
	
		kubectl run  eureka-server  --image=gcr.io/striking-shift-248504/eureka-server  --port=8761

	- Expose service with expose option on UI to acces it publicly 		
	
	- Do all above steps for each of the service

             

     
           

