# base image openjdk version 8. if image not in local docker engine fetch from hub 
FROM openjdk:8

#(more useful than COPY jar) on the base image take from target/ to docker /tmp
ADD target/spring-docker-0.0.1.jar /tmp/spring-docker-0.0.1.jar


# expose port 8080 on docker container becuase springboot tomcat port runs 8080
EXPOSE 8080

#main() version of docker pattern like exec list cmd execution in c++]
#ENTRYPOINT ["java", "-jar", "/tmp/spring-docker-0.0.1.jar" ] #works

ENTRYPOINT ["/bin/sh", "-c" , "echo 192.168.56.1   stest.drf.com >> /etc/hosts && exec java -jar /tmp/spring-docker-0.0.1.jar " ]
