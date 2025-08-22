# Docker Multi‑Stage & Distroless (Java 21)
Build JAR:
```
mvn -q -DskipTests package
```
Multi‑stage image:
```
docker build -f Dockerfile.multistage -t hello-app:ms .
docker run --rm hello-app:ms
```
Distroless image:
```
docker build -f Dockerfile.distroless -t hello-app:distroless .
docker run --rm hello-app:distroless
```
