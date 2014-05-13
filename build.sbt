//
// This file is used by sbt / Play Framework to drive all build-related properties of Aragorn
//
// WARNING: This file requires a blank line between each entry (excluding comments); this is because scala does not use ";" so blank line is how sbt understands next command
//

import org.sbtidea.SbtIdeaPlugin._
import org.flywaydb.sbt.FlywayPlugin._

// COMMON PROJECT SETTINGS

// Project Name. Used to identify root project.
name := "MyApplicationName"

// When we package up for distribution, the file is named MyApplicationName-BUILD.
version := "SNAPSHOT"

// RESOLVERS
// sbt will use these resolvers to download the libraries above.
// To see ALL resolvers, type "show externalResolvers" in the sbt console.
// To see CUSTOM-ADDED resolvers, type "show resolvers" in the sbt console.
// See http://www.playframework.com/documentation/2.2.3/SBTDependencies

// Example: resolvers += "Scala-Tools Maven2 Snapshots Repository" at "http://scala-tools.org/repo-snapshots"

// IMPORT STANDARD "PLAY FOR JAVA" SETTINGS (changes the sbt project defaults to match play's defaults)
play.Project.playJavaSettings

// SCALA COMPILER OPTIONS
scalacOptions ++= Seq(
  "-feature",                   // Shows warnings in detail in the stdout
  "-language:reflectiveCalls"   // Address the warning generated on the primary route files after introducing subprojects; see https://groups.google.com/d/msg/play-framework/nNr2NdBtWuw/JfbPLaX35XcJ
)

// SETUP FLYWAYDB
// See http://flywaydb.org
Seq(flywaySettings: _*)

// These settings are valid for the local dev environment.
// In the prod and test environment, Flyway is invoked using "sbt -Dflyway.user=myUser -Dflyway.password=myPass ..." which will override these settings.
flywayUrl       := "jdbc:postgresql://192.168.1.1/dbname"

flywayUser      := "user"

flywayPassword  := "password"

flywayLocations := Seq("filesystem:conf/db/migration")

flywayValidateOnMigrate := true

// CUSTOMIZE INTELLIJ IDEA PROJECT
// Use "idea" from sbt console to generate latest IntelliJ project file
// As of 05/12/2014, this setting gets overwritten by IntelliJ's handling of SBT projects
ideaExcludeFolders ++= Seq(".idea", ".idea_modules", ".settings", "logs")

// SETUP MULTIPLE PROJECTS
// sbt and Play Framework support the concept of sub-projects. Each subproject represents a major module in our project.

// Root project. Container for all the projects
lazy val root = project.in(file("."))
  .aggregate(common, admin, customer)
  .dependsOn(common, admin, customer)

// Contains all files and libraries shared across other projects
lazy val common = project.in(file("modules/common"))

// Admin Portal
lazy val admin = project.in(file("modules/admin"))
  .dependsOn(common)

// Organization Portal (i.e. Customer Portal)
lazy val customer = project.in(file("modules/customer"))
  .dependsOn(common)
