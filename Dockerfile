FROM eclipse-temurin:17.0.7_7-jdk

# Location of the app
WORKDIR /app

# Find the java file that is created when we run mvn clean package
COPY target/SCTP-SE-MODULE03-JAVA-PROJECTTEAM02-0.0.1.jar booking-app.jar

CMD ["java", "-jar", "booking-app.jar"]

# .dockerignore
# Example: exclude node_modules, .git, .DS_Store, etc.
# node_modules
# .git
# .DS_Store
# Add other exclusions if needed, but make sure target/ is NOT excluded.
