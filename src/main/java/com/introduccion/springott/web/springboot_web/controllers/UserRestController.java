package com.introduccion.springott.web.springboot_web.controllers;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.introduccion.springott.web.springboot_web.controllers.models.User;
import com.introduccion.springott.web.springboot_web.controllers.models.DTO.UserDTO;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api")
public class UserRestController {

  @GetMapping("/detalles")
  public UserDTO detalles() {
    User user = new User("Ever", "Sorto");
    UserDTO userDto = new UserDTO();
    userDto.setUser(user);
    userDto.setTitle("User Details");
    return userDto;
  }
  
  public String getMethodName(@RequestParam String param) {
      return new String();
  }
  @GetMapping("/lista")
  public List<User> consultarUsurio (){
    User  user1 = new User("Alfredo", "Sorto");  
    User  user2 = new User("Ricardo ", "Andrade");
    User  user3 = new User("Pedro", "Pascal");
    
    List<User> listaDeUsuarios =  Arrays.asList(user1, user2, user3);
    
    return  listaDeUsuarios ;
  }



}