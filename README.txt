mvn clean package
docker build -t myorg/myapp .
docker run --env DB_PRODUCTS_DB=products --env DB_PRODUCTS_HOST=[ip] --env DB_PRODUCTS_PORT=5432 --env DB_PRODUCTS_USERNAME=[usuario_de_banco] --env DB_PPRODUCTS_PASSWORD=[senha]]  -p 8080:8080 myorg/myapp

Import into Postman
SpringBootProducts.postman_collection.json