FROM rsunix/yourkit-openjdk17

WORKDIR /usr/src/myapp

COPY . .

RUN javac TimereaderincubApplication.java


CMD ["java", "TimereaderincubApplication"]