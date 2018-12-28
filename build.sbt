name := """API"""
organization := "com.thesis"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.6"

libraryDependencies += guice

libraryDependencies ++= Seq(
  ws
)


