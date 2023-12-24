#!/bin/bash

./gradlew bootJar

docker build -t connie/user-service:latest .
