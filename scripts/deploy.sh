#!/usr/bin/env bash

docker images
docker tag openapi-generator-cli-custom $DOCKER_USERNAME/openapi-generator-cli-custom:4.2.2
docker push $DOCKER_USERNAME/openapi-generator-cli-custom:4.2.2
