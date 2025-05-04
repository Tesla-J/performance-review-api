# Multi-stage build para desenvolvimento e produção
# Estágio 1: Build comum
FROM gradle:jdk17-alpine AS builder

WORKDIR /app

COPY build.gradle.kts settings.gradle.kts ./
RUN gradle dependencies --no-daemon

COPY src ./src
RUN gradle build --no-daemon

# Estágio 2: Desenvolvimento
FROM gradle:jdk17-alpine AS dev

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar
COPY . .

RUN gradle wrapper

EXPOSE 8080

CMD ["./gradlew", "bootRun", "--continuous", "--build-cache"]

# Estágio 3: Produção
FROM eclipse-temurin:17-jre-jammy AS prod

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

RUN groupadd -r spring && useradd -r -g spring spring \
    && chown spring:spring app.jar
USER spring

EXPOSE 8080

ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]