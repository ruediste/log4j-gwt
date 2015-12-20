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
package org.apache.log4j;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.spi.ThrowableRenderer;

/**
 * Enhanced implementation of ThrowableRenderer.  Uses Throwable.getStackTrace
 * if running on JDK 1.4 or later and delegates to DefaultThrowableRenderer.render
 * on earlier virtual machines.
 *
 * @since 1.2.16
 */
public final class EnhancedThrowableRenderer implements ThrowableRenderer {

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] doRender(final Throwable throwable) {
            try {
                StackTraceElement[] elements = throwable.getStackTrace();
                String[] lines = new String[elements.length + 1];
                lines[0] = throwable.toString();
                Map classMap = new HashMap();
                for (int i = 0; i < elements.length; i++) {
                    lines[i + 1] = formatElement(elements[i], classMap);
                }
                return lines;
            } catch (Exception ex) {
            }
        return DefaultThrowableRenderer.render(throwable);
    }

    /**
     * Format one element from stack trace.
     * @param element element, may not be null.
     * @param classMap map of class name to location.
     * @return string representation of element.
     */
    private String formatElement(final StackTraceElement element, final Map classMap) {
        StringBuffer buf = new StringBuffer("\tat ");
        buf.append(element);
        try {
            String className = element.getClassName();
            Object classDetails = classMap.get(className);
            if (classDetails != null) {
                buf.append(classDetails);
            } else {
                Class cls = findClass(className);
                int detailStart = buf.length();
                classMap.put(className, buf.substring(detailStart));
            }
        } catch (Exception ex) {
        }
        return buf.toString();
    }

    /**
     * Find class given class name.
     * @param className class name, may not be null.
     * @return class, will not be null.
     * @throws ClassNotFoundException thrown if class can not be found.
     */
    private Class findClass(final String className) throws ClassNotFoundException {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(className);
        } catch (ClassNotFoundException e) {
            try {
                return Class.forName(className);
            } catch (ClassNotFoundException e1) {
                return getClass().getClassLoader().loadClass(className);
            }
        }
    }

}
