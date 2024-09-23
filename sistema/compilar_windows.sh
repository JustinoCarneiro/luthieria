#!/bin/bash

# Diretório de destino para os arquivos compilados
DESTINO="bin"

# Caminho para o driver JDBC do PostgreSQL (ajuste o caminho se necessário)
DRIVER_PATH="C:/Program Files/PostgreSQL/16/postgresql-42.6.2.jar"

rm -rf $DESTINO
mkdir -p $DESTINO

# Compilar todos os arquivos .java dentro de src e subdiretórios
javac -d $DESTINO -cp "src;$DRIVER_PATH" src/**/*.java

# Copiar arquivos de recursos (imagens, etc.) para o diretório de destino
cp -r src/gui/arquivos $DESTINO/gui/

# Verificar se a compilação foi bem-sucedida antes de rodar o programa
if [ $? -eq 0 ]; then
  echo "Compilação concluída com sucesso!"
  
  # Executar o programa principal (classe Luthieria) com o driver JDBC no classpath
  java -cp "$DESTINO;$DRIVER_PATH" inicio.Luthieria
else
  echo "Erro na compilação."
fi
