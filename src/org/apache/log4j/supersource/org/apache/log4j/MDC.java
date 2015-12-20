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

/**
   The MDC class is similar to the {@link NDC} class except that it is
   based on a map instead of a stack. It provides <em>mapped
   diagnostic contexts</em>. A <em>Mapped Diagnostic Context</em>, or
   MDC in short, is an instrument for distinguishing interleaved log
   output from different sources. Log output is typically interleaved
   when a server handles multiple clients near-simultaneously.

   <p><b><em>The MDC is managed on a per thread basis</em></b>. A
   child thread automatically inherits a <em>copy</em> of the mapped
   diagnostic context of its parent.
  
   <p>The MDC class requires JDK 1.2 or above. Under JDK 1.1 the MDC
   will always return empty values but otherwise will not affect or
   harm your application.
   
   @since 1.2

   @author Ceki G&uuml;lc&uuml; 
*/
public class MDC {
    private static Map<String, Object> map = null;

    /**
       Put a context value (the <code>o</code> parameter) as identified
       with the <code>key</code> parameter into the current thread's
       context map.

       <p>If the current thread does not have a context map it is
       created as a side effect.
      
     */
    public static void put(String key, Object o) {
        if (map == null) {
            map = new HashMap<String, Object>();
        }
        map.put(key, o);
    }

    /**
       Get the context identified by the <code>key</code> parameter.

       <p>This method has no side effects.
     */
    public static Object get(String key) {
        if (map != null) {
            return map.get(key);
        }
        return null;
    }

    /**
       Remove the the context identified by the <code>key</code>
       parameter.
    */
    public static void remove(String key) {
        if (map != null) {
            map.remove(key);
        }
    }


    /**
     * Get the current thread's MDC as a hashtable. This method is
     * intended to be used internally.  
     * */
    public static Map getContext() {
        // GWT REMOVED
        return null;
    }

    /**
     *  Remove all values from the MDC.
     *  @since 1.2.16
    */
    public static void clear() {
        if (map != null) {
            map = null;
        }
    }

    public static String toLogString() {
        if (map == null) {
            return "{}";
        }
        return map.toString();
    }
}
