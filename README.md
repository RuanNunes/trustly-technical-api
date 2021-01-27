# trustly-technical-api project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .


# Challenge:


Develop an API that returns the total number of lines and the total number of bytes of all the files of a given public Github repository, grouped by file extension.

## Requirements:


-> Your API must be written using Java 8 or newer, ECMAscript 2015 or newer, or C# 8.0; <br>
-> Data must be retrieved from Github website by using web scraping techniques. Do not use Github’s API; <br>
-> Do not use web scraping libraries. We would like to know your ideas on how it can be done;<br>
-> Your API must support thousands of concurrent requests;<br>
-> We think it’s ok if the first request to a particular repository takes some time to respond (since you depend on Github website response times), but we don’t expect the subsequent requests to be long;<br>
-> We don’t expect to get timeout errors;<br>
-> We must understand your code and use your API without having to ask you any questions. Our primary language is English so please use it on comments and documentation;<br>
-> We’d like to see SOLID principles in your solution;<br>
You are free to choose your API contracts (parameters and response formats) but we’d like to be able to integrate it with any other existing solutions;<br>
-> You don’t need to persist any data (but feel free to do it if you want);<br>
-> e’d like to see at least one automated test;<br>
-> You must deploy your solution to a cloud provider like Amazon AWS or Heroku and send us the link to access it. It’s a plus if you publish a Docker image with your application (including its dependencies) in a registry like Docker Hub and let us know how to get it. 

## observation
this project was developed with reference to the repository
[teste](https://github.com/RuanNunes/test)
other repositories that contain folders at various levels still do not work, but are soon in operation


## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `trustly-technical-api-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/trustly-technical-api-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/trustly-technical-api-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

# RESTEasy JAX-RS

<p>A Hello World RESTEasy resource</p>

Guide: https://quarkus.io/guides/rest-json

# RESTEasy JSON serialisation using Jackson

<p>This example demonstrate RESTEasy JSON serialisation by letting you list, add and remove quark types from a list.</p>
<p><b>Quarked!</b></p>

Guide: https://quarkus.io/guides/rest-json
