import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent as HttpTextBodyContent

def randomSuffix = System.currentTimeMillis()

def uniqueName = 'Rasikha Diyah ' + randomSuffix

def postPayload = ('{"name": "' + uniqueName) + '"}'

// Ambil Test Object POST
RequestObject requestPost = findTestObject('POST - Create New User')

// Set payload JSON
requestPost.setBodyContent(new HttpTextBodyContent(postPayload, 'UTF-8', 'application/json'))

// Kirim POST request
def responsePost = WS.sendRequest(findTestObject('POST - Create New User'))

// Verifikasi status code POST
if (WS.getResponseStatusCode(responsePost) == 409) {
    println('User already exists, skipping creation.')
} else {
    WS.verifyResponseStatusCode(responsePost, 201)

    println('User successfully created: ' + uniqueName)
}
def userId = WS.getElementPropertyValue(responsePost, 'id')

def userName = WS.getElementPropertyValue(responsePost, 'name')

println('New userId: ' + userId)

println('New userName: ' + userName)

// 2️ READ - GET
RequestObject requestGet = findTestObject('GET - Single User')

requestGet.setRestUrl("$GlobalVariable.BASE_URL/users?id=eq." + userId)

def responseGet = WS.sendRequest(findTestObject('GET - Single User'))

WS.verifyResponseStatusCode(responseGet, 200)

def user = WS.getElementPropertyValue(responseGet, '[0]')

println("✅ GET user successful: ID=${user.id}, Name=${user.name}")

// 3️ UPDATE - PATCH
def newUserName = 'Rasikha Updated ' + randomSuffix
def patchPayload = '{"name": "' + newUserName + '"}'

RequestObject requestPatch = findTestObject('PATCH - Update User')
requestPatch.setBodyContent(new HttpTextBodyContent(patchPayload, 'UTF-8', 'application/json'))
requestPatch.setRestUrl("$GlobalVariable.BASE_URL/users?id=eq." + userId)

def responsePatch = WS.sendRequest(requestPatch) // pake requestPatch
WS.verifyResponseStatusCode(responsePatch, 204)
println('User updated successfully to: ' + newUserName)

println('User ID update :' + userId)

// 4️ READ AFTER UPDATE - GET
RequestObject requestGetAfterUpdate = findTestObject('GET - Single User')
requestGetAfterUpdate.setRestUrl("$GlobalVariable.BASE_URL/users?id=eq." + userId)

def responseGet2 = WS.sendRequest(requestGetAfterUpdate) // pake requestGetAfterUpdate
WS.verifyResponseStatusCode(responseGet2, 200)

// Karena response Supabase selalu array
WS.verifyElementPropertyValue(responseGet2, '[0].name', newUserName)
println('GET after update successful: ' + WS.getElementPropertyValue(responseGet2, '[0].name'))

// 5️ DELETE - DELETE
RequestObject requestDelete = findTestObject('DELETE - User')

requestDelete.setRestUrl("$GlobalVariable.BASE_URL/users?id=eq." + userId)

def responseDelete = WS.sendRequest(findTestObject('DELETE - User'))

WS.verifyResponseStatusCode(responseDelete, 204)

println('✅ User deleted successfully: ' + userId)

def responseGet3 = WS.sendRequest(findTestObject('GET - Single User'))

WS.verifyResponseStatusCode(responseGet3, 200 
    )

def userArraySize = WS.getElementPropertyValue(responseGet3, 'size()')

if (userArraySize == 0) {
    println('✅ Verified deletion: user no longer exists.')
} else {
    println('❌ User still exists!')
}

