import com.sun.javafx.scene.CameraHelper.project
import libs
import org.gradle.internal.impldep.org.junit.experimental.categories.Categories.CategoryFilter.exclude
import org.springframework.boot.gradle.dsl.SpringBootExtension


apply {
	plugin("org.springframework.boot")
}

configure<SpringBootExtension> {
	mainClassName = "org.test.springboot.BootApplication"
}

dependencies {
	compile(project(":application"))
}
