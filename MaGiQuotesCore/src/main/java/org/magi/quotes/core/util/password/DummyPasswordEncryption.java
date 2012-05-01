package org.magi.quotes.core.util.password;

/**
 * This dummy class does not encrypt anything.
 * @author MGW
 */
@PasswordEncryptionType(type=Type.DUMMY)
public class DummyPasswordEncryption implements PasswordEncryption
{
    @Override
    public String encrypt(String source)
    {
        return source;
    }
}
