# BUILD
FROM gradle:7-jdk18-alpine AS gradle
WORKDIR /home/gradle/project

COPY . .
RUN gradle build --no-daemon

# RUN
FROM openjdk:18-jdk-alpine
WORKDIR /usr/app

COPY --from=gradle /home/gradle/project/build/libs/cloudConfigServer.jar app.jar
CMD ["java", "-jar", "app.jar"]
