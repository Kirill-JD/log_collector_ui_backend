pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

rootProject.name = "log_collector_ui_backend"

include(":modules:authentication")
include(":modules:registration")
include(":modules:receiver")
include(":modules:lk")
include(":modules:add-project")