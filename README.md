# employee-management-micro-services
Demo micro-service based application for employee information management 

## How to

#Set GCP project
    
	gcloud config set project <project-id>
	
	e.g.
	
		gcloud config set project striking-shift-248504

#Create cluster

    gcloud container clusters create <cluster-name> --num-nodes <num of nodes in cluster>  --machine-type n1-standard-1  --zone <zone-name> 

    e.g. 
        gcloud container clusters create gcp-boot-demo-cluster --num-nodes 2  --machine-type n1-standard-1  --zone us-central1-c    

#get cluster credentials

    gcloud container clusters get-credentials  --zone <cluster-zone-name> <cluster-name>
    
    e.g.
        gcloud container clusters get-credentials  --zone us-central1-c	 gcp-boot-demo-cluster

#Build and run the service

    Set spring boot app profiles to "prod"
    
        e.g. 
            - edit below files
            
                1 : ..\employee-service\src\main\resources\application.yml
                2 : ..\api-gateway\src\main\resources\application.yml
            
            - add the active profile as follows 
            
                  spring:
                    profiles:
                        active:
                            - "prod"
                     
	Grant permission to run all scripts files.
	   
	   cd <path>/micro-service
	   chmod 777 *.sh
	
	Run below scripts to deploy all the applications on GKE.
	  
	  	cd <path>/micro-service    
	   ./run-gcp.sh <project-id>
	   
	   e.g.
	         cd /home/pushparaj_dhole23/micro-service
	        ./run-gcp.sh striking-shift-248504

#Endpoints to use
    Below endpoint will be available for the use once all the service gets deployed.
    
    http://<public-ip-of-api-gateway-service>:8010/employee-service/employee/ 
		
      

             

     
           

