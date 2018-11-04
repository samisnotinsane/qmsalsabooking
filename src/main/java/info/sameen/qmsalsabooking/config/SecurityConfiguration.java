package info.sameen.qmsalsabooking.config;

import info.sameen.qmsalsabooking.logger.LoggingAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Configuration for Spring Security.
 * @author sameenislam
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /* Hint:
     * For more on Spring Security authentication, consult the following
     * tutorial: https://memorynotfound.com/spring-boot-spring-security-thymeleaf-form-login-example/
     */

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder authBuilder) throws Exception {
//        authBuilder.inMemoryAuthentication()
//            .withUser("devuser")
//            .password("{noop}dev").authorities("ROLE_USER")
//            .and()
//            .withUser("adminuser")
//            .password("{noop}admin").authorities("ROLE_USER", "ROLE_ADMIN");
//    }

    @Autowired
    private LoggingAccessDeniedHandler accessDeniedHandler;

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        final User.UserBuilder userBuilder = User.builder().passwordEncoder(encoder::encode);

        UserDetails user =
                userBuilder
                    .username("user")
                    .password("user")
                    .roles("USER")
                    .build();

        UserDetails admin =
                userBuilder
                    .username("admin")
                    .password("password")
                    .roles("USER", "ADMIN")
                    .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/javax.faces.resource/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers(
                            "/",
                                        "/js/**",
                                        "/css/**",
                                        "/img/**",
                                        "/signup*",
                                        "/testpage*"
                    ).permitAll()
                    .antMatchers("/swagger-ui.html*").hasRole("ADMIN")
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/signin")
                    .permitAll()
                    .and()
                .logout()
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/signin?logout")
                    .permitAll()
                .and()
                .exceptionHandling()
                    .accessDeniedHandler(accessDeniedHandler);

//                .antMatchers("/attendees*").hasRole("ADMIN")
//                .antMatchers("/lessons*").hasRole("USER")
//                .antMatchers("/", "signin*").permitAll()
//                .antMatchers("/", "signup*").permitAll()
    }
}
