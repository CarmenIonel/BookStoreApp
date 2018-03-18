package Application;

import Application.Model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

/**
 * Created by Ionel Carmen on 4/11/2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityLog extends WebSecurityConfigurerAdapter
{

    @Autowired
    private UserService userData;

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.cors().disable();
        httpSecurity.authorizeRequests().antMatchers("/", "/resources/**","/templates/**", "/static/**",
                "/css/**").permitAll()
                .antMatchers("/adminMeniu", "/createBook","/createEmployee","/viewBook","/viewEmployee", "/updateEmployee",
                        "/updateBook", "/deleteBook","/deleteEmployee","/getReport").hasRole("ADMIN")
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().defaultSuccessUrl("/pass")
                .loginPage("/login").usernameParameter("user").passwordParameter("pass").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").permitAll()
                .and().exceptionHandling().accessDeniedPage("/error");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws  Exception
    {
        auth.userDetailsService(this.userData);
    }
}