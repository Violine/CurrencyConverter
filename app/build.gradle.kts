import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
    kotlin("android")
}

android {
    buildToolsVersion("30.0.3")
    compileSdkVersion(30)

    defaultConfig {
        applicationId = "com.korovin.currencyconverter"
        minSdkVersion(21)
        targetSdkVersion(30)
        compileSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }

    buildFeatures {
        compose = true
        viewBinding = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = COMPOSE_VERSION
    }
}

dependencies {

    implementation("androidx.core:core-ktx:$CORE_KTX_VERSION")
    implementation("androidx.appcompat:appcompat:$APP_COMPAT_VERSION")
    implementation("com.google.android.material:material:$MATERIAL_VERSION")

    //compose
    implementation("androidx.compose.ui:ui:$COMPOSE_VERSION")
    implementation("androidx.compose.material:material:$COMPOSE_VERSION")
    implementation("androidx.compose.ui:ui-tooling:$COMPOSE_VERSION")

    //lifexycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$LIFECYCLE_RUNTIME_VERSION")
    implementation("androidx.activity:activity-compose:$ACTIVITY_COMPOSE_VERSION")

    //hilt
    implementation ("com.google.dagger:hilt-android:$HILT_VERSION")
    kapt("com.google.dagger:hilt-compiler:$HILT_VERSION")

    //retrofit2 + Moshi
    implementation("com.squareup.retrofit2:retrofit:$RETROFIT_VERSION")
    implementation("com.squareup.retrofit2:converter-moshi:$MOSHI_CONVERTER_VERSION")

    testImplementation("junit:junit:$JUNIT_VERSION")
    androidTestImplementation("androidx.test.ext:junit:$JUNIT_EXT_VERSION")
    androidTestImplementation("androidx.test.espresso:espresso-core:$ESPRESSO_CORE_VERSION")
}