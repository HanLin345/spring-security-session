package com.chapter.time.springsecuritysession.service

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service

@Service
open class UsersService {

    @PreAuthorize("isAuthenticated()")
    open fun getUserDetails(): String {
        return "User is Han"
    }
}