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
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
@RunWith(Arquillian.class)
public class ConfigurationIT {

    @Inject
    private Configuration configuration;

    @Deployment
    public static JavaArchive createTestArchive()
    {
        JavaArchive archive = ShrinkWrap.create(JavaArchive.class)
                .addPackages(true, RootCorePackage.class.getPackage())
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml");
        return archive;
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetConfigurationMap() {
        configuration.getConfigurationMap().clear();
    }

    @Test
    public void testGetString() {
        Assert.assertNotNull(configuration.getString(ConfigurationItemType.MONITORING_CONSOLE_ACTIVATED));
        Assert.assertTrue(Boolean.parseBoolean(configuration.getString(ConfigurationItemType.MONITORING_CONSOLE_ACTIVATED)));

        Assert.assertNotNull(configuration.getString(ConfigurationItemType.MONITORING_JMX_ACTIVATED));
        Assert.assertTrue(Boolean.parseBoolean(configuration.getString(ConfigurationItemType.MONITORING_JMX_ACTIVATED)));
    }
}
