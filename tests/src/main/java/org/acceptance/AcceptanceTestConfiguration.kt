package org.acceptance.atsk


import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import org.springframework.web.client.RestTemplate

@Configuration
@ComponentScan(basePackages = ["org.acceptance"])
class AcceptanceTestConfiguration {

	@Bean
	@Throws(Exception::class)
	fun acceptanceRestClient(): RestTemplate {
		return RestTemplate()
	}

	companion object {
		@Bean
		fun propsConfiguration(): PropertySourcesPlaceholderConfigurer {
			return PropertySourcesPlaceholderConfigurer()
		}
	}
}