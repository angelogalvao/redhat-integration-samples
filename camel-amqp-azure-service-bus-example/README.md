# Camel AMQP + Azure Service Bus Example 

This example demonstrates how you can use Apache Camel AMQP component to connect to a Azure Service Bus Queue and Topic. 

The example uses Fuse, version 7.6, on Spring Boot to configure a little application that includes a Camel route that triggers a message to a Azure Service Bus Queue and topic every 10th second and consumes it.

### Configure Azure Service Bus

This example uses these Azure Service Bus resources:

- A Queue with name **sample-queue**
- A Topic with name **sample-topic**
- A subscription with name **my-subscription** for the topic **sample-topic**

### Configure the example

You should edit the 'src/main/resources/application.properties' file to point to your Azure Service Bus service. These're the properties:

- **broker.url** : *Azure Service Bus URL*
- **camel.component.amqp.username** : *This value is the Police name which is configured in Shared access policies page. Usually this value is RootManageSharedAccessKey.*
- **camel.component.amqp.password** : *This value is the primary key which is configured in Shared access policies page.*

### Execute the example

To run this example, execute this command:

    mvn clean spring-boot:run

### Running the example in OpenShift

It is assumed that:
- OpenShift platform is already running, if not you can find details how to [Install OpenShift at your site](https://docs.openshift.com/container-platform/3.3/install_config/index.html).
- Your system is configured for Fabric8 Maven Workflow, if not you can find a [Get Started Guide](https://access.redhat.com/documentation/en/red-hat-jboss-middleware-for-openshift/3/single/red-hat-jboss-fuse-integration-services-20-for-openshift/)

The example can be built and run on OpenShift using a single goal:

    mvn fabric8:deploy

When the example runs in OpenShift, you can use the OpenShift client tool to inspect the status

To list all the running pods:

    oc get pods

Then find the name of the pod that runs this quickstart, and output the logs from the running pods with:

    oc logs <name of pod>

You can also use the OpenShift [web console](https://docs.openshift.com/container-platform/3.3/getting_started/developers_console.html#developers-console-video) to manage the
running pods, and view logs and much more.

### Running via an S2I Application Template

Application templates allow you deploy applications to OpenShift by filling out a form in the OpenShift console that allows you to adjust deployment parameters.  This template uses an S2I source build so that it handle building and deploying the application for you.

First, import the Fuse image streams:

    oc create -f https://raw.githubusercontent.com/jboss-fuse/application-templates/GA/fis-image-streams.json

Then create the quickstart template:

    oc create -f https://raw.githubusercontent.com/jboss-fuse/application-templates/GA/quickstarts/spring-boot-camel-template.json

Now when you use "Add to Project" button in the OpenShift console, you should see a template for this quickstart. 

