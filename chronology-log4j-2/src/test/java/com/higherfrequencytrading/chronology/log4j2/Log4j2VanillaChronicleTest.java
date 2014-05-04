package com.higherfrequencytrading.chronology.log4j2;

import com.higherfrequencytrading.chronology.Chronology;
import com.higherfrequencytrading.chronology.ChronologyLogEvent;
import com.higherfrequencytrading.chronology.ChronologyLogHelper;
import com.higherfrequencytrading.chronology.ChronologyLogLevel;
import net.openhft.chronicle.Chronicle;
import net.openhft.chronicle.ExcerptTailer;
import net.openhft.lang.io.IOTools;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@Ignore
public class Log4j2VanillaChronicleTest extends Log4j2TestBase {

    // *************************************************************************
    //
    // *************************************************************************

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        IOTools.deleteDir(rootPath());
    }

    // *************************************************************************
    //
    // *************************************************************************

    @Test
    public void testAppender1() throws IOException {
        final String testId    = "binary-vanilla-chronicle";
        final String threadId  = testId + "-th";
        final long   timestamp = System.currentTimeMillis();
        final Logger logger    = LoggerFactory.getLogger(testId);

        Thread.currentThread().setName(threadId);

        for(ChronologyLogLevel level : LOG_LEVELS) {
            log(logger,level,"level is {}",level.levelStr);
        }

        Chronicle          chronicle = getVanillaChronicle(testId);
        ExcerptTailer      tailer    = chronicle.createTailer().toStart();
        ChronologyLogEvent evt       = null;

        for(ChronologyLogLevel level : LOG_LEVELS) {
            assertTrue(tailer.nextIndex());

            evt = ChronologyLogHelper.decodeBinary(tailer);
            assertNotNull(evt);
            assertEquals(evt.getVersion(), Chronology.VERSION);
            assertEquals(evt.getType(), Chronology.TYPE_LOG4J_2);
            assertTrue(evt.getTimeStamp() >= timestamp);
            assertEquals(level,evt.getLevel());
            assertEquals(threadId, evt.getThreadName());
            assertEquals(testId, evt.getLoggerName());
            assertEquals("level is {}", evt.getMessage());
            assertNotNull(evt.getArgumentArray());
            assertEquals(1, evt.getArgumentArray().length);
            assertEquals(level.levelStr , evt.getArgumentArray()[0]);

            tailer.finish();
        }

        tailer.close();
        chronicle.close();
    }

    @Test
    public void testBinaryAppender2() throws IOException {
        final String testId    = "binary-vanilla-chronicle-fmt";
        final String threadId  = testId + "-th";
        final long   timestamp = System.currentTimeMillis();
        final Logger logger    = LoggerFactory.getLogger(testId);

        Thread.currentThread().setName(threadId);

        for(ChronologyLogLevel level : LOG_LEVELS) {
            log(logger,level,"level is {}",level.levelStr);
        }

        Chronicle          chronicle = getVanillaChronicle(testId);
        ExcerptTailer      tailer    = chronicle.createTailer().toStart();
        ChronologyLogEvent evt       = null;

        for(ChronologyLogLevel level : LOG_LEVELS) {
            assertTrue(tailer.nextIndex());

            evt = ChronologyLogHelper.decodeBinary(tailer);
            assertNotNull(evt);
            assertEquals(evt.getVersion(), Chronology.VERSION);
            assertEquals(evt.getType(), Chronology.TYPE_LOG4J_2);
            assertTrue(evt.getTimeStamp() >= timestamp);
            assertEquals(level,evt.getLevel());
            assertEquals(threadId, evt.getThreadName());
            assertEquals(testId, evt.getLoggerName());
            assertEquals("level is " + level.levelStr, evt.getMessage());
            assertNotNull(evt.getArgumentArray());
            assertEquals(0, evt.getArgumentArray().length);

            tailer.finish();
        }

        tailer.close();
        chronicle.close();
    }

    @Test
    public void testTextAppender1() throws IOException {
        final String testId    = "text-vanilla-chronicle";
        final String threadId  = testId + "-th";
        final Logger logger    = LoggerFactory.getLogger(testId);

        Thread.currentThread().setName(threadId);

        for(ChronologyLogLevel level : LOG_LEVELS) {
            log(logger,level,"level is {}",level.levelStr);
        }

        Chronicle          chronicle = getVanillaChronicle(testId);
        ExcerptTailer      tailer    = chronicle.createTailer().toStart();
        ChronologyLogEvent evt       = null;

        for(ChronologyLogLevel level : LOG_LEVELS) {
            assertTrue(tailer.nextIndex());

            evt = ChronologyLogHelper.decodeText(tailer);
            assertNotNull(evt);
            assertEquals(level,evt.getLevel());
            assertEquals(threadId, evt.getThreadName());
            assertEquals(testId, evt.getLoggerName());
            assertEquals("level is " + level.levelStr, evt.getMessage());
            assertNotNull(evt.getArgumentArray());
            assertEquals(0, evt.getArgumentArray().length);

            tailer.finish();
        }

        tailer.close();
        chronicle.close();
    }
}
