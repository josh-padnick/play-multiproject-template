# Frontend Overview
...

## Including CSS and JS files

Play Framework uses SBT (Scala Build Tool) to intelligently include, compile, and minify CSS and javascript documents.
When you write the following in a ```scala.html``` template:

```html
<link rel="stylesheet" media="screen" href="@routes.Assets.at("css/theme.css")">
```

Play Framework will look for files in both of the following locations:

```
/app/assets/css/theme.less
/public/css/theme.css
```

What happens if you put a file in both locations?  Play will throw a ```RuntimeException: Duplicate mappings``` error. So
you should pick one.

Files in the ```/app/assets``` folder are "pre-processed" by Play Framework.  This means that .less files are converted
into their corresponding CSS.  Note that you can use the following in your view template:

```html
<link rel="stylesheet" media="screen" href="@routes.Assets.at("css/theme.min.css")">
```

See the "min" in the filename?  That means that the .less files are not only compiled into CSS, but minified as well!

If you need no pre-processing, just include your files in the ```/public``` directory.

All this magic is possible because of the use of the ```@routes.Assets.at``` directive.