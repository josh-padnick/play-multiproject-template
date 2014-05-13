# Play Framework 2.2.3 Subproject Template
This Play Framework template demonstrates multiple subprojects as  you might use them with a traditional Software-as-a-Service application.   It uses Java
but can be adapted for Scala with minimal changes.

## Projects in this template

### Root Project
The "root" project is essentially a container for the individual subprojects (stored in the ```/modules``` folder).  The root project has the master ```build.sbt```
file which tells SBT this is a multi-project build.  It also contains global application-level functionality like returning the SHA of the current git commit. Otherwise, 
all functionality should go in a subproject / module.
 
### Common Project
This project is a container for all globally shared resources, including javascript, css, and images, as well as shared Java and Scala libraries.
 
### Customer Project
This project is an example of an application that the customer might use.

### Admin Project
This project is an example of an application an administrator might use.

## Usage
1. Clone this repo to your local workstation.

2. Download [Typesafe Activator](http://www.playframework.com/download)

3. Load the Play Framework project in sbt by using activator as follows:

```
cd /my/project/directory
activator
```

4. Once in sbt/activator, run the application:

```
run
```

5. The app should open a TCP listener at port 9000 on localhost.  Now try these URLs from the routes files:

- http://localhost:9000/admin/index
- http://localhost:9000/admin/test1
- http://localhost:9000/admin/test2
- http://localhost:9000/customer/subfolder/page

6. To run the project in IntelliJ, from the sbt/activator console type ```idea``` and use IntelliJ to open the folder containing this project. 

## Gotcha's

### Namespace Conflicts
One of the common challenges of setting up multi-project builds is namespace conflicts.  These arise from at least two areas.

First, the default Java package of each a ```.java``` file in the ```controllers``` folder is simply ```package controllers```.  When working with
one project, this package is unique, but when working with multi-project, neither the JVM nor IntelliJ will know which ```controllers``` package you're
referring to, if each of your projects has files in the ```controllers``` package.

Second, one of the best features of Play Framework is its intuitve ```routes``` file.  Play achieves the simple format by using an sbt feature called
 [source generation](http://www.scala-sbt.org/0.12.3/docs/Howto/generatefiles.html) to convert a project's routes files into Java/Scala code that 
IntelliJ and the JVM can understand.  I often ran into issues where the namespaces used by these files were off.  This template addresses that
issue in the way that the files are named and the contents of each project's ```build.sbt``` file.

In general, the recommended packages are:

```
package controllers.admin
package controllers.admin.subpackage
package controllers.customer
package controllers.customer.subpackage
package models.common.whatever
etc.
``` 

## More Documentation
Check out the [docs](docs) folder for information on configuring IntelliJ IDEA, Logging, and more. 

## Attribution
Most of this template was built by carefully reading http://www.playframework.com/documentation/2.2.3/SBTSubProjects.  I also 
benefitted from https://github.com/cnicodeme/play2.2-subproject.