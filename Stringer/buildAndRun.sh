#!/bin/sh
mvn clean package && docker build -t jeroen.school.dea/Stringer .
docker rm -f Stringer || true && docker run -d -p 8080:8080 -p 4848:4848 --name Stringer jeroen.school.dea/Stringer 
