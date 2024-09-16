#!/bin/bash

# Parar o serviço PostgreSQL se estiver rodando fora do Docker
echo "Parando o serviço PostgreSQL..."
sudo service postgresql stop

# Parar e remover containers, redes e volumes Docker
echo "Parando e removendo containers e redes Docker..."
docker-compose down

# Recriar e reiniciar containers Docker
echo "Recriando e reiniciando containers Docker..."
docker-compose up --build --force-recreate --remove-orphans

echo "Script executado com sucesso!"