name := "Selenium-Assignment"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1",
  "log4j" % "log4j" % "1.2.17",
  "org.seleniumhq.selenium" % "selenium-firefox-driver" % "3.0.1",
  "org.seleniumhq.selenium" % "selenium-chrome-driver" % "3.0.1",
  "org.seleniumhq.selenium" % "selenium-java" % "3.0.1",
  "org.seleniumhq.selenium" % "selenium-server" % "3.0.1"
)