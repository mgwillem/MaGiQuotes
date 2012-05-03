package org.magi.quotes.core.web;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 * @author MGW
 */
@RunWith(Arquillian.class)
public class FacesContextProducerIT {

    @Inject @Context
    private FacesContext context;

    @Deployment
    public static JavaArchive createTestArchive()
    {
        JavaArchive archive = ShrinkWrap.create(JavaArchive.class)
                .addClass(FacesContextProducer.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        return archive;
    }

    @Test
    public void testGetFacesContext() throws Exception {
        Assert.assertNotNull(context);
    }
}
