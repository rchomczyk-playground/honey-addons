plugins {
    `honey-java`
    `honey-publish`
    `honey-repositories`
}

dependencies {
    compileOnly(libs.honey)
    api(libs.iridium)
}

honeyPublish {
    artifactId = "honey-addons-iridium"
}