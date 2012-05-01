package org.magi.quotes.core.util.password;

import org.junit.*;
import org.magi.quotes.core.util.password.SimplePasswordEncryption;

/**
 * @author MGW
 */
public class SimplePasswordEncryptionTest {

    private SimplePasswordEncryption passwordEncryption;

    @Before
    public void setUp() throws Exception {
        passwordEncryption = new SimplePasswordEncryption();
    }

    @Test
    public void testEncrypt() {

        Assert.assertEquals("", passwordEncryption.encrypt(""));
        Assert.assertEquals("BA7816BF8F01CFEA414140DE5DAE2223B00361A396177A9CB410FF61F20015AD", passwordEncryption.encrypt("abc"));
        Assert.assertEquals("71C480DF93D6AE2F1EFAD1447C66C9525E316218CF51FC8D9ED832F2DAF18B73", passwordEncryption.encrypt("abcdefghijklmnopqrstuvwxyz"));

    }
}
