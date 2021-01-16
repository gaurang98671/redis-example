FROM openjdk:11
ADD target/redis-example.jar redis-example.jar
EXPOSE 8080 
ENTRYPOINT [ "java", "-jar", "redis-example.jar" ]