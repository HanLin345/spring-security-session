package com.chapter.time.springsecuritysession

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
class FirstController {
    @Autowired
    lateinit var myService: MyService

    @GetMapping("/public")
    fun publicController() : String {
        return "public controller";
    }

    @GetMapping("/users")
    fun userController(principal: Principal) : String {
        myService.getHi()
        return "user controller ${principal.name}";
    }

    @GetMapping("/admin")
    fun adminController() : String {
        myService.getAdminHi()
        return "admin controller";
    }

    @GetMapping("/secret")
    @PreAuthorize("isAuthenticated()")
    open fun secret(): String{
        return "This is the secret!"
    }

    @GetMapping("/checkme")
    @PreAuthorize("@myService.checkMe()")
    open fun check(): String{
        return "This is the checkme!"
    }

}
