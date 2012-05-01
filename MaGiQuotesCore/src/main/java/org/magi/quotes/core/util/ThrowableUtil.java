package org.magi.quotes.core.util;

/**
 * @author MGW
 */
public class ThrowableUtil 
{
    public static Throwable findOriginalCause(Throwable t)
    {
        if (t.getCause() != null) return findOriginalCause(t.getCause());
        
        return t;
    }
    
    public static boolean findMatchingCause(Throwable t, Class matchingCauseClazz)
    {
        if (t.getClass() == matchingCauseClazz) return true;
        if (t.getCause() == null) return false;
        
        return findMatchingCause(t.getCause(), matchingCauseClazz);
    }
    
    public static boolean isConcurrentModificationCause(Throwable t)
    {
        boolean concurrentModification = findMatchingCause(t, javax.persistence.OptimisticLockException.class);
        if (concurrentModification == false) t.printStackTrace();
        
        return concurrentModification;
    }
}
