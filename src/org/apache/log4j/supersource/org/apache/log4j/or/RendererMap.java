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

package org.apache.log4j.or;

import org.apache.log4j.spi.RendererSupport;

/**
   Map class objects to an {@link ObjectRenderer}.

   @author Ceki G&uuml;lc&uuml;
   @since version 1.0 */
public class RendererMap {
    static ObjectRenderer defaultRenderer = new DefaultRenderer();

    /**
       Add a renderer to a hierarchy passed as parameter.
    */
    public static void addRenderer(RendererSupport repository, String renderedClassName, String renderingClassName) {
        // GWT REMOVED
    }


    /**
       Find the appropriate renderer for the class type of the
       <code>o</code> parameter. This is accomplished by calling the
       {@link #get(Class)} method. Once a renderer is found, it is
       applied on the object <code>o</code> and the result is returned
       as a {@link String}. */
    public String findAndRender(Object o) {
        // GWT REMOVED
        return null;
    }


    /**
       Syntactic sugar method that calls {@link #get(Class)} with the
       class of the object parameter. */
    public ObjectRenderer get(Object o) {
        // GWT REMOVED
        return defaultRenderer;
    }

    public ObjectRenderer getDefaultRenderer() {
        return defaultRenderer;
    }


    public void clear() {
        // GWT REMOVED
    }

    /**
       Register an {@link ObjectRenderer} for <code>clazz</code>.
    */
    public void put(Object clazz, ObjectRenderer or) {
        // GWT REMOVED
    }
}
