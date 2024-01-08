plugins {
    java
    `maven-publish`
    id("com.github.johnrengelman.shadow") version("8.1.1")
}

group = "me.dave"
version = "1.1.0"

repositories {
    mavenCentral()
    mavenLocal()
    maven { url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") }
    maven { url = uri("https://repo.william278.net/snapshots") } // HuskClaims
    maven { url = uri("https://jitpack.io") } // GardeningTweaks, GriefPrevention
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.20.2-R0.1-SNAPSHOT")
    compileOnly("com.github.CoolDCB:GardeningTweaks:1.3")
    compileOnly("net.william278.huskclaims:huskclaims-bukkit:1.0-8818300")
    compileOnly("com.github.TechFortress:GriefPrevention:16.18")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    shadowJar {
        val folder = System.getenv("pluginFolder_1-20")
        if (folder != null) destinationDirectory.set(file(folder))
        archiveFileName.set("${project.name}-${project.version}.jar")
    }

    processResources{
        expand(project.properties)

        inputs.property("version", rootProject.version)
        filesMatching("plugin.yml") {
            expand("version" to rootProject.version)
        }
    }
}