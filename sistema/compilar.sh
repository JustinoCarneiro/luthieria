#!/bin/bash

# Diretório de destino para os arquivos compilados
DESTINO="bin"

# Caminho para o driver JDBC do PostgreSQL
DRIVER_PATH="/usr/local/lib/postgresql-42.6.0.jar"

# Compilar todos os arquivos .java dentro de src e também os que estão diretamente em src
javac -d $DESTINO -cp src:$DRIVER_PATH src/**/*.java src/*.java

# Verificar se a compilação foi bem-sucedida antes de rodar o programa
if [ $? -eq 0 ]; then
  echo "Compilação concluída com sucesso!"
  
  # Executar o programa principal (classe Luthieria) com o driver JDBC no classpath
  java -cp $DESTINO:$DRIVER_PATH Luthieria
else
  echo "Erro na compilação."
fi
