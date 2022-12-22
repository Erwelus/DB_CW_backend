FROM amazoncorretto:11-alpine-jdk
COPY ./target/rest-0.0.1-SNAPSHOT.jar notification.jar
COPY ./.ca_certs/root.crt /root/.postgresql/root.crt
RUN chmod 600 /root/.postgresql/root.crt
ENTRYPOINT ["java","-Daws.secretKey=YCN-Cwuj3AMbf2TVqpkCUQkH4fpveZuOvHy-qy4T","-Daws.accessKeyId=YCAJExkbELdcVdaoyWt8aSfec","-jar","/rest.jar"]