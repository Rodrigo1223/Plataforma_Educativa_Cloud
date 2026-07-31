# Etapa 1: Compilación usando Java 21 nativo
FROM maven:3.9.6-eclipse-temurin-21 AS buildstage

WORKDIR /app

# Copiar el archivo de configuración de dependencias
COPY pom.xml .

# Copiar el código fuente del proyecto educativo
COPY src ./src

# Compilar omitiendo las pruebas unitarias para acelerar el despliegue automático
RUN mvn clean package -DskipTests

# Etapa 2: Entorno de ejecución ligero con Java 21
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Copia el JAR generado asegurando el comodín para evitar fallos por cambios de versión
COPY --from=buildstage /app/target/microservicio-*.jar /app/app.jar

# Exponer el puerto configurado en application.properties
EXPOSE 8080

# Comando optimizado para iniciar el microservicio
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
