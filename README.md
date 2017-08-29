# MyComponent Add-on for Vaadin 7

Overview
The goal of the GWT Graphics library is to provide consistent cross-browser vector graphics library for Google Web Toolkit. Under the hood, the library uses to XML-based languages: SVG and VML. VML implementation is for Internet Explorer. Other browsers use SVG implementation.

Please note that GWT Graphics is a library for GWT. If you want to use it with Vaadin, you have to create your own Vaadin widget and use the library on the client-side.

## Online demo

Try the add-on demo at <url of the online demo>

## Download release

Official releases of this add-on are available at Vaadin Directory. For Maven instructions, download and reviews, go to http://vaadin.com/addon/GWTGraphics

## Building and running demo

git clone <url of the MyComponent repository>
mvn clean install
cd demo
mvn jetty:run

To see the demo, navigate to http://localhost:8080/

## Development with Eclipse IDE

For further development of this add-on, the following tool-chain is recommended:
- Eclipse IDE
- m2e wtp plug-in (install it from Eclipse Marketplace)
- Vaadin Eclipse plug-in (install it from Eclipse Marketplace)
- JRebel Eclipse plug-in (install it from Eclipse Marketplace)
- Chrome browser

### Importing project

Choose File > Import... > Existing Maven Projects

Note that Eclipse may give "Plugin execution not covered by lifecycle configuration" errors for pom.xml. Use "Permanently mark goal resources in pom.xml as ignored in Eclipse build" quick-fix to mark these errors as permanently ignored in your project. Do not worry, the project still works fine. 

### Debugging server-side

If you have not already compiled the widgetset, do it now by running vaadin:install Maven target for GWTGraphics-root project.

If you have a JRebel license, it makes on the fly code changes faster. Just add JRebel nature to your GWTGraphics-demo project by clicking project with right mouse button and choosing JRebel > Add JRebel Nature

To debug project and make code modifications on the fly in the server-side, right-click the GWTGraphics-demo project and choose Debug As > Debug on Server. Navigate to http://localhost:8080/GWTGraphics-demo/ to see the application.

### Debugging client-side

Debugging client side code in the GWTGraphics-demo project:
  - run "mvn vaadin:run-codeserver" on a separate console while the application is running
  - activate Super Dev Mode in the debug window of the application or by adding ?superdevmode to the URL
  - You can access Java-sources and set breakpoints inside Chrome if you enable source maps from inspector settings.
 
## Release notes

### Version 1.0.0
- IE9 uses SVG for rendering now
- JavaDoc enhancements
- GWT Graphics' version can be read from GWT Java code
- Added Animate.onComplete() that is fired when animation completes
- Bug fixes

### Version 2.0.0
- Mavenized project
- Color and style (apply patterns) for every step in a path can be changed.
- Vector object's borders can be styled (e.g. to lets say dotted lines or dashes or other patterns).  
- Anti-aliasing support added to paths
- A way to add a shadow to a Vector object
- Gradient fill support added

## Issue tracking

The issues for this add-on are tracked on its github.com page. All bug reports and feature requests are appreciated. 

## Contributions

Contributions are welcome, but there are no guarantees that they are accepted as such. Process for contributing is the following:
- Fork this project
- Create an issue to this project about the contribution (bug or feature) if there is no such issue about it already. Try to keep the scope minimal.
- Develop and test the fix or functionality carefully. Only include minimum amount of code needed to fix the issue.
- Refer to the fixed issue in commit
- Send a pull request for the original project
- Comment on the original issue that you have implemented a fix for it

## License & Author

Add-on is distributed under Apache License 2.0. For license terms, see LICENSE.txt.

GWT graphics add-on versions to 1.x is written by Henri Kerola. Updates to version 2.0.0 were contributed by Patrik Lindström and Pontus Boström 

# Developer Guide

## Getting started

For a more comprehensive example, see the demo application

https://github.com/TatuLund/GWTGraphics/tree/master/GWTGraphics-demo/src/main/java/org/vaadin/addon/gwtgraphics/testapp/client

