package org.magi.quotes.core.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.magi.quotes.core.audit.entity.EmbeddableAuditColumns;

/**
 * @author MGW
 */
public class JpaUtilTest {
    
    private JpaUtil jpaUtil;
    
    @Before
    public void setUp() throws Exception {
        jpaUtil = new JpaUtil();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExtractPersistentTableName() throws Exception {
        jpaUtil.extractPersistentTableName(String.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExtractPersistentColumnNameListIllegal() throws Exception {
        jpaUtil.extractPersistentTableName(String.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExtractPersistentColumnNameListIllegal2() throws Exception {
        jpaUtil.extractPersistentTableName(EmbeddableAuditColumns.class);
    }
}
