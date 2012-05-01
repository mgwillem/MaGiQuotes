package org.magi.quotes.core.configuration.boundary;

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
 * @author MGW
 */
@RunWith(Arquillian.class)
public class ConfigurationUtilIT {

    @Inject
    private Configuration configuration;

    @Inject
    private ConfigurationUtil configurationUtil;

    @Deployment
    public static JavaArchive createTestArchive()
    {
        JavaArchive archive = ShrinkWrap.create(JavaArchive.class)
                .addPackages(true, RootCorePackage.class.getPackage())
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml");
        return archive;
    }

    @Test
    public void testDump() {
        Assert.assertNotNull(configurationUtil.dump(configuration.getConfigurationMap()));
        Assert.assertTrue(configurationUtil.dump(configuration.getConfigurationMap()).length() > 0);
    }
}
