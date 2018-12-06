FROM openjdk:8-jdk-alpine

MAINTAINER Pushkar <pushkar.adsule@bitwiseglobal.com>

ARG VCS_REF
ARG BUILD_DATE

# Metadata
LABEL org.label-schema.vcs-ref=$VCS_REF \
      org.label-schema.vcs-url="https://github.com/pushkar-bitwise/spring-demo" \
      org.label-schema.build-date=$BUILD_DATE \
      org.label-schema.docker.dockerfile="/Dockerfile"

ENV GIT_SHA $VCS_REF 
ENV BUILD_DATE $BUILD_DATE

EXPOSE 8080
#install Spring Boot artifact
VOLUME /tmp

COPY target/unit-testing-0.0.2-SNAPSHOT.jar springdemo.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/springdemo.jar"]
