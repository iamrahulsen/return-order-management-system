FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
EXPOSE 9002
ADD target/component.jar component.jar
ENTRYPOINT ["java","-jar","/component.jar"]