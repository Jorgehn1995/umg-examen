FROM openjdk:17-jdk-alpine

# Añadir un volumen apuntando a /tmp
VOLUME /tmp

# Copiar el archivo JAR de la aplicación al contenedor
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar



# Exponer el puerto que la aplicación usará
EXPOSE 8080

# Ejecutar la aplicación Spring Boot
ENTRYPOINT ["java", "-jar", "/app.jar"]