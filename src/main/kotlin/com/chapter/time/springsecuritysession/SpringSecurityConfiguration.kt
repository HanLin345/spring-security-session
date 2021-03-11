package com.chapter.time.springsecuritysession

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import javax.sql.DataSource

@EnableWebSecurity
class SpringSecurityConfiguration : WebSecurityConfigurerAdapter() {

    @Autowired
    lateinit var dataSource: DataSource

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .withDefaultSchema()
            .withUser("deniz")
            .password("admin")
            .roles("ADMIN")
            .and()
            .withUser("nikita")
            .password("123")
            .roles("USER")
    }

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .mvcMatchers("/admin").hasRole("ADMIN")
            .and()
            .authorizeRequests()
            .mvcMatchers("/users").hasAnyRole("USER","ADMIN")
            .and().authorizeRequests()
            .mvcMatchers("/public").permitAll()
            .and().formLogin()
    }

    @Bean
    fun passwordEncoder() = NoOpPasswordEncoder.getInstance();
}