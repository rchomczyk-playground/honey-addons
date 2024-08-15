plugins {
    `honey-java`
    `honey-publish`
    `honey-repositories`
}

dependencies {
    api(libs.honey)
    api(libs.iridium)
}

honeyPublish {
    artifactId = "honey-addons-iridium"
}