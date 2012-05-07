package org.magi.quotes.core.util.password;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
@PasswordEncryptionType(type=Type.SHA256)
public class SimplePasswordEncryption implements PasswordEncryption
{
    @Override
    public String encrypt(String source)
    {
        if (source == null) return null;
        if (source.length() == 0) return source; // Empty password.

        try
        {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(source.getBytes(), 0, source.length());

            return new BigInteger(1, messageDigest.digest()).toString(16).toUpperCase();
        }
        catch (NoSuchAlgorithmException e)
        {
            return null;
        }
    }
}
