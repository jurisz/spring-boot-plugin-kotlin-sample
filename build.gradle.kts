import libs


plugins {
	base
	id("java")
	kotlin("jvm") version "1.2.71" apply false
	id("org.jetbrains.kotlin.plugin.spring") version "1.2.71" apply false
	id("org.springframework.boot") version "2.0.5.RELEASE" apply false
}

allprojects {

	group = "org.test.springboot"

	repositories {
		jcenter()
	}

	apply {
		plugin("java")
		plugin("org.jetbrains.kotlin.jvm")
		plugin("org.jetbrains.kotlin.plugin.spring")
	}
}

dependencies {
	// Make the root project archives configuration depend on every subproject
	subprojects.forEach {
		archives(it)
	}
}
