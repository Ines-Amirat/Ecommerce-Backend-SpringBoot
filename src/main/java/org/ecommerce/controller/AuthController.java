package org.ecommerce.controller;


import org.ecommerce.dto.user.UserResponseDTO;
import org.ecommerce.exception.InvalidPasswordException;
import org.ecommerce.exception.UserNotFoundException;
import org.ecommerce.model.User;
import org.ecommerce.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController  {

    private final AuthService authService ;

    @Autowired
    public AuthController (AuthService authService){
          this.authService = authService;
    }

      @PostMapping("/register")
      public ResponseEntity<Map<String, String>> register(@RequestBody User user){

          String email = user.getEmail();
          String name = user.getName();
          String password = user.getPassword();

          authService.register(email,name,password);
          Map<String,String> response = new HashMap<>();
          response.put("message","Registration successful");

          return  ResponseEntity.ok(response);

      }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){

        String email = user.getEmail();
        String password = user.getPassword();

        Map<String,String> error = new HashMap<>();
        try {
            User userFind = authService.login(email,password);
            UserResponseDTO userResponseDTO = new UserResponseDTO(userFind.getName(), userFind.getEmail() );

            return ResponseEntity.ok(userResponseDTO);

        }catch(UserNotFoundException e){
            error.put("error","User not found");
            return ResponseEntity.status(404).body(error);
        }
        catch(InvalidPasswordException e){
            error.put("error","Password incorrect");
            return ResponseEntity.status(401).body(error);
        }



    }




}
