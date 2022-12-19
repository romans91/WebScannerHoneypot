FROM openjdk:17
EXPOSE 8080
ADD target/web-scanner-honeypot.jar web-scanner-honeypot.jar
ENTRYPOINT ["java", "-jar","/web-scanner-honeypot.jar"]