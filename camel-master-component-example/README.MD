*This example is not working on Fuse 7.7 because of the bug [ENTESB-14591](https://issues.redhat.com/browse/ENTESB-14591)*

# Camel Master Component Example using Blueprint configuration and Apache Zookeeper

This example demonstrate how to use the Camel Master component with a Apache Zookeper to handle the the election of the master node. 

## To run the tests

You can validate the code just running the test class `src/test/java/com/angelogalvao/BlueprintBeanPropertiesOverrideFromFileRouteTest.java`

```
$ mvn clean verify
```

## To build and deploy on Red Hat Fuse 7

- First, build the bundle:

```
$ mvn clean install -DskipTests
```

- Start the Apache Zookeeper ( Be sure to [configure it](https://zookeeper.apache.org/doc/r3.6.1/zookeeperStarted.html) before you run it ):

```
$ cd /path/to/zookeeper
$ bin/zkServer.sh start 
```

- Start Red Hat Fuse 7:

```
$ cd /path/to/fuse
$ bin/fuse
```

- Install the Persistent ID(PID) for the server identifier:

```
karaf@root()> config:edit camel-master-component-example
karaf@root()> config:property-set server-id server1
karaf@root()> config:update
```

- Install the required camel features:

```
karaf@root()> feature:install camel-master
karaf@root()> feature:install camel-zookeeper
```

- Install and start the bundle:

```
karaf@root()> install -s mvn:com.angelogalvao/camel-master-component-example/1.0.0
```

- To validate if everything is installed correctly, look at the server logs:

```
karaf@root()> log:tail
```

It should print a message like this every 10 seconds:

```
INFO [Camel (camel-master-component-example-context) thread #_ - timer://foo] Hello from server1!
```

Hit Control + C to exit the log.