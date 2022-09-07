plugins {
    `java-library`
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.apiguardian:apiguardian-api:1.1.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.1")
    testImplementation("org.hamcrest:hamcrest:2.2")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.1")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

val compileConfigurations = setOf(
    "api", "apiElements",
    "compileClasspath", "compileOnly", "compileOnlyApi",
    "implementation",
    "testApi", "testApiElements",
    "testCompileClasspath", "testCompileOnly", "testCompileOnlyApi",
    "testImplementation"
)
configurations.matching { compileConfigurations.contains(it.name) }.configureEach {
    isTransitive = false
}
