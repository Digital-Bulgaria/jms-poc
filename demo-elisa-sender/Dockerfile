FROM java:8-jre
ADD ./build/libs/demo-elisa-sender.jar app.jar

ENTRYPOINT ["sh", "-c", "java -Xmx256m -jar /app.jar"]