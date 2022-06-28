val buildsDirectory = (System.getenv("DEVELOPMENT_DIR") ?: ".") + File.separator + "builds"

group = "just.testing"
version = "1.0-SNAPSHOT"

plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm") version "1.7.0"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("fabric-loom") version "0.11-SNAPSHOT"
}

base {
    archivesName.set(rootProject.name)
}

repositories {
    mavenCentral()
    // ...
}

dependencies {
    compileOnly("org.jetbrains.kotlin", "kotlin-stdlib-jdk8", "1.7.0")
    // Minecraft & Mappings
    minecraft("com.mojang", "minecraft", "1.19")
    mappings("net.fabricmc", "yarn", "1.19+build.1", null, "v2")
    // Fabric Stuff
    modImplementation("net.fabricmc", "fabric-loader", "0.14.6")
    modImplementation("net.fabricmc.fabric-api", "fabric-api", "0.56.3+1.19")
    modImplementation("net.fabricmc", "fabric-language-kotlin", "1.8.1+kotlin.1.7.0")
    // ...
}

tasks {
    assemble {
        dependsOn(jar)
        doLast {
            // Copying output file to builds directory
            copy {
                from(jar)
                into(buildsDirectory)
                // Renaming output file
                rename(jar.get().archiveFileName.get(), "${rootProject.name}_${version}.jar")
            }
        }
    }
    processResources { filteringCharset = Charsets.UTF_8.name() }
}
