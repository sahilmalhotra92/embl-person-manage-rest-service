FROM openjdk:8-jdk-alpine
RUN addgroup -S embl && adduser -S embl -G embl
USER embl:embl
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} embl-person-manage-rest.jar
ENTRYPOINT ["java","-jar","/embl-person-manage-rest.jar"]

EXPOSE 8080
