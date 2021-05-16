Just a stub service for investigating docker/kubernetes/CI etc. 

To run 

## Option 1: 

`docker-compose up` 

Requests on localhost:8080


## Option 2: Minikube

- `minikube start` 
- `kubectl apply -f deployment.yaml` 
- `kubectl apply -f service.yaml` 
- `kubectl port-forward service/hello-spring-boot 8080:8080` 

Then localhost:8080 again
