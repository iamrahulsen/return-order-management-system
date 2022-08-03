FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
EXPOSE 9003
ADD target/package.jar package.jar
ENTRYPOINT ["java","-jar","/package.jar"]