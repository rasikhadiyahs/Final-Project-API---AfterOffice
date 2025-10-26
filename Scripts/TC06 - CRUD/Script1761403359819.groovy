import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent as HttpTextBodyContent

CustomKeywords.'randomData.SetRandomUser.setRandomUserData'()

println('Random ID yang digunakan: ' + GlobalVariable.randomId)

//CREATE USER
def createResponse = WS.sendRequest(findTestObject('POST - Create New User'))

def userId = WS.getElementPropertyValue(createResponse, 'id')

println(createResponse.getResponseBodyContent())

//READ USER
def readResponse = WS.sendRequestAndVerify(findTestObject('GET - Single User', [(userId) : GlobalVariable.randomId]))

WS.verifyElementPropertyValue(readResponse, 'first_name', '[rasikha]')

println(readResponse.getResponseBodyContent())

//UPDATE USER (PATCH)
def updateResponse = WS.sendRequest(findTestObject('PATCH - Update User', [(userId) : GlobalVariable.randomId]))

println(updateResponse.getResponseBodyContent())

//READ AFTER UPDATE
def verifyUpdate = WS.sendRequestAndVerify(findTestObject('GET - Single User', [(userId) : GlobalVariable.randomId]))

WS.verifyElementPropertyValue(verifyUpdate, 'job_level', '[Lead]')

println(verifyUpdate.getResponseBodyContent())

//DELETE USER
def deleteResponse = WS.sendRequest(findTestObject('DELETE - User', [(userId) : GlobalVariable.randomId]))

println(deleteResponse.getResponseBodyContent())

//VERIFY USER DELETED
def verifyDelete = WS.sendRequest(findTestObject('GET - Single User', [(userId) : GlobalVariable.randomId]))

WS.verifyResponseStatusCode(verifyDelete, 200)

def users = WS.getElementPropertyValue(verifyDelete, 'id')
println(checkDeleted.getResponseBodyContent())
