import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper as JsonSlurper

def randomNumber = new Random().nextInt(10000)
def uniqueUsername = "bernard" + randomNumber

def response = WS.sendRequest(findTestObject('POST - Create New User', [
    ('first_name') : 'bernard',
    ('last_name') : 'jupiter',
    ('username') : uniqueUsername,
    ('job_position') : 'QA Engineer',
    ('job_level') : 'Mid',
    ('salary') : 0,
    ('work_duration') : 2
]))

WS.verifyResponseStatusCode(response, 201)

// Parse respons JSON
def jsonResponse = new JsonSlurper().parseText(response.getResponseText())

// Ambil ID user yang baru dibuat
def newUserId = jsonResponse[0].id

GlobalVariable.createdUserId = newUserId

println('User baru berhasil dibuat dengan ID: ' + newUserId)

// Verifikasi isi data
assert jsonResponse[0].username.startsWith('bernard')
assert jsonResponse[0].job_position == 'QA Engineer'

