plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "me.kingtux"
version = "1.0-SNAPSHOT"
val artifactName = "ResourceWorldsEssentials"

java {
    targetCompatibility = org.gradle.api.JavaVersion.VERSION_1_8
    sourceCompatibility = org.gradle.api.JavaVersion.VERSION_1_8

}
repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/groups/public/")
    maven("https://repo.potatocorp.dev/storages/maven/kingtux-repo")
    maven("https://repo.codemc.org/repository/maven-public")
    maven("https://repo.essentialsx.net/snapshots")


}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.16.4-R0.1-SNAPSHOT")
    compileOnly("net.essentialsx:EssentialsX:2.19.0-SNAPSHOT")
    implementation(group = "me.kingtux", name = "ResourceWorlds", version = "1.0-SNAPSHOT")
    implementation("org.bstats:bstats-bukkit:1.8")
}
tasks {
    "shadowJar"(com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar::class) {
        dependencies {
            relocate("org.bstats.bukkit", "me.kingtux.resourceworldessentials.bstats")
        }
    }
}

tasks.processResources {
    expand("version" to project.version)
}