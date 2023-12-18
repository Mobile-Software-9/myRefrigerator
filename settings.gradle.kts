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
        maven ("https://naver.jfrog.io/artifactory/maven/")
        //maven {
        //            url 'https://naver.jfrog.io/artifactory/maven/'
        //        }
    }
}

rootProject.name = "Thx_Fridge"
include(":app")
include(":thx_fridge")
