package org.magi.quotes;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.magi.quotes.core.RootCorePackage;

import javax.inject.Inject;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
@RunWith(Arquillian.class)
public class QueryModelFactoryIT {

    @Inject @QueryModelType
    private QueryModel queryModel;

    @Deployment
    public static JavaArchive createTestArchive()
    {
        JavaArchive archive = ShrinkWrap.create(JavaArchive.class)
                .addPackages(true, RootPackage.class.getPackage())
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml");
        return archive;
    }

    @Test
    public void testCreateQueryModel() throws Exception {

        Assert.assertNotNull(queryModel);
        Assert.assertNotNull(queryModel.getModel());
        Assert.assertTrue(!queryModel.getModel().isEmpty());
        Assert.assertEquals(queryModel.getModel().size(), 2);

    }
}
