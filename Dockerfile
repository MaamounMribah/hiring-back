FROM openjdk:17-jdk

WORKDIR /app

COPY target/demo2-0.0.1-SNAPSHOT.jar /app/hiring-back.jar

EXPOSE 8085:8085

CMD ["java", "-jar", "hiring-back.jar"]