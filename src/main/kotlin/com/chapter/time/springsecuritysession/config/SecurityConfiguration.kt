package com.chapter.time.springsecuritysession.config

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
open class SecurityConfiguration : WebSecurityConfigurerAdapter() {

    companion object {
        private val logger = LoggerFactory.getLogger(this::class.java.enclosingClass)
        const val ADMIN_USER = "admin"
        const val ADMIN_PASSWORD = "admin"
        const val ADMIN_ROLE = "ADMIN"

        const val SUPERUSER_USER = "superuser"
        const val SUPERUSER_PASSWORD = "superuser"
        const val SUPERUSER_ROLE = "SUPERUSER"
    }

    @Throws(java.lang.Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        val passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
        auth.inMemoryAuthentication()
                .withUser(ADMIN_USER).password(passwordEncoder.encode(ADMIN_PASSWORD)).roles(ADMIN_ROLE).and()
                .withUser(SUPERUSER_USER).password(passwordEncoder.encode(SUPERUSER_PASSWORD)).roles(ADMIN_ROLE, SUPERUSER_ROLE)
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
                .authorizeRequests() //
                // Matches /home, /home/, /home.html, /home.xxx
                .mvcMatchers("/home").permitAll()
                .mvcMatchers("/secret*").hasRole(SUPERUSER_ROLE)
                .mvcMatchers("/**").hasRole(ADMIN_ROLE) //
                .anyRequest().authenticated()


    }
}