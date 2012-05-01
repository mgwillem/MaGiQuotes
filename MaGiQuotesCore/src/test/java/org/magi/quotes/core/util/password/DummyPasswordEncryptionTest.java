package org.magi.quotes.core.util.password;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author MGW
 */
public class DummyPasswordEncryptionTest {

    @Test
    public void testEncrypt() throws Exception {
        Assert.assertEquals("test", new DummyPasswordEncryption().encrypt("test"));
        Assert.assertNull(new DummyPasswordEncryption().encrypt(null));
    }

}
