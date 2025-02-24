# Overview

This project is a microservice application, designed to manage schools and students. For now, it allows you to perform CRUD operations.

## How to run this project ? 

1. Set Environment variables 
You can add this .env file at the root, at the same location as docker-compose.yml file, you are free to modify values : 

```  
POSTGRES_USER=myuser
POSTGRES_PASSWORD=1234
POSTGRES_PORT=5432

PGADMIN_DEFAULT_EMAIL=admin@email.com
PGADMIN_DEFAULT_PASSWORD=1234
PGADMIN_PORT=80

```  

2. Start Docker services
To start Docker services, you can start Docker Desktop and run in terminal :

```  
docker compose up
```  


