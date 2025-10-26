package randomData

import com.kms.katalon.core.annotation.Keyword
import internal.GlobalVariable

class SetRandomUser {
	@Keyword
	def static setRandomUserData() {
		def randomId = System.currentTimeMillis()  // UNIK tiap milidetik
		def username = "User" + randomId

		// Simpan ke GlobalVariable
		GlobalVariable.randomId = randomId
		GlobalVariable.randomUsername = username

		println("✅ Keyword dijalankan — Random ID: " + randomId)
		println("✅ Keyword dijalankan — Random Username: " + username)
	}
}
