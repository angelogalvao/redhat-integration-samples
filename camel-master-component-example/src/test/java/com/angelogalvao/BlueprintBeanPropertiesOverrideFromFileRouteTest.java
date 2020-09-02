package com.angelogalvao;

import java.io.IOException;

import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.test.TestingServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BlueprintBeanPropertiesOverrideFromFileRouteTest extends CamelBlueprintTestSupport {

    TestingServer zkTestServer;
    CuratorFramework cli;

    @Before
    public void startZookeeper() throws Exception {
        zkTestServer = new TestingServer(2181);
        cli = CuratorFrameworkFactory.newClient(zkTestServer.getConnectString(), new RetryOneTime(2000));
        cli.start();
    }

    @After
    public void stopZookeeper() throws IOException {
        cli.close();
        zkTestServer.stop();
    }
	
    @Override
    protected String getBlueprintDescriptor() {
        return "/OSGI-INF/blueprint/blueprint.xml";
    }

    @Override
    protected String[] loadConfigAdminConfigurationFile() {
        // which .cfg file to use, and the name of the persistence-id
        return new String[]{"src/test/resources/etc/camel-master-component-example.cfg", "camel-master-component-example"};
    }

    @Test
    public void testRoute() throws Exception {
        // the route is timer based, so every 5th second a message is send
        // we should then expect at least one message
        getMockEndpoint("mock:result").expectedMinimumMessageCount(1);

        // assert expectations
        assertMockEndpointsSatisfied();
    }

}
