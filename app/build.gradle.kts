import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.kapt)
}

val properties = Properties().apply {
    project.rootProject.file("local.properties").inputStream().use {
        load(it)
    }
}

android {
    namespace = "com.example.englishguru"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.englishguru"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField(
            "String",
            "RAPID_API_KEY",
            "\"${properties.getProperty("RAPID_API_KEY")}\""
        )
    }

    signingConfigs {

        create("release") {
            storeFile = file("/Users/tisenres/StudioProjects/EnglishGuru/englishgurukey.keystore")
            storePassword = properties.getProperty("SIGN_APP_KEY")
            keyAlias = "englishguru-key-alias"
            keyPassword = properties.getProperty("SIGN_APP_KEY")
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            signingConfig = signingConfigs["release"]
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

        getByName("debug") {
            applicationIdSuffix = ".debug"
            isDebuggable = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.hilt)
    kapt(libs.hiltCompiler)
    kapt(libs.hiltCompilerAndroidX)
    implementation(libs.hiltNavigationCompose)

    implementation(libs.locationServices)

    implementation(libs.retrofit)
    implementation(libs.retrofitMoshi)
    implementation(libs.okhttpLoggingInterceptor)

    implementation(libs.lifecycleViewModelCompose)

    androidTestImplementation(libs.hiltAndroidTesting)
    kaptAndroidTest(libs.hiltCompiler)

    testImplementation(libs.hiltAndroidTesting)
    kaptTest(libs.hiltCompiler)
}

kapt {
    correctErrorTypes = true
    generateStubs = true
}