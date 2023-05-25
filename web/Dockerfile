FROM ubuntu as base
RUN apt update
RUN apt install wget -y

FROM base as base2
RUN apt install maven -y
RUN wget https://download.oracle.com/java/20/latest/jdk-20_linux-x64_bin.deb
RUN apt install ./jdk-20_linux-x64_bin.deb -y
RUN update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk-20/bin/java 1
RUN update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/jdk-20/bin/javac 1
RUN update-alternatives --install /usr/bin/jar jar /usr/lib/jvm/jdk-20/bin/jar 1
RUN update-alternatives --set java /usr/lib/jvm/jdk-20/bin/java
RUN update-alternatives --set javac /usr/lib/jvm/jdk-20/bin/javac
RUN update-alternatives --set jar /usr/lib/jvm/jdk-20/bin/jar
ENV JAVA_HOME=/usr/lib/jvm/jdk-20
ENV J2SDKDIR=/usr/lib/jvm/jdk-20
ENV J2REDIR=/usr/lib/jvm/jdk-20
ENV PATH=$PATH:/usr/lib/jvm/jdk-20/bin:/usr/lib/jvm/jdk-20/db/bin
ENV DERBY_HOME=/usr/lib/jvm/jdk-20/db

FROM base2 as build
WORKDIR /build
COPY pom.xml .
COPY src src
RUN mvn clean package

#
# Package stage
#
FROM build
WORKDIR /build
CMD java -jar target/web-0.0.1-SNAPSHOT.jar
