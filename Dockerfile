
#
# Build stage
#
FROM maven:3.8.3-openjdk-17-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM maven:3.8.3-openjdk-17-slim
COPY --from=build /home/app/target/converter-api-0.0.1-SNAPSHOT.jar /usr/local/lib/converter-api.jar
EXPOSE 8080
# Establecer variable de entorno PORT
ENV PORT 8080

ENTRYPOINT ["java","-jar","/usr/local/lib/converter-api.jar"]