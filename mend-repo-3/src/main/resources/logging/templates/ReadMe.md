# Using the JSON Template Layout
This document provides a strategy for implementing structured log events where each log event is a JSON document that can be imported into ElasticSearch for further analysis. Two (maybe more in the future) json template files will be provided...
1. **_template.json_** for general purpose log events.
2. **_performance-template.json_** for performance related (i.e. processing time, etc) log events.

These template files and some basic Java functionality will be provided for use by any components that need to implement logging in a structured JSON format.
The template files define a JSON template that can be referenced from a log4j configuration to generate logs in a predefined format.
[See the log4j documentation for the json template layout for details of all the options available when defining a template.](https://logging.apache.org/log4j/2.x/manual/json-template-layout.html)
This document was written with reference to log4j release 2.14.1.

**Note: The org.apache.logging.log4j.layout.template.json.JsonTemplateLayout class was introduced in log4j release 2.14.0, so use of the template file will not be possible with earlier versions.**

## Template properties
Details about each of the defined properties in the _template.json_ file is explained in the following table.  The properties in the _performance-template.json_ file are merely a subset of these properties.
Note that these properties usually only appear in the log event if values exist for them. However there are some scenarios where I have seen a _null_ value for a property in the log for the _application domain/name/version_ properties before they are initialised.

| Template Property      | Description                                                                                                                                                                                                                                                                                                | Code Changes Required                                                                                                                                                                                                                                                                                                                            | Limitations                                                                                                                                                                   |
| ---------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------  |
| **timestamp**          | The timestamp of the log event in the default format, e.g. 2021-04-21T09:45:49.259+01:00                                                                                                                                                                                                                   |**No**                                                                                                                                                                                                                                                                                                                                            |                                                                                                                                                                               |
| **applicationDomain**  | The application domain, e.g. events, etc. This value will be looked up using [MainMapLookup](https://logging.apache.org/log4j/2.x/log4j-core/apidocs/org/apache/logging/log4j/core/lookup/MainMapLookup.html) using the key _applicationDomain_.                                                           |**Yes**, the value for this property should be registered appropriately by the application at startup or it will not be populated. See _aero.sita.bordermanagement.itp.logging.LoggingProperties_ which allows the application to register the _applicationDomain_, _applicationName_ and _applicationVersion_ at startup.  |                                                                                                                                                                               |
| **applicationName**    | The application name, e.g. itp-events-ingester, etc. This value will be looked up similarly to _applicationDomain_ but uses the key _applicationName_.                                                                                                                                                     |**Yes**, same as for _applicationDomain_.                                                                                                                                                                                                                                                                                                         |                                                                                                                                                                               |
| **applicationVersion** | The application version, e.g. 1.4-SNAPSHOT, etc. This value will be looked up similarly to _applicationDomain_ but uses the key _applicationVersion_.                                                                                                                                                      |**Yes**, same as for _applicationDomain_.                                                                                                                                                                                                                                                                                                         |                                                                                                                                                                               |
| **loggerName**         | The name of the logger, i.e. usually the class name.                                                                                                                                                                                                                                                       |**No**                                                                                                                                                                                                                                                                                                                                            |                                                                                                                                                                               |
| **level**              | The log level, i.e. TRACE, DEBUG, etc.                                                                                                                                                                                                                                                                     |**No**                                                                                                                                                                                                                                                                                                                                            |                                                                                                                                                                               |
| **mappedContext**      | The key and value of each entry in the Log4J thread context map.                                                                                                                                                                                                                                           |**No**                                                                                                                                                                                                                                                                                                                                            | Any compound values will be output as strings using their .toString() method. [See limitations on compound objects for further details](#compound-objects-on-the-mdc-or-ndc)  |
| **host**               | The host name.                                                                                                                                                                                                                                                                                             |**No**                                                                                                                                                                                                                                                                                                                                            |                                                                                                                                                                               |
| **thread**             | The thread name.                                                                                                                                                                                                                                                                                           |**No**                                                                                                                                                                                                                                                                                                                                            |                                                                                                                                                                               |
| **nestedContext**      | The key and value of each entry in the Log4J thread context stack.                                                                                                                                                                                                                                         |**No**                                                                                                                                                                                                                                                                                                                                            | Any compound values will be output as strings using their .toString() method. [See limitations on compound objects for further details](#compound-objects-on-the-mdc-or-ndc)  |
| **message**            | The logged message. Either a simple string logged in the message.asString property or a composite object.                                                                                                                                                                                                  |**No** for simple string messages,<br/> **Yes** if a message that is a composite object is required. [See messages section for details](#messages)                                                                                                                                                                                                |                                                                                                                                                                               |
| **exception**          | The details of any exception including the stack trace. Each element of any stack trace will be logged as a separate JSON array element. [See Exceptions template for details.](#exceptions). Note that this only includes details of the outermost exception and any child exceptions will not be logged. |**No**                                                                                                                                                                                                                                                                                                                                            |                                                                                                                                                                               |
| **exceptionRootCause** | The details of the root cause of an exception with the same properties as the outermost exception. [See Exceptions template for details.](#exceptions).                                                                                                                                                    |**No**                                                                                                                                                                                                                                                                                                                                            |                                                                                                                                                                               |

## Messages
The definition of the _message_ property of the logged event supports log events that have a simple string message as well as log events that have a composite message. Both types of messages can co-exist in a single log file. However, when the log file is imported into ElasticSearch it will complain as it won't be able to generate a mapping where the message property is both a _string_ type as well as being of type _object_. The use of the _fallbackKey_ overcomes this issue by logging simple strings in the _asString_ property of _message_ thus removing any type conflicts.<br/>
e.g. the log event for the following code...
```java
    logger.info("A message that is a simple string.");
```
would generate the following in the log (note the **_asString_** property of _message_.)...
```json
{
	"timestamp": "2021-04-22T17:02:53.131+01:00",
	"loggerName": "logger",
	"level": "INFO",
	"message": {
		"asString": "A message that is a simple string."
	}
}
```
whereas, generating a log message with a structured message...
```java
    logger.info(
            new MapMessage<>()
                .with("text", "logged with a map representation of the composite object")
                .with(
                        "payload",
                        objMapper.convertValue(comp, Map.class)
                )
    );
```
would generate the following in the log...
```json
{
	"timestamp": "2021-04-22T17:02:53.182+01:00",
	"loggerName": "logger",
	"level": "INFO",
	"message": {
		"payload": {
			"compositeProp": {
				"innerCompositeProp1": "value2",
				"innerCompositeProp2": "value3"
			},
			"simpleProp": "value1"
		},
		"text": "logged with a map representation of the composite object"
	}
}
```
Note the use of _com.fasterxml.jackson.databind.ObjectMapper_ to convert the object into a _Map_ which is then passed into the log4j framework.
If the object is passed directly to the log4j framework, then the log representation of the object will be generated using the .toString() method of the object.
This is a limitation of the current version of log4j, [See limitations on compound objects for further details](#compound-objects-on-the-mdc-or-ndc)
## Exceptions
Exceptions will be logged as follows...
```json
	"exception": {
		"exception_class": "java.lang.Exception",
		"exception_message": "Outer Exception",
		"stacktrace": [
			{
				"class": "explore.log4j.json.template.layout.Main",
				"method": "function",
				"file": "Main.java",
				"line": 26
			},
			{
				"class": "explore.log4j.json.template.layout.Main",
				"method": "main",
				"file": "Main.java",
				"line": 17
			}
		]
	},
```
Note that the the _exception_ property only logs the outermost exception. The innermost exception, i.e. the root cause will be logged as the _exceptionRootCause_ property.

## Limitations
### Compound objects on the MDC or NDC
Although this section refers to compound objects on the MDC or NDC it also applies to compound objects that are passed directly to the log4j framework in the log function calls, e.g. The following call to the logging framework...
```java
        Composite comp = new Composite("value1", "value2", "value3");
        Logger logger = LogManager.getLogger("logger");
        logger.info(
                new MapMessage<>()
                    .with("text", "logged with a map representation of the composite object")
                    .with(
                            "payload",
                            comp
                    )
        );
```
will produce the following log message...
```json
{
	"timestamp": "2021-04-23T11:42:09.262+01:00",
	"loggerName": "logger",
	"level": "INFO",
	"message": {
		"payload": "explore.log4j.json.template.layout.Composite@76012793",
		"text": "logged with a map representation of the composite object"
	}
}
```
Note that the _payload_ property of the log event corresponding to the _comp_ object has been generated using the .toString() method of the Java class.
As already mentioned in the [section on messages)[#messages]] there is a simple workaround to this that allows the _payload_ property to be nicely generated as JSON, i.e. convert it into a _Map_ and then pass the _Map_ instance to the logging framework, e.g. the following code...
```java
        ObjectMapper objMapper = new ObjectMapper();
        Composite comp = new Composite("value1", "value2", "value3");
        Logger logger = LogManager.getLogger("logger");
        logger.info(
                new MapMessage<>()
                    .with("text", "logged with a map representation of the composite object")
                    .with(
                            "payload",
                            objMapper.convertValue(comp, Map.class)
                    )
        );
```
will produce the following log message...
```json
{
	"timestamp": "2021-04-23T11:47:34.138+01:00",
	"loggerName": "logger",
	"level": "INFO",
	"message": {
		"payload": {
			"compositeProp": {
				"innerCompositeProp1": "value2",
				"innerCompositeProp2": "value3"
			},
			"simpleProp": "value1"
		},
		"text": "logged with a map representation of the composite object"
	}
}
```
The _payload_ property is now generated in a much more structured manner.
However, this workaround of converting the object into a _Map_ is not possible with objects on the MDC/NDC, so the log representation of those objects will always be generated using the toString() method. This should not be a big issue as there is a workaround is available for the _message_ property, and the toString() representation of objects on the MDC/NDC is still better than nothing.
[An improvement request has been raised with Log4J, so this limitation may well be addressed in the future](https://issues.apache.org/jira/browse/LOG4J2-3082)

### LOG4J 1.x loggers
Any log events generated using Log4J 1.x loggers (these are always simple string message, usually generated by 3rd party components, log events with structured log messages cannot be generated using Log4J 1.x loggers) are currently generated incorrectly by the logging framework. The generated log event does not use the _asString_ property of _message_, i.e. it is generated as...
```json
	{
		"timestamp": "2021-04-23T13:26:33.265+01:00",
		"loggerName": "logger",
		"level": "INFO",
		"message": "Simple log message"
	}

```
instead of 
```json
	{
		"timestamp": "2021-04-23T13:26:33.258+01:00",
		"loggerName": "logger",
		"level": "INFO",
		"message": {
			"asString": "Simple log message"
		}
	}
```
[A bug has been raised with Log4J, so this will be addressed in a future release](https://issues.apache.org/jira/browse/LOG4J2-3080)

## Use of SLF4J
Any log events currently generated using the SLF4J facade will work correctly and generate log events with simple string _message_ properties.
However, new log events with structured messages will not be possible. 
SLF4J does not support structured logging. Some support was added in v2.0.0, but this version has been in alpha since Oct 2019.
There have also been no significant updates to the [SLF4J source base](https://github.com/qos-ch/slf4j.git) for over a year.
The proposal is to stop using SLF4J.

## Referencing the JSON layout template in the Log4J configuration file and customising the layout.
The JSON layout template can be referenced in the Log4J configuration file by using it in an _Appender_as follows...
```xml
    <Appender name="LogFile" type="File" fileName="./logs/itp-event-ingester.log">
      <JsonTemplateLayout charset="UTF-8" eventTemplateUri="classpath:logging/templates/template.json" />
    </Appender>
```
You can also add custom properties to the supplied default template by using the appropriate resolver to retrieve the property value. [See the _Event Template Resolvers_ section of the Log4J JSON Template Layout documentation for the available set of resolvers](https://logging.apache.org/log4j/2.x/manual/json-template-layout.html). e.g. the following appender adds a custom property called _messageKey_ to the log event, the value of which is picked up from the Thread Context Map (MDC).
```xml
    <Appender name="PerformanceLogFile" type="File" fileName="./logs/itp-ingester-performance.log">
      <JsonTemplateLayout charset="UTF-8" eventTemplateUri="classpath:logging/templates/performance-template.json">
        <EventTemplateAdditionalField key="messageKey" format="JSON" value='{ "$resolver": "map", "key": "messageKey" }' />
      </JsonTemplateLayout>
    </Appender>
```
This will generate a log event similar to the following...
```json
{
	"timestamp": "2021-04-21T16:05:33.086+01:00",
	"applicationDomain": "events",
	"applicationName": "itp-event-ingester",
	"applicationVersion": "1.4.335470-POC-SNAPSHOT",
	"loggerName": "performance",
	"level": "INFO",
	"host": "ALDLT5CG8520F12",
	"processingTimeMillis": 508,
	"messageKey": "N-Oa4ABfwcpUFBrbG_hqKj"
}
```
Note that the custom _messageKey_ property is from the customisation in the log4j configuration and the _processingTimeMillis_ property is using the definition from the _performance-template.json_ file.
Any custom properties with the same key/name as a property in the template file will oevrride the definition in the template file, so even the definitions of properties in the template file can be overridden.

## Implementation strategy
The proposed implementation strategy consists of the following phases...

### Phase 1: Generate a log file with log events in the JSON format.
This phase does not need any code changes. It just logs all events in JSON format with a simple change to the Log4J configuration file. This can be accomplished by either adding (to generate an additional log file in JSON format) or modifying (to replace an existing log file with one in JSON format) an _Appender_ that uses the supplied template.
```xml
    <Appender name="LogFile" type="File" fileName="./logs/itp-event-ingester.log">
      <JsonTemplateLayout charset="UTF-8" eventTemplateUri="classpath:logging/templates/template.json" />
    </Appender>
```
Note that the resulting log file consists of one log event (in JSON format) per line. The log file itself is not a well-formed JSON document as it will be missing the JSON array square brackets and the comma separators.

### Phase 2: Start logging the _applicationDomain_, _applicationName_ and _applicationVersion_ properties.
This phase needs minimal code changes. It merely involves registering the values for these 3 properties at application startup using _org.apache.logging.log4j.core.lookup.MainMapLookup.setMainArguments(String...)_, e.g.
```java
MainMapLookup.setMainArguments("applicationDomain", appDomain, "applicationName", appName, "applicationVersion", appVersion);
```
The application domain and name can be hard-coded and the version can be obtained using the [Maven Templating PlugIn](https://www.mojohaus.org/templating-maven-plugin/usage.html) but it is up to the application to work this out.
	
### Phase 3: Remove the SLF4J dependency.
Remove the SLF4J dependency and replace any SLF4J loggers with the equivalent Log4J 2.x loggers.

### Phase 4: Switch to structured logging where required.
Improve any log statements to make them more structured so that it is easier to analyse them in Elastic, e.g. the following performance log statement...
```java
logger.info("Total processing time {}ms", totalProcessingTime);
```
would generate the following log event
```json
	{
		"timestamp": "2021-04-23T16:30:07.296+01:00",
		"loggerName": "logger",
		"level": "INFO",
		"message": {
			"asString": "Total processing time 666ms"
		}
	}
```
where the actual processing time is embedded in the message string and will thus be harder to analyse in Elastic, e.g. it would not be easy to find the lowest or highest processing time. Instead, this event could be logged using...
```java
    logger.info(
        new MapMessage<>()
        .with("processingTimeMillis", totalProcessingTime)
    );
```
which would generate the log event as follows...
```json
	{
		"timestamp": "2021-04-23T16:30:07.296+01:00",
		"loggerName": "logger",
		"level": "INFO",
		"message": {
			"processingTimeMillis": 666
		}
	}
```
This will be much easier to analyse in Elastic as the important information, i.e. the processing time is available in a simple number field.