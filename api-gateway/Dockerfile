FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
EXPOSE 9005
ADD target/api.jar api.jar
ENTRYPOINT ["java","-jar","/api.jar"]