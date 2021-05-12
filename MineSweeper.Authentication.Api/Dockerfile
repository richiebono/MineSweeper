FROM adoptopenjdk/openjdk11:alpine-jre

# copy the source tree and the pom.xml to our new container
COPY ./MineSweeper-Authentication-Api/target/*.jar ./

# package our application code
RUN mvn clean package
 
# set the startup command to execute the jar
CMD ["java", "-jar", "target/MineSweeper-Authentication-Api.jar"]