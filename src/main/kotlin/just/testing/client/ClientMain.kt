package just.testing.client

import net.fabricmc.api.ClientModInitializer

// Don't forget to replace default values:
//   - main class name (here)
//   - property 'rootProject.name' (settings.gradle.kts)
//   - property 'group' (build.gradle.kts)
//   - mod configuration (fabric.mod.json)
class ClientMain : ClientModInitializer {

    override fun onInitializeClient() {
        println("Hello Client!")
    }

}