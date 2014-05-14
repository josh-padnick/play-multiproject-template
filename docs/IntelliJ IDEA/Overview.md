# Working with My Application and IntelliJ IDEA

IntelliJ's support for Play Framework, Java, Scala, and SBT is pretty good, but not perfect.  Here are some tips:

### Install the following plugins

- Play 2.0 Support
- Scala
- SBT

### IntelliJ will override any IntelliJ-specific settings from your ```build.sbt``` file when it reloads your project
IntelliJ comes with SBT support which mostly works, but IntelliJ seems to generate its own project files that overwrite
any IntelliJ-specific settings you may have put in your ```build.sbt``` file.  See https://github.com/JetBrains/intellij-scala/issues/58 for more info.

For this reason, be sure to test any IntellIJ directives located in your ```build.sbt``` by reloading your SBT project in IntelliJ before assuming
that the directive worked correctly.

### Confirm you're using JDK8
Sometimes auto-generating your IntelliJ project files sets the JDK to something other than 8.  Be sure to explicitly check this after replacing your project.

### View templates in subfolders may not be recognized
This is an annoying little bug in the Play 2.0 Support plugin.  You can fix this by doing the following:

1. Go to File > Project Structure
2. Select the module representing which proejct you want to enable this in (e.g. "orgPortal")
3. In the "Sources" tab, open the folder ```/target/scala-2.10```.
4. Select both the ```classes_managed``` and ```src_managed``` folders, and turn them into "Source Folders" by highlighting each and pressing the blue folder.

Note that every time the IDEA project is re-generated you will need to do this.

### Anytime you add a new library re-generate the IDEA project files
Run ```idea``` from the sbt console.
