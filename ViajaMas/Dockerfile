FROM openjdk:22-jdk-slim
ARG JAR_FILE=target/app_viajamas-0.0.1.jar
COPY ${JAR_FILE} app_viajamas.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_viajamas.jar"]
