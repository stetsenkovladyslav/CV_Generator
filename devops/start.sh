cd ..
mvn  clean package spring-boot:repackage
cd devops/
docker-compose up --force-recreate --build