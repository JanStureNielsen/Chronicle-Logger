package com.higherfrequencytrading.chronology.slf4j;

import org.slf4j.helpers.MarkerIgnoringBase;

/**
 *
 */
public class ChronicleLogger extends MarkerIgnoringBase {

    private final ChronicleLogWriter writer;
    private final int level;

    /**
     * c-tor
     *
     * @param writer
     * @param name
     */
    public ChronicleLogger(final ChronicleLogWriter writer, final String name) {
        this(writer, name, ChronicleLoggingHelper.DEFAULT_LOG_LEVEL);
    }

    /**
     * c-tor
     *
     * @param writer
     * @param name
     * @param level
     */
    public ChronicleLogger(final ChronicleLogWriter writer, final String name, int level) {
        this.writer = writer;
        this.name = name;
        this.level = level;
    }

    // *************************************************************************
    //
    // *************************************************************************

    /**
     * @return
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * @return
     */
    public ChronicleLogWriter getWriter() {
        return this.writer;
    }

    // *************************************************************************
    // TRACE
    // *************************************************************************

    @Override
    public boolean isTraceEnabled() {
        return isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_TRACE);
    }

    @Override
    public void trace(String s) {
        if (isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_TRACE)) {
            this.writer.log(ChronicleLoggingHelper.LOG_LEVEL_TRACE, this.name, s, null);
        }
    }

    @Override
    public void trace(String s, Object o) {
        if (isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_TRACE)) {
            this.writer.log(ChronicleLoggingHelper.LOG_LEVEL_TRACE, this.name, s, null, o);
        }
    }

    @Override
    public void trace(String s, Object o1, Object o2) {
        if (isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_TRACE)) {
            this.writer.log(ChronicleLoggingHelper.LOG_LEVEL_TRACE, this.name, s, null, o1, o2);
        }
    }

    @Override
    public void trace(String s, Object... objects) {
        if (isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_TRACE)) {
            this.writer.log(ChronicleLoggingHelper.LOG_LEVEL_TRACE, this.name, s, null, objects);
        }
    }

    @Override
    public void trace(String s, Throwable throwable) {
        if (isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_TRACE)) {
            this.writer.log(ChronicleLoggingHelper.LOG_LEVEL_TRACE, this.name, s, throwable);
        }
    }

    // *************************************************************************
    // DEBUG
    // *************************************************************************

    @Override
    public boolean isDebugEnabled() {
        return isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_DEBUG);
    }

    @Override
    public void debug(String s) {
        if (isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_DEBUG)) {
            this.writer.log(ChronicleLoggingHelper.LOG_LEVEL_DEBUG, this.name, s, null);
        }
    }

    @Override
    public void debug(String s, Object o) {
        if (isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_DEBUG)) {
            this.writer.log(ChronicleLoggingHelper.LOG_LEVEL_DEBUG, this.name, s, null, o);
        }
    }

    @Override
    public void debug(String s, Object o1, Object o2) {
        if (isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_DEBUG)) {
            this.writer.log(ChronicleLoggingHelper.LOG_LEVEL_DEBUG, this.name, s, null, o1, o2);
        }
    }

    @Override
    public void debug(String s, Object... objects) {
        if (isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_DEBUG)) {
            this.writer.log(ChronicleLoggingHelper.LOG_LEVEL_DEBUG, this.name, s, null, objects);
        }
    }

    @Override
    public void debug(String s, Throwable throwable) {
        if (isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_DEBUG)) {
            this.writer.log(ChronicleLoggingHelper.LOG_LEVEL_DEBUG, this.name, s, throwable);
        }
    }

    // *************************************************************************
    // INFO
    // *************************************************************************

    @Override
    public boolean isInfoEnabled() {
        return isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_INFO);
    }

    @Override
    public void info(String s) {
        if (isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_INFO)) {
            this.writer.log(ChronicleLoggingHelper.LOG_LEVEL_INFO, this.name, s, null);
        }
    }

    @Override
    public void info(String s, Object o) {
        if (isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_INFO)) {
            this.writer.log(ChronicleLoggingHelper.LOG_LEVEL_INFO, this.name, s, null, o);
        }
    }

    @Override
    public void info(String s, Object o1, Object o2) {
        if (isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_INFO)) {
            this.writer.log(ChronicleLoggingHelper.LOG_LEVEL_INFO, this.name, s, null, o1, o2);
        }
    }

    @Override
    public void info(String s, Object... objects) {
        if (isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_INFO)) {
            this.writer.log(ChronicleLoggingHelper.LOG_LEVEL_INFO, this.name, s, null, objects);
        }
    }

    @Override
    public void info(String s, Throwable throwable) {
        if (isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_INFO)) {
            this.writer.log(ChronicleLoggingHelper.LOG_LEVEL_INFO, this.name, s, null, throwable);
        }
    }

    // *************************************************************************
    // WARN
    // *************************************************************************

    @Override
    public boolean isWarnEnabled() {
        return isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_WARN);
    }

    @Override
    public void warn(String s) {
        if (isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_WARN)) {
            this.writer.log(ChronicleLoggingHelper.LOG_LEVEL_WARN, this.name, s, null);
        }
    }

    @Override
    public void warn(String s, Object o) {
        if (isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_WARN)) {
            this.writer.log(ChronicleLoggingHelper.LOG_LEVEL_WARN, this.name, s, null, o);
        }
    }

    @Override
    public void warn(String s, Object o1, Object o2) {
        if (isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_WARN)) {
            this.writer.log(ChronicleLoggingHelper.LOG_LEVEL_WARN, this.name, s, null, null, o1, o2);
        }
    }

    @Override
    public void warn(String s, Object... objects) {
        if (isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_WARN)) {
            this.writer.log(ChronicleLoggingHelper.LOG_LEVEL_WARN, this.name, s, null, objects);
        }
    }

    @Override
    public void warn(String s, Throwable throwable) {
        if (isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_WARN)) {
            this.writer.log(ChronicleLoggingHelper.LOG_LEVEL_WARN, this.name, s, throwable);
        }
    }

    // *************************************************************************
    // ERROR
    // *************************************************************************

    @Override
    public boolean isErrorEnabled() {
        return isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_ERROR);
    }

    @Override
    public void error(String s) {
        if (isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_ERROR)) {
            this.writer.log(ChronicleLoggingHelper.LOG_LEVEL_ERROR, this.name, s, null);
        }
    }

    @Override
    public void error(String s, Object o) {
        if (isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_ERROR)) {
            this.writer.log(ChronicleLoggingHelper.LOG_LEVEL_ERROR, this.name, s, null, o);
        }
    }

    @Override
    public void error(String s, Object o1, Object o2) {
        if (isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_ERROR)) {
            this.writer.log(ChronicleLoggingHelper.LOG_LEVEL_ERROR, this.name, s, null, o1, o2);
        }
    }

    @Override
    public void error(String s, Object... objects) {
        if (isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_ERROR)) {
            this.writer.log(ChronicleLoggingHelper.LOG_LEVEL_ERROR, this.name, s, null, objects);
        }
    }

    @Override
    public void error(String s, Throwable throwable) {
        if (isLevelEnabled(ChronicleLoggingHelper.LOG_LEVEL_ERROR)) {
            this.writer.log(ChronicleLoggingHelper.LOG_LEVEL_ERROR, this.name, s, throwable);
        }
    }

    // *************************************************************************
    // HELPERS
    // *************************************************************************

    /**
     * Is the given slf4j level enabled?
     *
     * @param level is this level enabled?
     */
    private boolean isLevelEnabled(int level) {
        // slf4j level are numerically ordered so can use simple numeric
        // comparison
        return (level >= this.level);
    }
}
