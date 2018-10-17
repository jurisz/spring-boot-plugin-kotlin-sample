package org.acceptance.atsk

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component
import org.test.springboot.BootApplication
import org.test.springboot.Profiles
import javax.annotation.PostConstruct

@Component
class AcceptanceTestSpringBootConfigurer {

	@Value("\${$API_URL_PROPERTY_NAME:}")
	private val remoteWsUrl: String? = null

	val apiUrl: String
		get() {
			val remoteWsUrl = remoteWsUrl
			return if (remoteWsUrl.isNullOrEmpty()) localServerUrl else remoteWsUrl!!
		}

	private val localServerUrl: String
		get() = "http://localhost:" + springBootApp!!.getHttpPort()

	val localSpringContext: ApplicationContext?
		get() = springBootApp!!.getApplicationContext()

	@PostConstruct
	@Synchronized
	@Throws(Throwable::class)
	fun init() {
		if (springBootApp == null && enabledLocalSpringBoot()) {
			startLocalSpringBootApp()
		}
	}

	private fun startLocalSpringBootApp() {
		System.setProperty("server.port", "0")
		springBootApp = BootApplication()
		springBootApp!!.setAdditionalProfiles(arrayOf(Profiles.Test))
		springBootApp!!.run(arrayOf())
	}

	fun enabledLocalSpringBoot(): Boolean {
		return remoteWsUrl.isNullOrEmpty()
	}

	companion object {
		private const val API_URL_PROPERTY_NAME = "app.api.url"
		private var springBootApp: BootApplication? = null
	}
}
