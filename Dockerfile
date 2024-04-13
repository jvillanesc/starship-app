FROM openjdk:17-alpine
WORKDIR /home
COPY /build/libs/starship-app.jar starship-app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "starship-app.jar"]
