plugins {
    `honey-java`
    `honey-publish`
    `honey-repositories`
}

dependencies {
    compileOnly(libs.honey)
    compileOnly(libs.annotations)
}

honeyPublish {
    artifactId = "honey-addons-i18n"
}