plugins {
	java
	id("org.springframework.boot") version "3.3.3"
	id("io.spring.dependency-management") version "1.1.6"
	id("jacoco")
}

group = "com.usuario.pragma.emason"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

jacoco {
	toolVersion = "0.8.12"
	reportsDirectory = layout.buildDirectory.dir("customJacocoReportDir")
}

tasks.jacocoTestReport {
	reports {
		xml.required.set(false)
		csv.required.set(false)
		html.outputLocation.set(layout.buildDirectory.dir("jacocoHtml"))
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation ("org.springframework.boot:spring-boot-starter-validation")
	implementation ("org.mapstruct:mapstruct:1.5.3.Final")

	compileOnly("org.projectlombok:lombok")
	runtimeOnly("com.mysql:mysql-connector-j")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	testImplementation ("org.mockito:mockito-core")

	annotationProcessor ("org.mapstruct:mapstruct-processor:1.5.3.Final")

	implementation("org.mindrot:jbcrypt:0.4")
	implementation ("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")
	testImplementation("org.mockito:mockito-core:4.6.1")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")

	//implementation ("org.springframework.boot:spring-boot-starter-security")
	implementation ("org.springframework.security:spring-security-core")

	implementation("org.springframework.boot:spring-boot-starter-security")

}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.test {
	finalizedBy(tasks.jacocoTestReport) // always generate Jacoco report after tests run
}

