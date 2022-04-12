#--platform=linux/amd64
FROM openjdk:17
VOLUME /tmp
COPY target/Project03---WebBaseApp-0.0.1-SNAPSHOT.jar  Project03---WebBaseApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/Project03---WebBaseApp-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080:8080
