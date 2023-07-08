FROM rsunix/yourkit-openjdk17

WORKDIR /usr/src/myapp

COPY build/libs/timereaderincub-0.0.1-SNAPSHOT.jar /usr/src/myapp

CMD ["java","-jar", "/usr/src/myapp/timereaderincub-0.0.1-SNAPSHOT.jar"]
