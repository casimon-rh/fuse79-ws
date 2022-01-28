#!/bin/bash
docker build -f docker/java.dockerfile --compress -t fuse-rest . && \
docker run -e BACKEND_URL="localhost:8082" --rm -p 8080:8080 -it fuse-rest