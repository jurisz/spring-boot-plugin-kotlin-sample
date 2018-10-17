package org.acceptance.atsk

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class AcceptanceRestTemplate {

	@Autowired
	@Qualifier("acceptanceRestClient")
	private val restTemplate: RestTemplate? = null

	@Autowired
	private val bootConfigurer: AcceptanceTestSpringBootConfigurer? = null

	fun restTemplate(): RestTemplate? {
		return restTemplate
	}

	fun baseUrl(): String {
		return bootConfigurer!!.apiUrl
	}
}
