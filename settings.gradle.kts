pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "LittleLemon"
include(":app")


//pluginManagement {
//    repositories {
//        google {
//            content {
//                includeGroupByRegex("com\\.android.*")
//                includeGroupByRegex("com\\.google.*")
//                includeGroupByRegex("androidx.*")
//            }
//        }
//        mavenCentral()
//        gradlePluginPortal()
//    }
//
//    // ADD THIS
//    includeBuild("gradle") // optional, only if you're using a convention plugin
//
//    // ADD THIS BLOCK
//    pluginManagement {
//        resolutionStrategy {
//            eachPlugin {
//                // You could add logic here if needed
//            }
//        }
//    }
//
//    // 👇 THIS IS IMPORTANT
//    plugins {
//        // nothing here unless needed
////        alias(libs.plugins.kotlin.kapt)
//    }
//}
//
//dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
//    repositories {
//        google()
//        mavenCentral()
//    }
//
//    // 👇 Add this block
//    versionCatalogs {
//        create("libs") {
//            from(files("gradle/libs.versions.toml"))
//        }
//    }
//}
//
//rootProject.name = "LittleLemon"
//include(":app")
