step 0:
-------
create springboot app. mvn install. [test with curl/chrome if works on desktop]. don't do mvn clean because target/exec.jar needed
to add inside docker image

step 1: Create Dockerfile:
------------------
# base image openjdk version 8. if image not in local docker engine fetch from hub 
FROM openjdk:8

#(more useful than COPY jar) on the base image take from target/ to docker /tmp
ADD target/spring-docker-0.0.1.jar /tmp/spring-docker-0.0.1.jar

# expose port 8080 on docker container becuase springboot tomcat port runs 8080
EXPOSE 8080

#main() version of docker pattern like exec list cmd execution in c++]
ENTRYPOINT ["java", "-jar", "/tmp/spring-docker-0.0.1.jar" ]

steps after writing Docker file.
Step 2: create image
---------------------
--I give a tag name (docker-springboot) to the image. The dot (.) let docker search "Dockerfile" in current(.) directory. -f <dock-fname>
--I am here in the directory path before doing docker build
C:\Users\sdass\STSworkspace\spring-docker>
|
|--Dockerfile
|
\---target
    |--spring-docker-0.0.1.jar

Step 3:a-b-c prep docker
-------------------
>quick-start docker by double clicking icon
>docker-machine ip
192.168.99.100

#CRITICAL STEP FOR TESTING
notepad .../etc/hosts file with admin right add the entry below
192.168.99.100 dockerdev

step 4: build docker image
----------------------
spring-docker>docker build  -t docker-springboot .

Step 5: create Docker container and run from image (name same as above) maping port host to dock-container. host-port:docker-port
------------------------------------------
spring-docker>docker run -p 8080:8080 docker-springboot. Effect is curl is on 8080 ::curl -v  http://dockerdev:9090/hi

spring-docker>docker run -p 9090:8080 docker-springboot
I also changed to the following. host port 9090 and docker port 8080. Effect is: curl is on 9090 ::curl -v  http://dockerdev:9090/hi
--either of these will start the springboot app

Step 6: test with curl
-----------------------
Now test with curl as above. Works
curl is on 9090 ::curl -v  http://dockerdev:9090/hi
output on docker container window
2019-11-19 14:00:52.761  INFO 1 --- [nio-8080-exec-1] com.docker.springdocker.Ho
meController   : sayHello()...q
