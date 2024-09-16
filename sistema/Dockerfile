# Usar a imagem oficial do OpenJDK 21
FROM openjdk:21-jdk

# Definir o diretório de trabalho no contêiner
WORKDIR /luthieria

# Copiar todos os arquivos do diretório atual para o diretório de trabalho no contêiner
COPY . /luthieria/

# Compilar o código Java
RUN javac -d bin -sourcepath src $(ls src/**/*.java)

# Comando para rodar a aplicação
CMD ["java", "-cp", "bin", "Luthieria"]
