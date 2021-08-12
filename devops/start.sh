#cd ..
#mvn package -DskipTests
cd devops/
docker-compose up --force-recreate --build