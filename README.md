# Core Service

> Core functional service powered by Spring Boot

[![java version][java-image]][java-url]
[![build status][travis-image]][travis-url]
[![release][release-image]][release-url]
[![license][license-image]][license-url]

[java-image]: https://img.shields.io/badge/java-%3E%3D11-brightgreen.svg?style=flat-square
[java-url]: http://www.oracle.com/technetwork/java/javase/downloads/index.html
[release-image]: https://img.shields.io/github/release/meeteor-13/core-service.svg?style=flat-square
[release-url]: https://github.com/meeteor-13/core-service/releases
[travis-image]: https://img.shields.io/travis/meeteor-13/core-service/master.svg?style=flat-square
[travis-url]: https://travis-ci.org/meeteor-13/core-service
[license-image]: https://img.shields.io/github/license/mashape/apistatus.svg?style=flat-square
[license-url]: https://github.com/meeteor-13/core-service/blob/master/LICENSE

## Technologies

* [Java](https://www.oracle.com/technetwork/java/javase/overview/index.html)
* [Maven](https://maven.apache.org/)
* [Spring](https://spring.io/)

## Usage

### Local

Run application:
```
./gradlew bootRun
```

Run tests:
```
./gradlew test
```

Build application artifact:
```
./gradlew build
```

Build application artifacts (without tests):
```
./gradlew build -x test
```

### Docker

Bootstrap project using docker-compose:
```
docker-compose up
```

Stop and remove containers, networks, images:
```
docker-compose down
```
