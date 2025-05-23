import org.gradle.api.tasks.Exec

plugins {
    application
    java
}

application {
    mainClass.set("com.digitalasset.bindings.AllocatePartyV2Example")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

val grpcVersion = "1.67.1"
val protobufVersion = "3.21.12"

repositories {
    mavenCentral()
}

dependencies {
    implementation("javax.annotation:javax.annotation-api:1.3.2")
    implementation("io.grpc:grpc-netty-shaded:$grpcVersion")
    implementation("io.grpc:grpc-protobuf:$grpcVersion")
    implementation("io.grpc:grpc-stub:$grpcVersion")
    implementation("com.google.protobuf:protobuf-java:$protobufVersion")
    implementation("org.slf4j:slf4j-simple:2.0.12")
}

val bufGenerate by tasks.registering(Exec::class) {
    workingDir = rootDir.parentFile
    commandLine = listOf("buf", "generate")
    outputs.dir(file("build/generated/source/proto/buf/java"))
}

tasks.named("compileJava") {
    dependsOn(bufGenerate)
}

sourceSets["main"].java {
    srcDir("build/generated/source/proto/buf/java")
}

