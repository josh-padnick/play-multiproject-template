// Comment to get more information during initialization
logLevel := Level.Warn

// ---------
// resolvers
// ---------
// check https://www.playframework.com/documentation/2.5.x/SBTDependencies#resolvers

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"


// -----------
// sbt plugins
// -----------

// Use the Play sbt plugin for Play projects
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.5.6")
