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



/**
   Render {@link ThreadGroup} objects in a format similar to the
   information output by the {@link ThreadGroup#list} method.
   @author Ceki G&uuml;lc&uuml;
   @since 1.0 */
public class ThreadGroupRenderer implements ObjectRenderer {

    public ThreadGroupRenderer() {
    }

    /**
       Render a {@link ThreadGroup} object similar to the way that the
       {@link ThreadGroup#list} method output information.

       <p>The output of a simple program consisting of one
       <code>main</code> thread is:
       <pre>
       java.lang.ThreadGroup[name=main, maxpri=10]
           Thread=[main,5,false]
       </pre>

       <p>The boolean value in thread information is the value returned
       by {@link Thread#isDaemon}.

    */
    @Override
    public String doRender(Object o) {
        try {
            // this is the best we can do
            return o.toString();
        } catch (Exception ex) {
            return ex.toString();
        }
    }
}
