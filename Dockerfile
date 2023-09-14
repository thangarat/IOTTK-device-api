FROM maven AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -e -f /usr/src/app/pom.xml clean install -Dmaven.test.skip=true package
FROM openjdk
COPY --from=build /usr/src/app/target/OCI-PAI-API-0.0.1-SNAPSHOT.jar /usr/app/OCI-PAI-API-0.0.1-SNAPSHOT.jar 
EXPOSE 80
ENTRYPOINT ["java","-jar","/usr/app/OCI-PAI-API-0.0.1-SNAPSHOT.jar"]
