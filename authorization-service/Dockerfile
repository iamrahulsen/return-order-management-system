FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
EXPOSE 9001
ADD target/auth.jar auth.jar
ENTRYPOINT ["java","-jar","/auth.jar"]