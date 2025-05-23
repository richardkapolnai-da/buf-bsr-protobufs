import org.gradle.api.tasks.Exec

plugins {
    application
    java
}

dependencies {
    implementation("build.buf.gen:richardkapolnai-da_protobufs_grpc_java:1.67.1.1.00000000000000.78d251c9a32d")
    // curl -fsSL -O https://buf.build/gen/archive/richardkapolnai-da/protobufs/protocolbuffers/java/v21.12-78d251c9a32d.1.zip
    // need 21.12... implementation("build.buf.gen:richardkapolnai-da_protobufs_protocolbuffers_java:21.12.0.1.00000000000000.78d251c9a32d")
}

repositories {
    mavenCentral()
    maven {
      name = "buf"
      url = uri("https://buf.build/gen/maven")
    }
}
