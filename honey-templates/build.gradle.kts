plugins {
    `honey-java`
    `honey-publish`
    `honey-repositories`
}

dependencies {
    api(libs.expressible)
    compileOnly(libs.honey)
    compileOnly(libs.bundles.adventure)
}

honeyPublish {
    artifactId = "honey-addons-templates"
}