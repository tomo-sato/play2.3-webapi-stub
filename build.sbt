name := """play2.3-webapi-stub"""

version := "1.3.0"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
// Add Library
  "mysql" % "mysql-connector-java" % "5.1.38",
  "org.json" % "json" % "20160212"
)
