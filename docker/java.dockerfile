FROM maven:3.6.3 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY . .
RUN mvn package

FROM registry.access.redhat.com/ubi8/openjdk-8-runtime:1.9
COPY --from=builder /app/target/fuse-rest-rh.jar .
CMD ["java","-jar","fuse-rest-rh.jar"]