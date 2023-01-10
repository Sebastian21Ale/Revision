This will guide you on the process of deploying analytics microservice on kubernetes containers 

#### build jar 

    mvn clean install

#### build docker image

    docker build . -t analytics-claro

#### apply kubernetes deploy
    
    kubectl apply -f analytics-deployment.yaml

### Troubleshooting

Getting BUILD FAILURE message while running `mvn clean install`.

In case you having build issues you can skip tests execution using:

#### build jar without executing tests

    mvn clean install -DskipTests

Unable to start kubernetes container

#### check kubernetes logs
    
    kubectl logs -n claro <pod> --tail=1000

#### Delete old deployment

    kubectl delete deployment -n claro claro-analytics-app

#### Delete old service

    kubectl delete service -n claro claro-analytics-service