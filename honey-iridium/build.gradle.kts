plugins {
    `honey-java`
    `honey-publish`
    `honey-repositories`
}

dependencies {
    api(libs.bundles.iridium)
    compileOnly(libs.honey)
    compileOnly(libs.bundles.adventure)
}

honeyPublish {
    artifactId = "honey-addons-iridium"
}