# rest-mail-sender
Complete example with mail and file attachment fired by rest service

#### Set the email sender on the file: application.properties

`
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=USUARIO@gmail.com
spring.mail.password=USA_TU_PASSWORD
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.connectiontimeout=5000
spring.mail.properties.mail.smtp.timeout=5000
spring.mail.properties.mail.smtp.writetimeout=5000
`

#### 1) To compile the application run on command line:

`
gradle build
`

#### 2) To run the application run on command line:

`
java -jar build/libs/rest-mail-sender-0.0.1-SNAPSHOT.jar
`

To verify that the application it is running; see the console last lines of the output:

`
2017-10-20 15:50:16.711  INFO 38650 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2017-10-20 15:50:16.784  INFO 38650 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2017-10-20 15:50:16.789  INFO 38650 --- [           main] o.f.r.RestMailSenderApplication          : Started RestMailSenderApplication in 2.693 seconds (JVM running for 3.124)
2017-10-20 15:50:21.466  INFO 38650 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring FrameworkServlet 'dispatcherServlet'
2017-10-20 15:50:21.467  INFO 38650 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization started
2017-10-20 15:50:21.482  INFO 38650 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization completed in 15 ms
`

And a welcome page it is launched on on your browser go to the following URL: http://localhost:8080/ 

#### 3) To execute a post rest to send an email refer to:

#####3.1) Set the email sender on the file: application.properties

`
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=lasalazar@gmail.com
spring.mail.password=USA_TU_PASSWORD
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.connectiontimeout=5000
spring.mail.properties.mail.smtp.timeout=5000
spring.mail.properties.mail.smtp.writetimeout=5000
`

#### 4) Sample post to rest service: http://localhost:8080/v1/send-mail/with-attachment

{"to" : "mail@gmail.com",
 "subject" : "PRUEBA ENVIO",
 "message"  : "ASDASDASDASDASDAS",
 "pathFileToAttach" : "/sample.png"
}