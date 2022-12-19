## Web Scanner Honeypot
### Requires
- Java 17
- Maven
- Docker
### Running instructions:
1. mvn clean install
2. docker build -t web-scanner-honeypot.jar .
3. docker run -p 8080:8080 web-scanner-honeypot.jar
4. curl localhost:8080

