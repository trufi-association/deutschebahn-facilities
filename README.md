# Deutschebahn Fasta/facilities API proxy

This is a small Spring Boot project set up to store a cache/mirror of the
DeutscheBahn Fasta facilities API, which can be found at
https://developer.deutschebahn.com/store/apis/info?name=FaSta-Station_Facilities_Status&version=v2&provider=DBOpenData#!

## To get it to run
You need to add your access token for the Deutschebahn API to the `application.properties` file, like this:
```
accessToken=28742347927398619823762387628346
```
**BEFORE** building the .jar artifact.

The resulting JAR will startup the server on its own, and can be hosted directly on a server or in a Docker container (openjdk:11-jdk was tested).

## To reformat the code
If you make changes, to reformat the code, you can run:
```shell script
./gradlew spotlessApply
```
This will make the build not fail because of styling problems, and enforces a consistent coding style on the project.
