mvn clean package
docker build -t leandrofabriciosamento/springboot .
docker run myorg/myapp

Import into Postman
SpringBootProducts.postman_collection.json

Kubernetes

Criar um ConfigMap:
apiVersion: v1
kind: ConfigMap
metadata:
  name: configmap-leandro-springboot
data:
#  DB_PRODUCTS_DB: "products"
#  DB_PRODUCTS_HOST: "host_database"
#  DB_PRODUCTS_USERNAME: "username_database"
#  DB_PRODUCTS_PASSWORD: "password_database"
#  DB_PRODUCTS_PORT: "port_database"