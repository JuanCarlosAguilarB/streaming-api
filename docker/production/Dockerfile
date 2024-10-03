# Build Stage
FROM gradle:jdk17-jammy AS build

COPY --chown=gradle:gradle ../../build.gradle settings.gradle /home/gradle/src/

COPY --chown=gradle:gradle ../../src /home/gradle/src/src

WORKDIR /home/gradle/src

RUN gradle build --no-daemon -x test

# Execution Stage
FROM azul/zulu-openjdk:17-latest

LABEL org.opencontainers.image.source = "https://github.com/JuanCarlosAguilarB/streaming-api"
LABEL org.opencontainers.image.description = "Streaming API"
LABEL org.opencontainers.image.licenses = "MIT"

COPY --from=build /home/gradle/src/build/libs/streaming-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

#ENTRYPOINT ["./wait-for-it.sh", "rabbitmq:5672", "--", "java", "-jar", "/app.jar"]
ENTRYPOINT ["java", "-jar", "/app.jar"]
