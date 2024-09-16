# Usar uma imagem do OpenJDK baseada em Debian/Ubuntu
FROM openjdk:21-jdk-slim

# Definir o diretório de trabalho no contêiner
WORKDIR /luthieria

# Copiar todos os arquivos do diretório atual para o diretório de trabalho no contêiner
COPY . /luthieria/

# Instalar o wget e baixar o driver JDBC PostgreSQL
RUN apt-get update && apt-get install -y wget && \
    wget https://repo1.maven.org/maven2/org/postgresql/postgresql/42.6.0/postgresql-42.6.0.jar -P /usr/local/lib/

# Limpar diretório bin e compilar o código Java
RUN rm -rf bin && mkdir bin && \
    javac -d bin -sourcepath src $(find src -name "*.java")

# Comando para rodar a aplicação
CMD ["java", "-cp", "bin:/usr/local/lib/postgresql-42.6.0.jar", "Luthieria"]