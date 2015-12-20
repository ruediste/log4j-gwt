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

// Contibutors:  Aaron Greenhouse <aarong@cs.cmu.edu>
//               Thomas Tuft Muller <ttm@online.no>
package org.apache.log4j;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.apache.log4j.spi.AppenderAttachable;
import org.apache.log4j.spi.LoggingEvent;


/**
 * The AsyncAppender lets users log events asynchronously.
 * <p/>
 * <p/>
 * The AsyncAppender will collect the events sent to it and then dispatch them
 * to all the appenders that are attached to it. You can attach multiple
 * appenders to an AsyncAppender.
 * </p>
 * <p/>
 * <p/>
 * The AsyncAppender uses a separate thread to serve the events in its buffer.
 * </p>
 * <p/>
 * <b>Important note:</b> The <code>AsyncAppender</code> can only be script
 * configured using the {@link org.apache.log4j.xml.DOMConfigurator}.
 * </p>
 *
 * @author Ceki G&uuml;lc&uuml;
 * @author Curt Arnold, (GWT port by Hendrik Brummermann)
 * @since 0.9.1
 */
public class AsyncAppender extends AppenderSkeleton implements AppenderAttachable {
    /**
     * The default buffer size is set to 128 events.
     */
    public static final int DEFAULT_BUFFER_SIZE = 128;

    private final List buffer = new ArrayList();

    /**
     * Buffer size.
     */
    private int bufferSize = DEFAULT_BUFFER_SIZE;

    /**
     * Should location info be included in dispatched messages.
     */
    private boolean locationInfo = false;

    /**
     * Does appender block when buffer is full.
     */
    private boolean blocking = true;

    /**
     * Create new instance.
     */
    public AsyncAppender() {
        //    GWT REMOVED
    }

    /**
     * Add appender.
     *
     * @param newAppender appender to add, may not be null.
     */
    @Override
    public void addAppender(final Appender newAppender) {
        //    GWT REMOVED
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void append(final LoggingEvent event) {
        //    GWT REMOVED
    }

    /**
     * Close this <code>AsyncAppender</code> by interrupting the dispatcher
     * thread which will process all pending events before exiting.
     */
    @Override
    public void close() {
        //    GWT REMOVED
    }

    /**
     * Get iterator over attached appenders.
     * @return iterator or null if no attached appenders.
     */
    @Override
    public Enumeration getAllAppenders() {
        return null;
    }

    /**
     * Get appender by name.
     *
     * @param name name, may not be null.
     * @return matching appender or null.
     */
    @Override
    public Appender getAppender(final String name) {
        return null;
    }

    /**
     * Gets whether the location of the logging request call
     * should be captured.
     *
     * @return the current value of the <b>LocationInfo</b> option.
     */
    public boolean getLocationInfo() {
        return locationInfo;
    }

    /**
     * Determines if specified appender is attached.
     * @param appender appender.
     * @return true if attached.
     */
    @Override
    public boolean isAttached(final Appender appender) {
        //    GWT REMOVED
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean requiresLayout() {
        return false;
    }

    /**
     * Removes and closes all attached appenders.
     */
    @Override
    public void removeAllAppenders() {
        //    GWT REMOVED
    }

    /**
     * Removes an appender.
     * @param appender appender to remove.
     */
    @Override
    public void removeAppender(final Appender appender) {
        //    GWT REMOVED
    }

    /**
     * Remove appender by name.
     * @param name name.
     */
    @Override
    public void removeAppender(final String name) {
        //    GWT REMOVED
    }

    /**
     * The <b>LocationInfo</b> option takes a boolean value. By default, it is
     * set to false which means there will be no effort to extract the location
     * information related to the event. As a result, the event that will be
     * ultimately logged will likely to contain the wrong location information
     * (if present in the log format).
     * <p/>
     * <p/>
     * Location information extraction is comparatively very slow and should be
     * avoided unless performance is not a concern.
     * </p>
     * @param flag true if location information should be extracted.
     */
    public void setLocationInfo(final boolean flag) {
        locationInfo = flag;
    }

    /**
     * Sets the number of messages allowed in the event buffer
     * before the calling thread is blocked (if blocking is true)
     * or until messages are summarized and discarded.  Changing
     * the size will not affect messages already in the buffer.
     *
     * @param size buffer size, must be positive.
     */
    public void setBufferSize(final int size) {
        //
        //   log4j 1.2 would throw exception if size was negative
        //      and deadlock if size was zero.
        //
        if (size < 0) {
            throw new java.lang.NegativeArraySizeException("size");
        }

        synchronized (buffer) {
            //
            //   don't let size be zero.
            //
            bufferSize = (size < 1) ? 1 : size;
            buffer.notifyAll();
        }
    }

    /**
     * Gets the current buffer size.
     * @return the current value of the <b>BufferSize</b> option.
     */
    public int getBufferSize() {
        return bufferSize;
    }

    /**
     * Sets whether appender should wait if there is no
     * space available in the event buffer or immediately return.
     *
     * @since 1.2.14
     * @param value true if appender should wait until available space in buffer.
     */
    public void setBlocking(final boolean value) {
        synchronized (buffer) {
            blocking = value;
            buffer.notifyAll();
        }
    }

    /**
     * Gets whether appender should block calling thread when buffer is full.
     * If false, messages will be counted by logger and a summary
     * message appended after the contents of the buffer have been appended.
     *
     * @since 1.2.14
     * @return true if calling thread will be blocked when buffer is full.
     */
    public boolean getBlocking() {
        return blocking;
    }

}
