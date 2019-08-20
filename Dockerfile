FROM openjdk:8-jdk-alpine
VOLUME /tmp
VOLUME /pharbers_config
VOLUME /driver
VOLUME /logs
COPY target/lib lib
COPY target/*.jar app.jar
ENV PHA_CONF_HOME /pharbers_config
ENV DRIVER_JAR_PATH /driver/ipaas-data-driver.jar
ENV REQUEST_TOPIC DriverRequest
ENV DRIVER_FILE_PATH /tmp
ENV DRIVER_MAPPED_SIZE 1024
ENV JOB_RECALL_TOPIC job_recall
ENV JOB_RECALL_CHANNEL tm/
ENTRYPOINT ["java","-jar","/app.jar"]