#!/bin/bash

./gradlew bootJar

docker build -t connie/store-display-service:latest .
