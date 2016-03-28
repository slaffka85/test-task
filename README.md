test-task: Example Using Multiple Java EE 7 Technologies Deployed as an EAR
==============================================================================================
Author: Viacheslav Tcapaev
Level: Intermediate
Technologies: EAR, JPA, jQuery

System requirements
-------------------

All you need to build this project is Java 8.0 (Java SDK 1.8) or better, Maven 3.0.5 or better.

The application this project produces is designed to be run on JBoss WildFly 10.

Start JBoss WildFly with the Web Profile
-------------------------

1. Open a command line and navigate to the root of the JBoss server directory.
2. The following shows the command line to start the server with the web profile:

        For Linux:   JBOSS_HOME/bin/standalone.sh
        For Windows: JBOSS_HOME\bin\standalone.bat

 
Build and Deploy the Quickstart
-------------------------

_NOTE: The following build command assumes you have configured your Maven user settings. If you have not, you must include Maven setting arguments on the command line.

1. Set environment variable %JBOSS_HOME
2. Make sure you have started the JBoss Server as described above.
3. Open a command line and navigate to the root directory of this quickstart.
4. Type this command to build and deploy the archive:

        mvn clean package wildfly:deploy
        or
        mvn clean package -P copy-to-wildfly

5. This will deploy `target/test-task.ear` to the running instance of the server.


Access the application 
---------------------

The application will be running at the following URL: <http://localhost:8080/test-task-web>.

Undeploy the Archive
--------------------

1. Make sure you have started the JBoss Server as described above.
2. Open a command line and navigate to the root directory of this quickstart.
3. When you are finished testing, type this command to undeploy the archive:

        mvn wildfly:undeploy
