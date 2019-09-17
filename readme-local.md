# employee-management-micro-services
Demo micro-service based application for employee information management 

## How to

#Build and run the service

    Set spring boot app profiles to "dev"
    
        e.g. 
            - edit below files
            
                1 : ..\employee-service\src\main\resources\application.yml
                2 : ..\api-gateway\src\main\resources\application.yml
            
            - add the active profile as follows 
            
                  spring:
                    profiles:
                        active:
                            - "dev"
                     
	create network if not exist
	
	docker network create gcp-boot-demo
	
	click on the below bat file to build and deploy all the applications on docker locally.
	  
	  	run-local.bat
	   	   
#Endpoints to use
    Below endpoint will be available for the use once all the service gets deployed.
    
    http://locahost:8010/employee-service/employee/ 
		
      

             

     
           

