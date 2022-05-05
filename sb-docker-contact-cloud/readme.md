# Deploy using kubectl

#### Seperate manifest for each component  
> kubectl apply -f k8s-simple-app.yaml  
> kubectl apply -f k8s-service-app.yaml  
> kubectl apply -f k8s-simple-ui.yaml  
> kubectl apply -f k8s-service-ui.yaml  

> kubectl delete -f k8s-service-ui.yaml  
> kubectl delete -f k8s-simple-ui.yaml  
> kubectl delete -f k8s-service-app.yaml  
> kubectl delete -f k8s-simple-app.yaml  

#### One manifest with all components 
> kubectl apply -f k8s-app-deployment.yaml  
> kubectl apply -f k8s-app-ui-deployment.yaml  

> kubectl delete -f k8s-app-ui-deployment.yaml  
>  kubectl delete -f k8s-app-deployment.yaml  
