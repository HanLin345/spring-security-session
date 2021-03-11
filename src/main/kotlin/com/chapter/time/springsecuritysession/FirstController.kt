package com.chapter.time.springsecuritysession

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FirstController {

    @GetMapping("/public")
    fun publicController() : String {
        return "public controller";
    }

    @GetMapping("/users")
    fun userController() : String {
        return "user controller";
    }

    @GetMapping("/admin")
    fun adminController() : String {
        return "admin controller";
    }
}
