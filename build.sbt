// WARNING: This file requires a blank line between each entry (excluding comments). 

name := "MyApp"

organization := "com.example"

version := "0.2.0"

scalaVersion := "2.11.8"



// ----------------------------------
// common settings to all subprojects
// ----------------------------------
// Check https://www.playframework.com/documentation/2.5.x/SBTSubProjects#sharing-common-variables-and-code
// Check http://www.scala-sbt.org/0.13/docs/Multi-Project.html#Common+settings




// ----------------------
// scala compiler options
// ----------------------

// Check https://www.playframework.com/documentation/2.5.x/SBTCookbook#add-compiler-options

scalacOptions ++= Seq(
  "-feature",                   // Shows warnings in detail in the stdout
  "-language:reflectiveCalls"   // Address the warning generated on the primary route files after introducing subprojects
                                // Check https://groups.google.com/d/msg/play-framework/nNr2NdBtWuw/JfbPLaX35XcJ
)



// --------------------
// multi-project set up
// --------------------

// Check https://www.playframework.com/documentation/2.5.x/SBTSubProjects#splitting-your-web-application-into-several-parts
// Check http://www.scala-sbt.org/0.13/docs/Multi-Project.html


// Root project. Container for all the projects
lazy val root = project.in(file("."))
      .enablePlugins(PlayJava)
      .aggregate(common, admin, customer)
      .dependsOn(common, admin, customer)


// Files and libraries shared across other projects
lazy val common = project.in(file("modules/common"))
       .enablePlugins(PlayJava)


// Admin Portal
lazy val admin = project.in(file("modules/admin"))
       .enablePlugins(PlayJava)
       .dependsOn(common)
       

// Organization Portal (e.g. Customer Portal)
lazy val customer = project.in(file("modules/customer"))
       .enablePlugins(PlayJava)
       .dependsOn(common)


