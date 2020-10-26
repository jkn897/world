FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/Boot-0.0.1-SNAPSHOT.war app.war
ENTRYPOINT ["java","-jar","/app.war"]