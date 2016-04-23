enablePlugins(ScalaJSPlugin)

name := "sri-web-materialui-template"

scalaVersion := "2.11.8"

val sriVersion = "0.5.0-SNAPSHOT"

libraryDependencies ++= Seq("com.github.chandu0101.sri-extra" %%% "web" % sriVersion)

val assetsDir = "assets/"

// copy fastOptJS/fullOptJS  fiels to assets directory
crossTarget in(Compile, fullOptJS) := file(assetsDir)
crossTarget in(Compile, fastOptJS) := file(assetsDir)
crossTarget in(Compile, packageScalaJSLauncher) := file(assetsDir)
artifactPath in(Compile, fastOptJS) := ((crossTarget in(Compile, fastOptJS)).value /
  ((moduleName in fastOptJS).value + "-opt.js"))

