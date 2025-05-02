# spécifie l'image de base à utiliser pour construire l'image
FROM openjdk:21-jdk

# répertoire de travail
WORKDIR /app

# copie le fichier JAR
COPY target/trikount-backend-0.0.1-SNAPSHOT.jar app.jar

# Conteneur écoute sur port 8080
EXPOSE 8080

# commande à exécuter
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
