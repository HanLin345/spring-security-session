package com.chapter.time.springsecuritysession

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.security.core.context.SecurityContextHolder

import java.security.Principal

@Service
class MyService {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    fun getAdminHi(): String {
        return "hi admin";
    }

    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    fun getHi(): String {
        val principal: Principal = SecurityContextHolder.getContext().authentication
        return "hi ${principal.name}";
    }

    @PreAuthorize("isAuthenticated()")
    open fun getUserDetails(): String {
        return "User is Han"
    }

    fun checkMe() :Boolean  {
        val principal: Principal = SecurityContextHolder.getContext().authentication
        return principal.name.length > 3
    }

}