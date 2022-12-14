package oit.is.z0264.kaizi.janken.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class JankenAuthConfiguration {

  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    UserBuilder users = User.builder();
    UserDetails user1 = users
        .username("user1")
        .password("$2y$10$gSsbrCoNFh6SCAKF3TCQou.DuKLE6xmScNAu1ArPq2heK3vBm77W.")
        .roles("USER")
        .build();
    UserDetails user2 = users
        .username("user2")
        .password("$2y$10$x9mCH25j.fEoMSzQbHuqCOicLhPl4FWL8F2ElpgRYB9zJFqW3RjOi")
        .roles("USER")
        .build();
    UserDetails user3 = users
        .username("ほんだ")
        .password("$2y$10$o29f7HEIsyxN0Tp5qC4lR.DEXNGUEV7zNm27EE.w6/lgpPTRjevf6")
        .roles("USER")
        .build();
    UserDetails user4 = users
        .username("いがき")
        .password("$2y$10$bj5JYuU8msBU71fZK1Php.Yf2Y8dxgmVOWYF1iwidrzrzAKEmFui6")
        .roles("USER")
        .build();
    return new InMemoryUserDetailsManager(user1, user2, user3, user4);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.formLogin();
    http.authorizeHttpRequests().mvcMatchers("/janken/**").authenticated();
    http.logout().logoutSuccessUrl("/");

    http.csrf().disable();
    http.headers().frameOptions().disable();
    return http.build();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
