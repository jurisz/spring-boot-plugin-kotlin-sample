package org.test.springboot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.ApplicationPidFileWriter
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext
import org.springframework.context.ApplicationContext
import org.springframework.context.ConfigurableApplicationContext

fun main(args: Array<String>) {
	BootApplication().run(args)
}

@SpringBootApplication(scanBasePackages = ["org.test.springboot"])
class BootApplication {

	private var additionalProfiles: Array<String> = emptyArray()

	private var applicationContext: ConfigurableApplicationContext? = null

	fun run(args: Array<String>) {
		val application = SpringApplication(SpringBootApplication::class.java, SpringBootApplicationConfiguration::class.java)
		if (additionalProfiles.isNotEmpty()) {
			application.setAdditionalProfiles(*additionalProfiles)
		}
		application.addListeners(ApplicationPidFileWriter())
		applicationContext = application.run(*args)
	}

	fun setAdditionalProfiles(additionalProfiles: Array<String>) {
		this.additionalProfiles = additionalProfiles
	}

	fun getHttpPort(): Int {
		return (applicationContext as ServletWebServerApplicationContext).webServer.port
	}

	fun getApplicationContext(): ApplicationContext? {
		return applicationContext
	}
}
