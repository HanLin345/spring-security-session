package com.chapter.time.springsecuritysession

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class FirstController {

    @GetMapping("/first")
    fun getFirst() : String {
        return "first";
    }
}