name := "MyApplication-common"

version := "BUILD"

// MANAGED DEPENDENCIES
// Each library below is automatically downloaded from one of the resolvers defined in sbt
// See http://www.scala-sbt.org/0.13.2/docs/Getting-Started/Library-Dependencies.html#the-librarydependencies-key
// Libraries in this project are available to all projects
libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  "org.postgresql" % "postgresql" % "9.3-1101-jdbc41",
  "org.seleniumhq.selenium" % "selenium-java" % "2.41.0",
  "com.github.tototoshi" %% "play-flyway" % "1.0.3",
  "com.twilio.sdk" % "twilio-java-sdk" % "3.4.1"
  // Add additional dependencies here; uses Apache Ivy info.
)

play.Project.playJavaSettings