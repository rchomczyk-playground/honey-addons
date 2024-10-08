plugins {
    `honey-java`
    `honey-publish`
    `honey-repositories`
}

dependencies {
    api(libs.lang)
    api(libs.opel)
    api(libs.parboiled)
    compileOnly(libs.honey)
}

honeyPublish {
    artifactId = "honey-addons-opel"
}