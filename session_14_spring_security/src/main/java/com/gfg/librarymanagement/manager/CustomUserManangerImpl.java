//package com.gfg.librarymanagement.manager;
//
//import com.gfg.librarymanagement.entity.User;
//import com.gfg.librarymanagement.repo.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.Optional;
//
//public class CustomUserManangerImpl implements UserDetailsService {
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> userOptional = userRepository.findByEmail(username);
//        if (userOptional.isEmpty()){
//            throw new UsernameNotFoundException("");
//        }
//        User user = userOptional.get();
//
//        return org.springframework.security.core.userdetails.User.builder()
//                .username(user.getEmail())
//                .roles("USER")
//                .password(passwordEncoder.encode("password"))
//                .accountExpired(false)
//                .accountLocked(false)
//                .credentialsExpired(false)
//                .disabled(false)
//                .build();
//    }
//}
