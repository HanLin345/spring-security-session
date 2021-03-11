package com.chapter.time.springsecuritysession

import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.stereotype.Component

@Component("myProvider")
class MyCustomAuthenticationProvider : AuthenticationProvider {

    override fun authenticate(authentication: Authentication): Authentication? {
        var principal : String = authentication.principal as String
        if(principal.endsWith("ing.com")) {
            return UsernamePasswordAuthenticationToken(
                principal,
                "",
                listOf(SimpleGrantedAuthority("ROLE_USER"))
            )
        }
        return null;
    }

    override fun supports(authentication: Class<*>): Boolean =
        (authentication.equals(UsernamePasswordAuthenticationToken::class.java))
}