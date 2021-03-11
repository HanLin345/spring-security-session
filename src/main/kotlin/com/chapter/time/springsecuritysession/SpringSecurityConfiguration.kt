package com.chapter.time.springsecuritysession

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.NoOpPasswordEncoder

@EnableWebSecurity
class SpringSecurityConfiguration: WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
            .withUser("deniz")
            .password("admin")
            .roles("ADMIN");
    }

    @Bean
    fun passwordEncoder() = NoOpPasswordEncoder.getInstance();
}