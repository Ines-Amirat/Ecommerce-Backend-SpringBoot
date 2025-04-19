package org.ecommerce.service;

import org.ecommerce.exception.InvalidPasswordException;
import org.ecommerce.exception.UserNotFoundException;
import org.ecommerce.model.Role;
import org.ecommerce.model.User;
import org.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService (UserRepository userRepository , PasswordEncoder passwordEncoder){
        this.userRepository =userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    public void register(String email, String name,String password){
        if(userRepository.findByEmail(email).isPresent()){
            throw new IllegalStateException("Email already used");
        }
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(Role.user);
        userRepository.save(user);

    }

    public User login(String email , String password){

        Optional<User> userOpt = userRepository.findByEmail(email);

        if(userOpt.isEmpty()){
            throw new UserNotFoundException("User not found");
        }
        if(!passwordEncoder.matches(password,userOpt.get().getPassword())){
            throw new InvalidPasswordException("password not correct");
        }
        User user = userOpt.get();
        return user ;
    }


}
