FROM java:8
WORKDIR /application
ADD ./target/messanger-api-0.0.1-SNAPSHOT.jar /application/app.jar
CMD java -jar /application/app.jar
