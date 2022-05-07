FROM openjdk:17-jdk-alpine
EXPOSE 8080
ADD build/libs/b8l2t1-0.0.1-SNAPSHOT.jar springbootapp.jar
ENTRYPOINT ["java","-jar","/springbootapp.jar"]