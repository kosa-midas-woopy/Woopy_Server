FROM openjdk:11-jre-slim
COPY ./build/libs/*.jar app.jar
ARG JDBC_URL
ARG DB_USER
ARG DB_PWD
ARG JWT_SECRET_KEY

ENV JDBC_URL=${JDBC_URL}
ENV DB_USER=${DB_USER}
ENV DB_PASSWORD=${DB_PWD}
ENV JWT_SECRET=${JWT_SECRET}

ENTRYPOINT ["java","-jar","-Dspring.datasource.url=${JDBC_URL}","-Dspring.datasource.username=${DB_USER}", "-Dspring.jwt.secret-key=${JWT_SECRET_KEY}", "-Dspring.datasource.password=${DB_PWD}",  "/app.jar"]