In order to use log4j on the client side of a GWT application, you need to:

* add log4j-gwt.jar to the classpath
* add the following line to your module.gwt.xml file:
  <inherits name="org.apache.log4j.Log4j" />

log4j-gwt makes use of the normal GWT logging configuration as described on
https://developers.google.com/web-toolkit/doc/latest/DevGuideLogging#Configuring_GWT_Logging


Change log
==========

1.0  2012-08-04
---------------
* stable release

0.2

* added support for NDC and MDC (without support for lazy cleanup)
* added support for stacktraces of exceptions
* silently ignore attempts to configure log4j using the PropertiesConfigurator ot the DOMConfigurator
* optimized for code size by providing stubs that are optimized

0.1  2012-07-11
---------------

* Initial release: Logger, Level, LogManager and more are working