FROM maven:3.6.3-jdk-13
 
# copy the source tree and the pom.xml to our new container
COPY ./MineSweeper.Game.Api ./
 
# package our application code
RUN mvn clean package
 
# set the startup command to execute the jar
CMD ["java", "-jar", "target/MineSweeper-Game-Api.jar"]