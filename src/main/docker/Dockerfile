FROM postgres:latest

ENV POSTGRES_USER=student
ENV POSTGRES_PASSWORD=student
ENV POSTGRES_DB=mydb

EXPOSE 5435

docker build -t my_postgres .
docker run -d --name gateway_pg -p 5435:5432 my_postgres