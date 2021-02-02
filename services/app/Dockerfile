FROM bellsoft/liberica-openjdk-alpine-musl:11.0.3
WORKDIR /deployment/
COPY target/backend-*.jar ./app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS="-Duser.timezone=Europe/Moscow -Dfile.encoding=UTF8 -Dorg.freemarker.loggerLibrary=SLF4J"
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar $JAVA_ARGS"]