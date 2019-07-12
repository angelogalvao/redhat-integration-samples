# Create a simple database

My example is using MS SQL:

CREATE TABLE [dbo].[TEST](
	[Id] [int] NOT NULL,
	[VALUE1] [nvarchar](50) NOT NULL,
	[VALUE2] [nvarchar](50) NOT NULL
) 

# Create a basic datasource

install -s mvn:org.osgi/org.osgi.service.jdbc

install -s mvn:com.microsoft.sqlserver/mssql-jdbc/7.2.2.jre8
install -s mvn:org.ops4j.pax.jdbc/pax-jdbc-mssql

service:list org.osgi.service.jdbc.DataSourceFactory

install -s mvn:org.ops4j.pax.jdbc/pax-jdbc
install -s mvn:org.ops4j.pax.jdbc/pax-jdbc-pool-common
install -s mvn:org.ops4j.pax.jdbc/pax-jdbc-config
 
bundle:services -p org.ops4j.pax.jdbc.config

config:edit --factory --alias mssql org.ops4j.datasource
config:property-set osgi.jdbc.driver.name mssql
config:property-set dataSourceName mssqlds
config:property-set url jdbc:sqlserver://localhost:1433;databaseName=test
config:property-set user sa
config:property-set password testpassword
config:update

config:list '(service.factoryPid=org.ops4j.datasource)'
service:list javax.sql.DataSource

feature:install -v jdbc
jdbc:ds-list

jdbc:query mssqlds 'select * from test'


# Deploy the bundle 

features:install jpa hibernate
install -s mvn:com.angelogalvao/fuse-blueprint-camel-jpa-datasource-example/1.0.0
