//package com.gfg.librarymanagement.config;
//
//import com.gfg.librarymanagement.manager.CustomUserManangerImpl;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.*;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConf {
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .authorizeHttpRequests((authz)->
//                        authz.requestMatchers("/home")
//                                .permitAll()
//                                .requestMatchers("/api/book/**")
//                                .hasAnyRole("USER","ADMIN")
//                                .requestMatchers("/api/**")
//                                .authenticated()
//
//
//                        )
//                .httpBasic(Customizer.withDefaults())
//                .cors(cors -> cors.disable())
//                .authenticationManager(provider())
//
//
//        ;
//       return httpSecurity.build();
//    }
//
//    @Bean
//    UserDetailsService userDetailsService2(){
//        return new CustomUserManangerImpl();
//    }
//
//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean AuthenticationManager provider(){
//        return new ProviderManager(
//                authenticationProvider(userDetailsService()),
//                authenticationProvider(userDetailsService2())
//        );
//    }
//
//
//    @Bean
//    InMemoryUserDetailsManager userDetailsService(){
//
//        UserDetails admin = User.builder()
//                .password(passwordEncoder().encode("password"))
//                .username("admin")
//                .roles("ADMIN")
//                .build();
//        UserDetails guest = User.builder()
//                .password(passwordEncoder().encode("password"))
//                .username("guest")
//                .roles("GUEST")
//                .build();
//        return new InMemoryUserDetailsManager(admin,guest);
//    }
//
//    private AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService){
//        return new AuthenticationProvider() {
//            @Override
//            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//                String username = authentication.getName();
//                String password = authentication.getCredentials().toString();
//                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//                if (passwordEncoder().matches(password, userDetails.getPassword())){
//                    return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
//                }
//                throw  new BadCredentialsException("");
//            }
//
//            @Override
//            public boolean supports(Class<?> authentication) {
//                return authentication.equals(UsernamePasswordAuthenticationToken.class);
//            }
//        };
//    }
//
//}


