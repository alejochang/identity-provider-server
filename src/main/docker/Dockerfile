FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD identity-provider-server-1.0.0.jar app2.jar
RUN sh -c 'touch /app2.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app2.jar"]