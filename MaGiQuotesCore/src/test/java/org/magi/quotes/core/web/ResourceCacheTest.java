package org.magi.quotes.core.web;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author MGW
 */
public class ResourceCacheTest {

    private ResourceCache resourceCache;

    @Before
    public void setUp() throws Exception {
        resourceCache = new ResourceCache();
        resourceCache.init();
    }

    @Test
    public void testIsCached() throws Exception {
        Assert.assertTrue(resourceCache.isCached("theme.css"));
        Assert.assertTrue(resourceCache.isCached("primefaces.css"));
        Assert.assertTrue(resourceCache.isCached("layout.css"));

        Assert.assertTrue(resourceCache.isCached("jquery.js"));
        Assert.assertTrue(resourceCache.isCached("primefaces.js"));
        Assert.assertTrue(resourceCache.isCached("layout.js"));
        Assert.assertTrue(resourceCache.isCached("jsf.js"));

        Assert.assertTrue(resourceCache.isCached(".gif"));
        Assert.assertTrue(resourceCache.isCached(".png"));
        Assert.assertTrue(resourceCache.isCached(".jpg"));

        Assert.assertFalse(resourceCache.isCached(".xhtml"));
        Assert.assertFalse(resourceCache.isCached(".html"));
        Assert.assertFalse(resourceCache.isCached(".jsp"));
    }
}
