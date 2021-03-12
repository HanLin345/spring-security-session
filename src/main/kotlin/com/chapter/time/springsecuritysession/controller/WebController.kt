package com.chapter.time.springsecuritysession.controller

import com.chapter.time.springsecuritysession.service.UsersService
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
open class WebController(private val userDetailsService: UsersService) {

    @GetMapping("/home")
    open fun home(): String {
        return userDetailsService.getUserDetails()
    }

    @GetMapping("/secret")
    @PreAuthorize("isAuthenticated()")
    open fun secret(): String{
        return "This is the secret!"
    }
}