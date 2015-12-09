package com.martinrist.thinkingInJava.io;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DataInputAndOutputStreamTest {

    public static final boolean TEST_BOOLEAN_VALUE = false;
    public static final byte TEST_BYTE_VALUE = (byte) 1;
    public static final short TEST_SHORT_VALUE = (short) 2;
    public static final int TEST_INT_VALUE = 3;
    public static final long TEST_LONG_VALUE = 4L;
    public static final float TEST_FLOAT_VALUE = (float) 5.0;
    public static final double TEST_DOUBLE_VALUE = 6.0;

    private PipedInputStream pis = new PipedInputStream();
    private PipedOutputStream pos = new PipedOutputStream();

    private DataInputStream dis = new DataInputStream(pis);
    private DataOutputStream dos = new DataOutputStream(pos);

    @Before
    public void setUp() throws Exception {
        pis.connect(pos);
    }

    @Test
    public void test_GivenLinkedDataInputOutputStreams_WhenWritingToOutput_ThenExpectedValuesRead() throws IOException {

        dos.writeBoolean(TEST_BOOLEAN_VALUE);
        dos.writeByte(TEST_BYTE_VALUE);
        dos.writeShort(TEST_SHORT_VALUE);
        dos.writeInt(TEST_INT_VALUE);
        dos.writeLong(TEST_LONG_VALUE);
        dos.writeFloat(TEST_FLOAT_VALUE);
        dos.writeDouble(TEST_DOUBLE_VALUE);

        // 28 bytes are written and are available in the InputStream
        assertThat(dos.size(), is(28));
        assertThat(dis.available(), is(28));

        assertThat(dis.readBoolean(), is(TEST_BOOLEAN_VALUE));
        assertThat(dis.readByte(), is(TEST_BYTE_VALUE));
        assertThat(dis.readShort(), is(TEST_SHORT_VALUE));
        assertThat(dis.readInt(), is(TEST_INT_VALUE));
        assertThat(dis.readLong(), is(TEST_LONG_VALUE));
        assertThat(dis.readFloat(), is(TEST_FLOAT_VALUE));
        assertThat(dis.readDouble(), is(TEST_DOUBLE_VALUE));

    }

}
