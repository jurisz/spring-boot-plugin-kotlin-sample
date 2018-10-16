import com.sun.javafx.scene.CameraHelper.project
import libs
import org.gradle.internal.impldep.org.junit.experimental.categories.Categories.CategoryFilter.exclude

apply {
	plugin("org.springframework.boot")
}

dependencies {
	compile(libs.kotlin_stdlib)
	compile(libs.kotlin_reflect)

	compile(libs.spring_boot_web)
}
