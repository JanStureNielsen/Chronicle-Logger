package com.higherfrequencytrading.chronology.logback;

import net.openhft.lang.io.IOTools;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@Ignore
public class LogbackIndexedChroniclePerfTest extends LogbackTestBase {

    // *************************************************************************
    //
    // *************************************************************************

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // *************************************************************************
    // BINARY
    // *************************************************************************

    @Test
    public void testSingleThreadLogging1() throws IOException {
        Thread.currentThread().setName("perf-plain-indexed");

        final Logger clogger   = LoggerFactory.getLogger("perf-binary-indexed-chronicle");
        final Logger plogger   = LoggerFactory.getLogger("perf-plain-indexed");
        final long   items     = 10000;

        for(int s=64; s <= 1024 ;s += 64) {
            final String staticStr = StringUtils.leftPad("", s, 'X');

            long cStart1 = System.nanoTime();

            for (int i = 1; i <= items; i++) {
                clogger.info(staticStr);
            }

            long cEnd1 = System.nanoTime();

            long pStart1 = System.nanoTime();

            for (int i = 1; i <= items; i++) {
                plogger.info(staticStr);
            }

            long pEnd1 = System.nanoTime();

            System.out.printf("items=%03d size=%04d=> chronology=%.3f, plain=%.3f\n",
                items,
                staticStr.length(),
                (cEnd1 - cStart1) / items / 1e3,
                (pEnd1 - pStart1) / items / 1e3);
        }

        IOTools.deleteDir(rootPath());
    }

    @Test
    public void testSingleThreadLogging2() throws IOException {
        Thread.currentThread().setName("perf-plain-indexed");

        final Logger clogger   = LoggerFactory.getLogger("perf-binary-indexed-chronicle");
        final Logger plogger   = LoggerFactory.getLogger("perf-plain-indexed");
        final long   items     = 10000;
        final String strFmt    = StringUtils.leftPad("> v1={}, v2={}, v3={}", 32, 'X');

        for(int n=0;n<10;n++) {

            long cStart1 = System.nanoTime();

            for (int i = 1; i <= items; i++) {
                clogger.info(strFmt, i, i * 10, i / 16);
            }

            long cEnd1 = System.nanoTime();

            long pStart1 = System.nanoTime();

            for (int i = 1; i <= items; i++) {
                plogger.info(strFmt, i, i * 10, i / 16);
            }

            long pEnd1 = System.nanoTime();

            System.out.printf("items=%03d chronology=%.3f, plain=%.3f\n",
                items,
                (cEnd1 - cStart1) / items / 1e3,
                (pEnd1 - pStart1) / items / 1e3);
        }

        IOTools.deleteDir(rootPath());
    }
}
