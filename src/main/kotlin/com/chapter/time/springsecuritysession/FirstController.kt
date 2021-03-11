package com.chapter.time.springsecuritysession

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FirstController {

    @GetMapping("/first")
    fun getFirst() : String {
        return "first controller";
    }
}
