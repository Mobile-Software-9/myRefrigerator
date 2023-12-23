pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
//        maven {
//            url 'https://naver.jfrog.io/artifactory/maven/'
//        }
        maven("https://naver.jfrog.io/artifactory/maven/")

    }
}

rootProject.name = "refrigerator"
include(":app")
 