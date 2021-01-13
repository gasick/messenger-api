#!/bin/bash

mvn package -f pom.xml
podman-compose build
podman-compose down
podman-compose up -d