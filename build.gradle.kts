plugins {
    id("java")
    application
}

application {
    mainClass.set("org.example.Main")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.glassfish.jaxb:jaxb-runtime:4.0.3")
    implementation("jakarta.xml.bind:jakarta.xml.bind-api:4.0.0")
}

tasks.test {
    useJUnitPlatform()
}

//tasks {
//    register<XjcTask>("generateJaxbClasses") {
//        sourceDir = file("src/main/resources")
//        targetDir = file("src/generated/java")
//    }
//}