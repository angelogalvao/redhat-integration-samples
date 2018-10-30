# Camel DSL with HTTPs in Fuse 6.3.x

A example how to use Camel DSL with HTTPs enabled in Fuse 6.3.x

The command that I used to create the keystore:

`$ keytool -genkey -alias jetty -keyalg RSA -keystore rest-dsl.jk`

The password is: example

I create a container in Fabric with the following configuration:

Profile id: redhat-support-camelrestssl
Version   : 1.0
Attributes: 
	parents: feature-camel
Containers: camel-rest-ssl-server

Container settings
Features : 
	camel-jetty
	camel-spring
