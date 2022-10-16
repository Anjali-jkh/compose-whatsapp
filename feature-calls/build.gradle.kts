plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
  id("org.jetbrains.kotlin.plugin.serialization")
  id("kotlin-kapt")
  id("dagger.hilt.android.plugin")
}

android {
  compileSdk = Configurations.compileSdk

  defaultConfig {
    minSdk = Configurations.minSdk
    targetSdk = Configurations.targetSdk
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  buildFeatures {
    compose = true
  }

  composeOptions {
    kotlinCompilerExtensionVersion = Versions.COMPOSE_COMPILER
  }

  lint {
    abortOnError = false
  }
}

dependencies {
  // core modules
  implementation(project(":core-designsystem"))
  implementation(project(":core-navigation"))
  implementation(project(":core-uistate"))
  implementation(project(":core-data"))

  implementation(Dependencies.composeLifecycle)
  implementation(Dependencies.timber)

  api(Dependencies.hiltAndroid)
  kapt(Dependencies.hiltCompiler)
}
