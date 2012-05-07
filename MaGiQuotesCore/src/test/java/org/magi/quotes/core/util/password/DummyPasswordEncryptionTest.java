package org.magi.quotes.core.util.password;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
public class DummyPasswordEncryptionTest {

    @Test
    public void testEncrypt() throws Exception {
        Assert.assertEquals("test", new DummyPasswordEncryption().encrypt("test"));
        Assert.assertNull(new DummyPasswordEncryption().encrypt(null));
    }

}
