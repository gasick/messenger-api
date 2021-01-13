#!/bin/bash

#curl -H "Content-Type: application/json" -X POST -d '{"username":"kevin.stacey","phoneNumber":"5472457893","password":"Hello123"}' http://localhost:8080/users/registrations
#/bin/bash /home/gasick/Repos/kotlin/messanger-api/curl.sh '{"username":"kevin.stasya","phoneNumber":"5472457893","password":"Hello123"}'
curl -H "Content-Type: application/json" -X POST -d $* http://localhost:8080/users/registrations
