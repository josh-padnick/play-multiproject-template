# Twitter Bootstrap and My Application

## Setup
We use Twitter Bootstrap 3.x in My Application.  We mostly include our files in ```/public/bootstrap```, but because we
customize certain aspects of Bootstrap, we include the ```.less``` files in ```/app/assets/css/bootstrap```.

Of course, as of Play 2.2.3, the ```sbt``` ```.less``` pre-processor blindly processes all ```.less``` files alphabetically,
regardless of the actual order of ```@includes``` that are used.  This winds up causing an error.  We avoid this error
by placing a ```_``` in front of each ```.less``` file other than ```bootstrap.less``` which is the entry point for these
files.  This tells ```sbt``` not to pre-process these files.  But since ```bootstrap.less``` uses ```@include``` for
each of them, they get processed anyway.

See https://github.com/playframework/playframework/issues/2051 for more info.