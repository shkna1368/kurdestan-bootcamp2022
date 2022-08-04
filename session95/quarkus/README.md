# Quarkus-CRUD
Quarkus-CRUD
# SPRING DATA- SWAGGER  LOMBOK-MAPSTRUCT -POSTGRESS

# for deploy in kubernetes:
mvn quarkus:add-extension -Dextensions="container-image-jib" <br/>
mvn clean package <br/>
change below changes in  kubernetes.json and  kubernetes.yml: <br/>
"type" : "NodePort" <br/>
"imagePullPolicy" : "NEVER" <br/>


mvn clean package -define quarkus.container-image.build=true <br/>
kubectl apply -f target/kubernetes/kubernetes.json <br/>
