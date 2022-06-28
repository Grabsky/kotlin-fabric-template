package just.testing.server

import net.fabricmc.api.DedicatedServerModInitializer

// Don't forget to replace default values:
//   - main class name (here)
//   - property 'rootProject.name' (settings.gradle.kts)
//   - property 'group' (build.gradle.kts)
//   - mod configuration (fabric.mod.json)
class ServerMain : DedicatedServerModInitializer {

    override fun onInitializeServer() {
        println("Hello Server!")
    }

}