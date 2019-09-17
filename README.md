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
	
	   chmod 777 *.sh
	
	Run below scripts to deploy all the applications on GKE.
	  	     
	   ./run-gcp.sh <project-id>
	   
	   e.g. 
	        ./run-gcp.sh striking-shift-248504
		
      

             

     
           

