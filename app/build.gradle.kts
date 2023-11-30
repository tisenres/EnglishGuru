
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("io.realm.kotlin")
    id("org.jetbrains.kotlin.kapt")
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
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
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
    }
}

dependencies {

    val lifecycleVersion = "2.6.2"
    val koinAndroidVersion = "3.1.2"

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.5")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.3.0")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")

    // Koin
    implementation("io.insert-koin:koin-android:$koinAndroidVersion")
    implementation("io.insert-koin:koin-core:$koinAndroidVersion")
    implementation("io.insert-koin:koin-test:$koinAndroidVersion")

    // Material Design
    implementation("com.google.android.material:material:1.10.0")

    // RxJava
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxjava:2.2.6")

    // ViewPager
    implementation("androidx.viewpager2:viewpager2:1.0.0")

    // Realm
    implementation("io.realm.kotlin:library-base:1.11.0")
    implementation("io.realm.kotlin:library-sync:1.11.0")
    kapt("io.realm:realm-annotations-processor:10.10.0")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.0")

    // CardView
    implementation("androidx.cardview:cardview:1.0.0")

    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

    implementation("ai.api:sdk:2.0.7@aar")
    implementation("ai.api:libai:1.6.12")
    implementation("com.google.code.gson:gson:2.8.9")

}