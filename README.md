## Web Scanner Honeypot
Slows down bots that crawl websites scanning for vulnerabilities by responding to all GET requests with a chunked transfer encoding response that contains a slow and  infinite stream of text.
### Requires
- Java 17
- Maven
- Docker
### Running instructions:
1. mvn clean install
2. docker build -t web-scanner-honeypot.jar .
3. docker run -p 8080:8080 web-scanner-honeypot.jar
4. curl localhost:8080

