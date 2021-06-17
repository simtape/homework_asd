FROM openjdk:11

RUN apt-get update
RUN apt install curl
RUN apt-get install -y libxrender1 libxtst6 libxi6

RUN curl -L -H "Accept: application/vnd.github.v3+json" -H "Authorization: token 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" https://api.github.com/repos/simtape/homework_asd/actions/artifacts/53606305/zip --output homework.zip

RUN unzip homework.zip

CMD ["java",  "-jar", "162967_SimoneCassetta_Homework_Qualita-1.0-SNAPSHOT.jar"]