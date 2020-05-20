FROM openjdk:8
MAINTAINER aman bains
ADD /*.jar viafoura-anagram.jar
ENTRYPOINT ["java", "-jar", "/viafoura-anagram.jar"]
EXPOSE 8080
