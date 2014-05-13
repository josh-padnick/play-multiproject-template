# Logging in My Application
We follow these practices for using log files.

## Background
MyApplication logging is handled via Play Framework, which in turn uses [Logback](http://logback.qos.ch/).  Logback was written by the original author of ```log4j``` and is the "successor" to ```log4j```.

To customize how logging is handleded, edit ```/conf/logger.xml```.  Note that this file is the default Play Framework logging settings which would otherwise be used if this file were deleted. 

## My Application Logging Practices
- Every unchecked / runtime exception (these are usually due to programming errors) should be logged at the ```ERROR``` level. 
- Every checked exception (these are usually due to external conditions that prevent us from executing properly) should be logged at the ```WARN``` level.

- Be descriptive in your log messages!  Assume you will someday be debugging what you're writing, and document what's happening in the program with DEBUG and INFO log messages accordingly.  You may include things like:
 - Conditions which caused the exception
 - The URL of the request where the exception occurred (get this from ```request().toString()``` in any Action (controller)

## Cheat Sheet

### To make a TEMPORARY log entry
In your code, write the following:

 ```
Logger.debug("Descriptive message useful for debugging");
```

### To make a PERMANENT log entry
In your code, write the following:

 ```
Logger.of( <current-class> ).error("Descriptive message useful for debugging", e);
```
where ```e``` is the exception you've caught.  For example, you might write:
 

```
...
} catch ( MyFavoriteException e ) {
	Logger.of( Locations.class ).error("Organization Domain ID does not exist", e);
}
```

You can log at any of the following levels:  ```trace()```, ```debug()```, ```info()```, ```warn()``` or ```error()```.

### To hide/show more log entries in the console or log files
You may want to get more verbose or more high-level.  Use ```/conf/application.conf``` to configure settings for individual "log contexts" here.  

- To set verbosity across the board, set ```logger.root=DEBUG```.  Note that ```root``` is the default context and the parent context of every other context.
- To set verbosity for a single class, set ```logger.<fully-qualified-class-name>=DEBUG```.  For example ```logger.controllers.Locations=DEBUG```.  
- To set verbosity for all classes in a package, just go higher up the context hierarchy like ```logger.controllers=DEBUG```.
- Acceptable log levels are, from most verbose to lease: ```TRACE```, ```DEBUG```, ```INFO```, ```WARN``` or ```ERROR```.


## Where Can I View Logs?
This is determined by the ```/conf/application-logger.xml``` file, which is the ```logback``` config file.  In the logback world, an output destination is called an **Appender**.

As of this writing, log entries go to:
* StdOut (i.e. the play console)
* ```<app-home>/logs/application.log```

## Understanding Log Contexts
Logging is useful when you're debugging, and when you're debugging, you may want to only show log files for one area of the application.  That's what **Log Contexts** (sometimes called simply **Loggers**) are for.

For example, we may have a default log context, plus one only for database commands ("database"), or perhaps one only for patient reminders ("reminders").

Note that the default context is called the "application" context.

## Understanding Log Levels
Use the ```TRACE``` level to show the most detail, and the ```ERROR``` level to show the least.  Here are the levels that each level will show:

```TRACE``` = ```Error```, ```Warn```, ```Info```, ```Debug```, ```Trace```

```DEBUG``` = ```Error```, ```Warn```, ```Info```, ```Debug```

```INFO``` = ```Error```, ```Warn```, ```Info```

```WARN``` = ```Error```, ```Warn```

```ERROR``` = ```Error```