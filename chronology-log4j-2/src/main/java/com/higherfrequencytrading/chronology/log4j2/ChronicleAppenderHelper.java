package com.higherfrequencytrading.chronology.log4j2;

import com.higherfrequencytrading.chronology.Chronology;
import com.higherfrequencytrading.chronology.ChronologyLogLevel;
import net.openhft.chronicle.ExcerptAppender;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.message.Message;

public class ChronicleAppenderHelper {

    /**
     * Write ILoggingEvent to an Excerpt
     *
     * @param appender          the ExcerptAppender
     * @param event             the ILoggingEvent
     * @param formatMessage     writeBinary formatted or unformatted message
     * @param includeMDC        include or not Mapped Diagnostic Context
     * @param includeCallerData include or not CallerData
     */
    public static void writeBinary(
        final ExcerptAppender appender,
        final LogEvent event,
        boolean formatMessage,
        boolean includeMDC,
        boolean includeCallerData) {

        appender.startExcerpt();
        appender.writeByte(Chronology.VERSION);
        appender.writeByte(Chronology.TYPE_LOG4J_2);
        appender.writeLong(event.getMillis());
        appender.writeInt(toChronologyLogLevel(event.getLevel()));
        appender.writeUTF(event.getThreadName());
        appender.writeUTF(event.getLoggerName());

        if(!formatMessage) {
            Message message = event.getMessage();

            appender.writeUTF(event.getMessage().getFormat());

            // Args
            Object[] args = message.getParameters();
            int argsLen = null != args ? args.length : 0;
            //if(message.getThrowable() != null) {
            //    argsLen++;
            //}

            appender.writeInt(argsLen);
            for (int i = 0; i < argsLen; i++) {
                appender.writeObject(args[i]);
            }

            //if(message.getThrowable() != null) {
            //    appender.writeObject(message.getThrowable());
            //}
        } else {
            appender.writeUTF(event.getMessage().getFormattedMessage());
            appender.writeInt(0);
        }

        /*
        if(includeMDC) {
            // Mapped Diagnostic Context http://logback.qos.ch/manual/mdc.html
            final Map<String, String> mdcProps = event.getMDCPropertyMap();
            appender.writeInt(null != mdcProps ? mdcProps.size() : 0);
            if(mdcProps != null) {
                for (Map.Entry<String, String> entry : mdcProps.entrySet()) {
                    appender.writeUTF(entry.getKey());
                    appender.writeUTF(entry.getValue());
                }
            }
        } else {
            appender.writeInt(0);
        }

        if(includeCallerData) {
            Object[] callerData = event.getCallerData();
            int callerDataLen = null != callerData ? callerData.length : 0;

            appender.writeInt(callerDataLen);
            for(int i=0; i < callerDataLen; i++) {
                appender.writeObject(callerData[i]);
            }

        } else {
            appender.writeInt(0);
        }

        IThrowableProxy throwableProxy = event.getThrowableProxy();
        if(throwableProxy != null) {
            appender.writeBoolean(true);
            appender.writeObject(throwableProxy);
        } else {
            appender.writeBoolean(false);
        }
        */

        appender.finish();
    }

    // *************************************************************************
    //
    // *************************************************************************

    public static int toChronologyLogLevel(final Level level) {
        if(level.intLevel() == Level.DEBUG.intLevel()) {
            return ChronologyLogLevel.DEBUG.levelInt;
        } else if(level.intLevel() == Level.TRACE.intLevel()) {
            return ChronologyLogLevel.TRACE.levelInt;
        } else if(level.intLevel() == Level.INFO.intLevel()) {
            return ChronologyLogLevel.INFO.levelInt;
        } else if(level.intLevel() == Level.WARN.intLevel()) {
            return ChronologyLogLevel.WARN.levelInt;
        } else if(level.intLevel() == Level.ERROR.intLevel()) {
            return ChronologyLogLevel.ERROR.levelInt;
        }

        throw new IllegalArgumentException(level.intLevel() + " not a valid level value");
    }
}
