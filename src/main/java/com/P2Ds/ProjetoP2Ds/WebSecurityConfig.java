package com.P2Ds.ProjetoP2Ds;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    public WebSecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    .authorizeRequests()
                    .antMatchers("/", "/cadastro","/detalheProd","/contato","/sobre").permitAll()  // -> permitida a todos
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout()
                    .deleteCookies("JSESSIONID")
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true)
                .and()
                    .rememberMe().key("x*gEAEjvq7roOb$NmN1EVd!k8bp%VF")
        ;
    }


    @Override
    public void configure(WebSecurity web) throws Exception {  // -> pastas liberadas
        web
                .ignoring()
                .antMatchers("/css/**")
                .antMatchers("/img/**")
                .antMatchers("/js/**");
    }


   // Autenticação =============================================================================================================

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                // ==================================================================================================== -> Autenticação Cliente
                .dataSource(dataSource)
                    .passwordEncoder(passwordEncoder())
                    .usersByUsernameQuery("select ds_Email,cd_Senha, enabled from cliente where ds_Email=?")
                    .authoritiesByUsernameQuery("select ds_Email, authority from cliente where ds_Email=?")
                .and()
                //===================================================================================================== -> Autenticação Funcionário
                    .jdbcAuthentication()
                    .dataSource(dataSource)
                    .passwordEncoder(passwordEncoder())
                    .usersByUsernameQuery("select ds_Email,cd_Senha, enabled from funcionario where ds_Email=?")
                    .authoritiesByUsernameQuery("select ds_Email, authority from funcionario where ds_Email=?")
                .and()
                //====================================================================================================== -> Autenticação Usuário Master
                    .inMemoryAuthentication()
                    .passwordEncoder(passwordEncoder())
                    .withUser("master@acme")     // -> Usuário Master
                    .password("$2a$10$1sbpaSZCSTrLjvKL91GlBuP/ytKu5ult5PwPpO8ye02nEZF4pBJt2")  // -> senha master de acesso criptografada
                    .authorities("USER");
    }




    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



}
