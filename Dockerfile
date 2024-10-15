# Versão Maven
FROM maven:3.9.8-eclipse-temurin-21 AS build

# Cria uma pasta
RUN mkdir /opt/app

# Copia o conteudo para esta pasta
COPY . /opt/app

# Mudança do diretório padrão dentro do container
WORKDIR /opt/app

# Limpeza e build do código Java
RUN mvn clean package

# Cria nova imagem
FROM eclipse-temurin:21-jre-alpine

RUN mkdir /opt/app

# Copia o conteudo gerado na imagem em BUILD
COPY --from=build  /opt/app/target/alertempo-0.0.1-SNAPSHOT.jar /opt/app/app.jar

WORKDIR /opt/app

# Define o ambiente a ser utilizado. Abaixo utilizaremos o ambiente de PROD
ENV PROFILE=dev

EXPOSE 8080

ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}", "-jar", "app.jar"]
