#
# Build
#
FROM eclipse-temurin:17-jdk AS build

RUN apt-get update
RUN apt-get install -y maven

COPY src /home/app/src
COPY pom.xml /home/app
COPY .mvn/ /home/app/.mvn
COPY mvnw pom.xml /home/app/
RUN mvn -f /home/app/pom.xml clean package
#
# Package stage
#
FROM eclipse-temurin:17-jdk
COPY --from=build /home/app/target/restaurant-0.0.1-SNAPSHOT.jar /usr/local/lib/restaurant.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/restaurant.jar"]