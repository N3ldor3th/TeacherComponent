# build
to build it with gradle, you can use the gradle wrapper without actually having the gradle installed

./gradlew clean build

# run

./gradlew bootRun

# API documentation

localhost:8080/swagger-ui.html

# test data

as this project is using in-memory H2 db, there is data loaded during the start of the application

# Teacher example in json

{
    "email": "NovakJan@gmail.com",
    "skype": "novakjan95",
    "name": "Jan",
    "surname": "Novak",
    "country": "Czech Republic",
    "languages": [
        {
            "code": "en",
            "name": "English"
        },
        {
            "code": "cs",
            "name": "Czech"
        }
    ],
    "timeSlots": [
        {
            "weekDay": "SATURDAY",
            "startTime": "2020-04-11T16:09:29.475238",
            "endTime": "2020-04-11T17:39:29.475238"
        },
        {
            "weekDay": "FRIDAY",
            "startTime": "2020-04-10T16:09:29.473243",
            "endTime": "2020-04-10T17:09:29.475238"
        }
    ]
}

# dockerization

FROM openjdk:11-jdk-stretch
ARG JAR_FILE
COPY ${JAR_FILE} /

EXPOSE 5000

CMD java $JAVA_OPTS -jar /TeacherComponent.jar

afterwards "docker build" should be enough



