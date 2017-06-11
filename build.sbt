// Project name (artifact name in Maven)
name := "my-app"

// orgnization name (e.g., the package name of the project)
organization := "com.mycompany.app"

version := "1.0-SNAPSHOT"

// project description
description := "Test Java project with VS Code and SBT"

// Enables publishing to maven repo
publishMavenStyle := true

// Do not append Scala versions to the generated artifacts
crossPaths := false

// This forbids including Scala related libraries into the dependency
autoScalaLibrary := false

// library dependencies. (orginization name) % (project name) % (version)
libraryDependencies ++= Seq(
   "junit" % "junit" % "4.12" % "test",
   "com.novocode" % "junit-interface" % "0.11" % "test"
)