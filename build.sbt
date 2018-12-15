name := "trolls"

version := "0.1"

scalaVersion := "2.12.4"

scalacOptions += "-Ypartial-unification"

val monocleVersion = "1.5.0"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "1.4.0",
  "com.lihaoyi" %% "utest" % "0.6.0" % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.4" % "test",
  "com.github.julien-truffaut" %%  "monocle-core"  % monocleVersion,
  "com.github.julien-truffaut" %%  "monocle-macro" % monocleVersion,
  "com.github.julien-truffaut" %%  "monocle-law"   % monocleVersion % "test"
)

testFrameworks += new TestFramework("utest.runner.Framework")
        