import org.ajoberstar.reckon.gradle.ReckonExtension

pluginManagement {
    includeBuild("build-logic")
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
        maven("https://jitpack.io")
        maven("https://plugins.gradle.org/m2/")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version("0.8.0")
    id("org.ajoberstar.reckon.settings") version("0.19.1")
}

extensions.configure<ReckonExtension> {
    setDefaultInferredScope("patch")
    stages("beta", "rc", "final")
    setScopeCalc(calcScopeFromProp().or(calcScopeFromCommitMessages()))
    setStageCalc(calcStageFromProp())
}

rootProject.name = "mifos-mobile"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":androidApp")

// Core Modules
include(":core:ui")
include(":core:designsystem")
include(":core:logs")
include(":core:model")
include(":core:common")
include(":core:data")
include(":core:network")
include(":core:database")
include(":core:datastore")
include(":core:qrcode")
include(":core:testing")

// Feature Modules
include(":feature:loan")
include(":feature:beneficiary")
include(":feature:savings")
include(":feature:guarantor")
include(":feature:qr")
include(":feature:transfer-process")
include(":feature:account")
include(":feature:recent-transaction")
include(":feature:client-charge")
include(":feature:third-party-transfer")
include(":feature:help")
include(":feature:notification")
include(":feature:location")
include(":feature:about")
include(":feature:settings")
include(":feature:auth")
include(":feature:update-password")
include(":feature:home")
include(":feature:user-profile")

// Lint Modules
//include(":lint")

// Library Modules
include(":libs:country-code-picker")
include(":libs:pullrefresh")
include(":libs:material3-navigation")
include(":libs:mifos-passcode")

// Kotlin Multiplatform Modules
include(":shared")