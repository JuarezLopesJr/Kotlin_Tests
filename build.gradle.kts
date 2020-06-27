plugins {
    kotlin("jvm") version "1.3.72"
    application
    jacoco
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform {}
    testLogging.showStandardStreams = true
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7")
    implementation(kotlin("reflect:1.3.41"))
    implementation("com.beust:klaxon:5.0.2")

    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.3.1")
    testImplementation("io.mockk:mockk:1.9")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }




//    getByName<JacocoReport>("jacocoTestReport") {
//        afterEvaluate {
//            setClassDirectories(files(classDirectories.files.map {
//                fileTree(it) { exclude("**/ui/**") }
//            }))
//        }
//    }


    jacoco {
        toolVersion = "0.8.5"
        reportsDir = file("$buildDir/customJacocoReportDir")
    }



    defaultTasks("clean", "test", "jacocoTestReport")
}