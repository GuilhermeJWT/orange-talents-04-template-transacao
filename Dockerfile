FROM openjdk:11-jdk
LABEL maintainer="Guilherme Joaquim dos Santos"
ADD target/transacao.jar transacao.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/transacao.jar"]