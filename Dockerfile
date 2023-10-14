
FROM maven:3.8.3-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package
EXPOSE 9596
ENTRYPOINT ["java","-jar","/home/app/target/StudentApi-0.0.1-SNAPSHOT.jar"]

#FROM node:18-alpine
#WORKDIR /app
#COPY . .
#RUN yarn install --production
#CMD ["node", "src/index.js"]
#EXPOSE 3000