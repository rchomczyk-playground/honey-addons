plugins {
    `honey-java`
    `honey-publish`
    `honey-repositories`
}

dependencies {
    compileOnly(libs.honey)
    api(libs.lang)
    api(libs.opel)
    api(libs.parboiled)
}

honeyPublish {
    artifactId = "honey-addons-opel"
}