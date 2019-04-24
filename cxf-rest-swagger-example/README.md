# Fuse (CXF and Camel CXF) Swagger integration example.

This examples demonstrates how to integrate Swagger with both CXF and Camel CXF endpoint using JBoss Fuse 6.3 version.

### Building

The example can be built with

    mvn clean install

### Deploy on Fuse

- First create Fuse Fabric on the Fuse shell:

```
JBossFuse:karaf@root> fabric:create --resolver manualip --manual-ip 127.0.0.1 --wait-for-provisioning
```

- Then create and configure a profile with the following commands:

```
JBossFuse:karaf@root> fabric:profile-create --parent feature-camel --parent feature-cxf test-swagger
JBossFuse:karaf@root> fabric:profile-edit --feature camel-cxf --feature swagger --bundle mvn:com.angelogalvaoo.samples/cxf-rest-swagger-example/1.0.0 test-swagger
```

- Finally create a container:

```
JBossFuse:karaf@root> fabric:container-create-child --profile test-swagger1 root test-container-swagger
```

### Look at the Swagger UI page.

- Log in the Fuse Console: http://localhost:8181
- Go the the TAB: Services -> API
- Then select Swagger from the endpoint list.

