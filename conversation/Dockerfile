FROM alpine/git as clone
WORKDIR /app

ARG username
ARG password

RUN git clone https://${username}:${password}@dev.azure.com/CLAROCOE/Apis%20CoE/_git/schema
RUN git clone https://${username}:${password}@dev.azure.com/CLAROCOE/Apis%20CoE/_git/conversation

WORKDIR /app/schema
ARG brachschema
RUN git checkout ${brachschema}

WORKDIR /app/conversation
ARG brachconversation
RUN git checkout ${brachconversation}

FROM adoptopenjdk/maven-openjdk11 as build

WORKDIR /app
COPY --from=clone /app/schema /app/schema
WORKDIR /app/schema
RUN mvn clean install -DskipTests

WORKDIR /app/conversation
COPY --from=clone /app/conversation /app/conversation
RUN mvn clean install -DskipTests

FROM openjdk:11
EXPOSE 8080
COPY --from=build /app/conversation /app/conversation
WORKDIR /app/conversation
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","target/conversation-0.0.1-SNAPSHOT.war"]