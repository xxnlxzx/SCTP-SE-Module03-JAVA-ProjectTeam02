## This is the Java Development Kit Version

FROM eclipse-temurin:17.0.7_7-jdk

# Location of the app
WORKDIR /app

# Copy the Java application JAR file from the target directory
COPY target/SCTP-SE-MODULE03-JAVA-PROJECTTEAM02-0.0.1.jar .

CMD ["java", "-jar", "booking-app.jar"]


# mvn clean package will compile your code and also package it. 
# For example, if your pom says the project is a jar, 
# it will create a jar for you when you package it and put it somewhere in the target directory (by default)
