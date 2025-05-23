package dev.rmarcos

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.http.ContentType // or * as in the documentation

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/test") {
            val text = "{\"Error\": \"This is working!\"}"
            val type = ContentType.parse("application/json")
            call.respondText(text, type)
        }
    }
}
