# Running example in docker desktop 

#### Steps to build
1. Following only necessary if you are using docker file for build  
    > docker build -t contacts-app .  
    > Or Run following in sb-docker-contact-service folder.  
    > gradlew bootBuildImage  

1. List Images
   > docker images | grep contact

1. Run following in sb-docker-contact-ui folder to build ui container image  
   gradlew bootBuildImage

1. Run app using docker compose  
   > docker compose -f docker-compose.yaml up  
   > docker compose -f docker-compose.yaml down  
   
1. Run using docker commands
   > docker run -d --name sb-docker-contact-ui --rm -p 8080:8080   
   -e CONTACTS_SERVER=http://host.docker.internal:8080/contacts 
   sb-docker-contact-ui  
