FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
EXPOSE 9004
ADD target/payment.jar payment.jar
ENTRYPOINT ["java","-jar","/payment.jar"]