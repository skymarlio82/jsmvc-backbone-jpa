FROM openjdk:8
MAINTAINER skymarlio
VOLUME /tmp
ADD jsmvc-backbone-jpa-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]