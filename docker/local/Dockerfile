# Dockerfile
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY ./build.gradle ./gradlew ./settings.gradle ./
COPY ./gradle ./gradle

RUN ./gradlew build --no-daemon -x test || return 0

COPY ./src ./src

EXPOSE 8080

CMD ["./gradlew", "bootRun"]
