FROM openjdk:8-jre-alpine
ADD target/atlas-application.jar atlas-application.jar
EXPOSE 5052
ENTRYPOINT ["java","-jar","user-application.jar"]