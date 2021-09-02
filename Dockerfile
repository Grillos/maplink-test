FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/maplink-test-0.0.1-SNAPSHOT.jar maplink-test.jar
ADD target/maplink-test-0.0.1-SNAPSHOT.jar maplink-test.jar
ENTRYPOINT ["java","-jar","/maplink-test.jar"]
