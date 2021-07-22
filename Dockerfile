FROM openjdk:11
VOLUME /tmp
ADD target/codingchallenge-1.0-SNAPSHOT.jar codingchallenge-1.0-SNAPSHOT.jar
CMD java -jar codingchallenge-1.0-SNAPSHOT.jar
