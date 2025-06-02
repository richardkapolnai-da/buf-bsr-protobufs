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


dependencies {
    implementation("javax.annotation:javax.annotation-api:1.3.2")
    implementation("io.grpc:grpc-netty-shaded:$grpcVersion")
    implementation("io.grpc:grpc-protobuf:$grpcVersion")
    implementation("io.grpc:grpc-stub:$grpcVersion")
    implementation("com.google.protobuf:protobuf-java:$protobufVersion")
    implementation("org.slf4j:slf4j-simple:2.0.12")

    implementation("build.buf.gen:richardkapolnai-da_protobufs_grpc_java:1.67.1.1.00000000000000.78d251c9a32d")
    implementation("build.buf.gen:richardkapolnai-da_protobufs_protocolbuffers_java:21.12.0.1.00000000000000.78d251c9a32d")
    // curl -fsSL -O https://buf.build/gen/archive/richardkapolnai-da/protobufs/protocolbuffers/java/v21.12-78d251c9a32d.1.zip
}

repositories {
    mavenCentral()
    maven {
      name = "buf"
      url = uri("https://buf.build/gen/maven")
    }
}
