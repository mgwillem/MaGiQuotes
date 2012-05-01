package org.magi.quotes.core.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author MGW
 */
public class ThrowableUtilTest {

    @Test
    public void testFindOriginalCause() throws Exception {
        Throwable cause = ThrowableUtil.findOriginalCause(new IllegalStateException(new IllegalArgumentException()));
        Assert.assertTrue(cause instanceof IllegalArgumentException);
    }

    @Test
    public void testFindMatchingCause() throws Exception {
        boolean match = ThrowableUtil.findMatchingCause(new IllegalStateException(new IllegalArgumentException()), IllegalArgumentException.class);
        Assert.assertTrue(match);
    }

    @Test
    public void testIsConcurrentModificationCause() throws Exception {
        Assert.assertTrue(ThrowableUtil.isConcurrentModificationCause(new javax.persistence.OptimisticLockException()));
        Assert.assertFalse(ThrowableUtil.isConcurrentModificationCause(new IllegalArgumentException()));
    }
}
