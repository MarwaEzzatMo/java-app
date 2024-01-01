FROM openjdk:22-ea-28-jdk-oracle

EXPOSE 8080

COPY . /usr/app/
WORKDIR /usr/app

CMD java -jar java-maven-app-*.jar


