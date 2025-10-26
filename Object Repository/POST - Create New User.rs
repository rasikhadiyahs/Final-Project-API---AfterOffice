<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>POST - Create New User</name>
   <tag></tag>
   <elementGuidId>f004a234-5041-4ec3-b08f-d1e75bfad054</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>true</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;first_name\&quot;: \&quot;${first_name}\&quot;,\n  \&quot;last_name\&quot;: \&quot;${last_name}\&quot;,\n  \&quot;username\&quot;: \&quot;${username}\&quot;,\n  \&quot;job_position\&quot;: \&quot;${job_position}\&quot;,\n  \&quot;job_level\&quot;: \&quot;${job_level}\&quot;,\n  \&quot;salary\&quot;: ${salary},\n  \&quot;work_duration\&quot;: ${work_duration}\n}\n&quot;,
  &quot;contentType&quot;: &quot;text/plain&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>apikey</name>
      <type>Main</type>
      <value>${GlobalVariable.API_KEY}</value>
      <webElementGuid>b38756ae-c1cc-4025-a10b-b5207f720f6e</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>${GlobalVariable.Authorization}</value>
      <webElementGuid>17b9401e-8aaf-4829-a4ad-2cc8f1bbe093</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>f56b8fc1-8720-4b2b-a2dc-217f1c862305</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Prefer</name>
      <type>Main</type>
      <value>return=representation</value>
      <webElementGuid>4fb04539-0cb9-46ed-81c2-2f6030ed7c80</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>10.3.1</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.BASE_URL}/users</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'rasikha'</defaultValue>
      <description></description>
      <id>60856cf2-5337-43fe-a130-81744034a372</id>
      <masked>false</masked>
      <name>first_name</name>
   </variables>
   <variables>
      <defaultValue>'diyah'</defaultValue>
      <description></description>
      <id>987b78a1-4e40-4ac3-8949-1080cde2b35c</id>
      <masked>false</masked>
      <name>last_name</name>
   </variables>
   <variables>
      <defaultValue>'rasikha2'</defaultValue>
      <description></description>
      <id>8b4a964f-7b56-4932-80b5-23c444a62ab7</id>
      <masked>false</masked>
      <name>username</name>
   </variables>
   <variables>
      <defaultValue>'QA Engineer'</defaultValue>
      <description></description>
      <id>9f873714-ec30-41b3-be00-11c048ece438</id>
      <masked>false</masked>
      <name>job_position</name>
   </variables>
   <variables>
      <defaultValue>'Mid'</defaultValue>
      <description></description>
      <id>b36d9d80-f717-4e2c-90ab-cc77b218c505</id>
      <masked>false</masked>
      <name>job_level</name>
   </variables>
   <variables>
      <defaultValue>0</defaultValue>
      <description></description>
      <id>84e95eea-eede-44ac-aee6-997d176e4ffa</id>
      <masked>false</masked>
      <name>salary</name>
   </variables>
   <variables>
      <defaultValue>2</defaultValue>
      <description></description>
      <id>03bcd455-0bf4-428b-be61-2c89bc1d30a4</id>
      <masked>false</masked>
      <name>work_duration</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()


WS.verifyResponseStatusCode(response, 201)

assertThat(response.getStatusCode()).isEqualTo(201)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
