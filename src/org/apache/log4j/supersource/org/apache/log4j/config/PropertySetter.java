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

// Contributors:  Georg Lundesgaard

package org.apache.log4j.config;

import java.util.Map;

/**
   General purpose Object property setter. Clients repeatedly invokes
   {@link #setProperty setProperty(name,value)} in order to invoke setters
   on the Object specified in the constructor. This class relies on the
   JavaBeans Introspector to analyze the given Object Class using
   reflection.
   
   <p>Usage:
   <pre>
     PropertySetter ps = new PropertySetter(anObject);
     ps.set("name", "Joe");
     ps.set("age", "32");
     ps.set("isMale", "true");
   </pre>
   will cause the invocations anObject.setName("Joe"), anObject.setAge(32),
   and setMale(true) if such methods exist with those signatures.
   Otherwise an IntrospectionException are thrown.
  
   @author Anders Kristensen
   @since 1.1
 */
public class PropertySetter {

    /**
      Create a new PropertySetter for the specified Object. This is done
      in prepartion for invoking {@link #setProperty} one or more times.
      
      @param obj  the object for which to set properties
     */
    public PropertySetter(Object obj) {
        // GWT REMOVED
    }

    /**
       Uses JavaBeans Introspector to computer setters of object to be
       configured.
     */
    protected void introspect() {
        // GWT REMOVED
    }


    /**
       Set the properties of an object passed as a parameter in one
       go. The <code>properties</code> are parsed relative to a
       <code>prefix</code>.

       @param obj The object to configure.
       @param properties A java.util.Properties containing keys and values.
       @param prefix Only keys having the specified prefix will be set.
    */
    public static void setProperties(Object obj, Map properties, String prefix) {
        // GWT REMOVED
    }


    /**
       Set the properites for the object that match the
       <code>prefix</code> passed as parameter.

       
     */
    public void setProperties(Map properties, String prefix) {
        // GWT REMOVED
    }

    /**
       Set a property on this PropertySetter's Object. If successful, this
       method will invoke a setter method on the underlying Object. The
       setter is the one for the specified property name and the value is
       determined partly from the setter argument type and partly from the
       value specified in the call to this method.
       
       <p>If the setter expects a String no conversion is necessary.
       If it expects an int, then an attempt is made to convert 'value'
       to an int using new Integer(value). If the setter expects a boolean,
       the conversion is by new Boolean(value).
       
       @param name    name of the property
       @param value   String value of the property
     */
    public void setProperty(String name, String value) {
        // GWT REMOVED
    }

    /** 
        Set the named property given a PropertyDescriptor.

        @param prop A PropertyDescriptor describing the characteristics
        of the property to set.
        @param name The named of the property to set.
        @param value The value of the property.      
     */
    public void setProperty(Object prop, String name, String value) {
        // GWT REMOVED
    }


    /**
       Convert <code>val</code> a String parameter to an object of a
       given type.
    */
    protected Object convertArg(String val, Object type) {
        // GWT REMOVED
        return null;
    }


    protected Object getPropertyDescriptor(String name) {
        // GWT REMOVED
        return null;
    }

    public void activate() {
        // GWT REMOVED
    }
}
