/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.log4j.xml;

import java.util.Map;

import org.apache.log4j.Appender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.Configurator;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.LoggerRepository;

// Contributors:   Mark Womack
//                 Arun Katkere 

/**
   Use this class to initialize the log4j environment using a DOM tree.

   <p>The DTD is specified in <a
   href="doc-files/log4j.dtd"><b>log4j.dtd</b></a>.

   <p>Sometimes it is useful to see how log4j is reading configuration
   files. You can enable log4j internal logging by defining the
   <b>log4j.debug</b> variable on the java command
   line. Alternatively, set the <code>debug</code> attribute in the
   <code>log4j:configuration</code> Object. As in
<pre>
   &lt;log4j:configuration <b>debug="true"</b> xmlns:log4j="http://jakarta.apache.org/log4j/">
   ...
   &lt;/log4j:configuration>
</pre>

   <p>There are sample XML files included in the package.
   
   @author Christopher Taylor
   @author Ceki G&uuml;lc&uuml;
   @author Anders Kristensen, (GWT port by Hendrik Brummermann)

   @since 0.8.3 */
public class DOMConfigurator implements Configurator {

    static final String CONFIGURATION_TAG = "log4j:configuration";

    static final String OLD_CONFIGURATION_TAG = "configuration";

    static final String RENDERER_TAG = "renderer";

    private static final String THROWABLE_RENDERER_TAG = "throwableRenderer";

    static final String APPENDER_TAG = "appender";

    static final String APPENDER_REF_TAG = "appender-ref";

    static final String PARAM_TAG = "param";

    static final String LAYOUT_TAG = "layout";

    static final String CATEGORY = "category";

    static final String LOGGER = "logger";

    static final String LOGGER_REF = "logger-ref";

    static final String CATEGORY_FACTORY_TAG = "categoryFactory";

    static final String LOGGER_FACTORY_TAG = "loggerFactory";

    static final String NAME_ATTR = "name";

    static final String CLASS_ATTR = "class";

    static final String VALUE_ATTR = "value";

    static final String ROOT_TAG = "root";

    static final String ROOT_REF = "root-ref";

    static final String LEVEL_TAG = "level";

    static final String PRIORITY_TAG = "priority";

    static final String FILTER_TAG = "filter";

    static final String ERROR_HANDLER_TAG = "errorHandler";

    static final String REF_ATTR = "ref";

    static final String ADDITIVITY_ATTR = "additivity";

    static final String THRESHOLD_ATTR = "threshold";

    static final String CONFIG_DEBUG_ATTR = "configDebug";

    static final String INTERNAL_DEBUG_ATTR = "debug";

    private static final String RESET_ATTR = "reset";

    static final String RENDERING_CLASS_ATTR = "renderingClass";

    static final String RENDERED_CLASS_ATTR = "renderedClass";

    static final String EMPTY_STR = "";

    static final Class[] ONE_STRING_PARAM = new Class[] { String.class };

    final static String dbfKey = "javax.xml.parsers.DocumentBuilderFactory";

    protected Appender findAppenderByName(Object doc, String appenderName) {
        // GWT REMOVED
        return null;
    }

    /**
       Used internally to parse appenders by IDREF Object.
     */
    protected Appender findAppenderByReference(Object appenderRef) {
        // GWT REMOVED
        return null;
    }


    /**
       Used internally to parse an appender Object.
     */
    protected Appender parseAppender(Object appenderObject) {
        // GWT REMOVED
        return null;
    }

    /**
       Used internally to parse an {@link ErrorHandler} Object.
     */
    protected void parseErrorHandler(Object Object, Appender appender) {
        // GWT REMOVED
    }

    /**
       Used internally to parse a filter Object.
     */
    protected void parseFilters(Object Object, Appender appender) {
        // GWT REMOVED
    }

    /**
       Used internally to parse an category Object.
    */
    protected void parseCategory(Object loggerObject) {
        // GWT REMOVED
    }


    /**
       Used internally to parse the category factory Object.
    */
    protected void parseCategoryFactory(Object factoryObject) {
        // GWT REMOVED
    }


    /**
       Used internally to parse the roor category Object.
    */
    protected void parseRoot(Object rootObject) {
        // GWT REMOVED
    }


    /**
       Used internally to parse the children of a category Object.
    */
    protected void parseChildrenOfLoggerObject(Object catObject, Logger cat, boolean isRoot) {
        // GWT REMOVED
    }

    /**
       Used internally to parse a layout Object.
    */
    protected Layout parseLayout(Object layout_Object) {
        // GWT REMOVED
        return null;
    }

    protected void parseRenderer(Object Object) {
        // GWT REMOVED
    }

    /**
     * Parses throwable renderer.
     * @param Object throwableRenderer Object.
     * @return configured throwable renderer.
     * @since 1.2.16.
     */
    protected Object parseThrowableRenderer(final Object Object) {
        // GWT REMOVED
        return null;
    }

    /**
       Used internally to parse a level  Object.
    */
    protected void parseLevel(Object Object, Logger logger, boolean isRoot) {
        // GWT REMOVED
    }

    protected void setParameter(Object elem, Object propSetter) {
        // GWT REMOVED
    }


    /**
        Like {@link #configureAndWatch(String, long)} except that the
        default delay as defined by {@link FileWatchdog#DEFAULT_DELAY} is
        used. 

        @param configFilename A log4j configuration file in XML format.

     */
    static public void configureAndWatch(String configFilename) {
        // GWT REMOVED
    }

    /**
       Read the configuration file <code>configFilename</code> if it
       exists. Moreover, a thread will be created that will periodically
       check if <code>configFilename</code> has been created or
       modified. The period is determined by the <code>delay</code>
       argument. If a change or file creation is detected, then
       <code>configFilename</code> is read to configure log4j.  

        @param configFilename A log4j configuration file in XML format.
        @param delay The delay in milliseconds to wait between each check.
    */
    static public void configureAndWatch(String configFilename, long delay) {
        // GWT REMOVED
    }

    @Override
    public void doConfigure(final Object filename, LoggerRepository repository) {
        // GWT REMOVED
    }

    public static void configure(final Object filename) {
        // GWT REMOVED
    }


    protected void parse(Object Object) {
        // GWT REMOVED
    }


    protected String subst(final String value) {
        // GWT REMOVED
        return null;
    }

    /**
     * Substitutes property value for any references in expression.
     *
     * @param value value from configuration file, may contain
     *              literal text, property references or both
     * @param props properties.
     * @return evaluated expression, may still contain expressions
     *         if unable to expand.
     * @since 1.2.15
     */
    public static String subst(final String value, final Map props) {
        // GWT REMOVED
        return null;
    }


    /**
     * Sets a parameter based from configuration file content.
     *
     * @param elem       param Object, may not be null.
     * @param propSetter property setter, may not be null.
     * @param props      properties
     * @since 1.2.15
     */
    public static void setParameter(final Object elem, final Object propSetter, final Map props) {
        // GWT REMOVED
    }

    /**
     * Creates an object and processes any nested param Objects
     * but does not call activateOptions.  If the class also supports
     * UnrecognizedObjectParser, the parseUnrecognizedObject method
     * will be call for any child Objects other than param.
     *
     * @param Object       Object, may not be null.
     * @param props         properties
     * @param expectedClass interface or class expected to be implemented
     *                      by created class
     * @return created class or null.
     * @throws Exception thrown if the contain object should be abandoned.
     * @since 1.2.15
     */
    public static Object parseObject(final Object Object, final Map props, final Object expectedClass) throws Exception {
        // GWT REMOVED
        return null;
    }

}
