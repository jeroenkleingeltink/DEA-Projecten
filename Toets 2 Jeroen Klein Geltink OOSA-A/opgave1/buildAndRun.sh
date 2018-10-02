#!/bin/sh
mvn clean package && docker build -t nl.oose.jeroenkleingeltink/toetspatterns .
docker rm -f toetspatterns || true && docker run -d -p 8080:8080 -p 4848:4848 --name toetspatterns nl.oose.jeroenkleingeltink/toetspatterns 
