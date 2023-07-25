FROM eclipse-temurin:17.0.7_7-jdk

# Location of the app
WORKDIR /app

# Copy the Java application JAR file from the target directory
COPY target/SCTP-SE-MODULE03-JAVA-PROJECTTEAM02-0.0.1.jar .

CMD ["java", "-jar", "SCTP-SE-MODULE03-JAVA-PROJECTTEAM02-0.0.1.jar"]

# .dockerignore
# Example: exclude node_modules, .git, .DS_Store, etc.
# node_modules
# .git
# .DS_Store
# Add other exclusions if needed, but make sure target/ is NOT excluded.
