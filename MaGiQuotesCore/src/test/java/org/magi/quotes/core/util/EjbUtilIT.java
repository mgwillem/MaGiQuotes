package org.magi.quotes.core.util;

import org.magi.quotes.core.RootCorePackage;
import org.magi.quotes.core.audit.boundary.MonitoringApplication;
import junit.framework.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.util.Date;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
@RunWith(Arquillian.class)
public class EjbUtilIT 
{
    @EJB
    private CrudService<Object> service;
    
    private static final Long millis = new Date().getTime();
    
    @Deployment
    public static JavaArchive createTestArchive() 
    {
        JavaArchive archive = ShrinkWrap.create(JavaArchive.class)
                .addPackages(true, RootCorePackage.class.getPackage())
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml");
        return archive;
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("@@@@@ Integration test EjbUtilTest took : " + (new Date().getTime() - millis) + " millis");
    }

    @Test
    public void testInjectedResource() 
    {
        Assert.assertNotNull("Cannot find the injected resource...", service);
    }
    
    @Test
    public void testLookupedResource()
    {
        Assert.assertNotNull("Cannot find the injected resource...", EjbUtil.lookup(CrudService.class));
    }
}
