mvn clean package
docker build -t leandrofabriciosamento/springboot .
docker run --env DB_PRODUCTS_DB=products --env DB_PRODUCTS_HOST=[ip] --env DB_PRODUCTS_PORT=5432 --env DB_PRODUCTS_USERNAME=[usuario_de_banco] --env DB_PPRODUCTS_PASSWORD=[senha]  -p 8080:8080 myorg/myapp

Import into Postman
SpringBootProducts.postman_collection.json

Kubernetes

Criar um ConfigMap:
apiVersion: v1
kind: ConfigMap
metadata:
  name: configmap-leandro-springboot
data:
  DB_PRODUCTS_DB: "products"
  DB_PRODUCTS_HOST: "host_database"
  DB_PRODUCTS_USERNAME: "username_database"
  DB_PRODUCTS_PASSWORD: "password_database"
  DB_PRODUCTS_PORT: "port_database"