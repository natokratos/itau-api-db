FROM centos:latest

RUN yum install java-1.8.0-openjdk.x86_64 -y

ADD itau-api-db*.jar /root/itau-api-db.jar

EXPOSE 9000

ENTRYPOINT [ "bash", "-c", "java -jar /root/itau-api-db.jar" ]