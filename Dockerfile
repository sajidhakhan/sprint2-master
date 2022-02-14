FROM openjdk
WORKDIR usr/lib
ENV MONGO_DATABASE=productDbTesting
ENV MONGO_URL=mongodb://localhost:27017/productDbTesting
ADD ./target/testing-0.0.1-SNAPSHOT.jar /usr/lib/testing-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","testing-0.0.1-SNAPSHOT.jar"]