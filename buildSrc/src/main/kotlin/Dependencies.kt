object Dependencies {
    object Kotlin {
        val version = "1.3.70"
        val classpath = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
    }

    object Spigot {
        val version = "1.15.2-R0.1-SNAPSHOT"
        val api = "org.spigotmc:spigot-api:$version"
        val repository = "https://hub.spigotmc.org/nexus/content/repositories/snapshots/"
    }

    object SonaType {
        val repository = "https://oss.sonatype.org/content/groups/public/"
    }

    object Rx {
        val java = "io.reactivex.rxjava2:rxjava:2.2.17"
    }
}