#!/bin/bash

DESTINO="bin"

DRIVER_PATH="/usr/local/lib/postgresql-42.6.0.jar"

rm -rf $DESTINO
mkdir -p $DESTINO

javac -d $DESTINO -cp src:$DRIVER_PATH src/**/*.java

cp -r src/gui/arquivos $DESTINO/gui/

if [ $? -eq 0 ]; then
  echo "Compilação concluída com sucesso!"
  
  java -cp $DESTINO:$DRIVER_PATH inicio.Luthieria
else
  echo "Erro na compilação."
fi
