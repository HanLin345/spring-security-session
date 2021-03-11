package com.chapter.time.springsecuritysession.controller

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
open class WebController {

    @GetMapping("/home")
    open fun home(): String{
        return "Welcome home!"
    }

    @GetMapping("/secret")
    //@PreAuthorize("isAuthenticated()")
    open fun secret(): String{
        return "This is the secret!"
    }
}