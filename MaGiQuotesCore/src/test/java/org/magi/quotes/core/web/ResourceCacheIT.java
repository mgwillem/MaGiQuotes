package org.magi.quotes.core.web;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author MGW
 */
@RunWith(Arquillian.class)
public class ResourceCacheIT
{
    @Inject
    private ResourceCache res;

    private static final Long millis = new Date().getTime();
    
    @Deployment
    public static JavaArchive createTestArchive() 
    {
        JavaArchive archive = ShrinkWrap.create(JavaArchive.class)
                .addClass(ResourceCache.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml");
        return archive;
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("@@@@@ Integration test CacheableResourceTest took : " + (new Date().getTime() - millis) + " millis");
    }
    
    @Test
    public void testInjectedResource() 
    {
        assertNotNull("Cannot find the injected resource...", res);
    }

    @Test
    public void testCachedResource() 
    {
        assertTrue(res.isCached("shoulbecached.jpg"));
        assertFalse(res.isCached("shoulbenotbecached.html"));
    }
}
