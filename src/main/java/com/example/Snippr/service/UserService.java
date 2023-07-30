package com.example.Snippr.service;

import com.example.Snippr.model.User;
import com.example.Snippr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User getUser(Long id){
    return userRepository.getById(id);
  }

  public User saveUser(User user){
    return userRepository.save(user);
  }

  public User updateUserDetails(User user) {
    //return userRepository.
    return null;
  }
}
