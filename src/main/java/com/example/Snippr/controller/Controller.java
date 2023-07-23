package com.example.Snippr.controller;

import com.example.Snippr.model.Snippet;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @PostMapping("/token")
  public ResponseEntity<String> getToken(){
    return ResponseEntity.ok(null);
  }


  @GetMapping("/snippet")
  public List<Snippet> getAllSnippets(){
    return null;
  }

  @GetMapping("/snippet/{id}")
  public List<Snippet> getAnSnippet(@PathVariable(value = "id") Long id){
    return null;
  }

  @PostMapping("/snippet")
  public List<Snippet> sendASnippet(@RequestBody Snippet snippet){
    return null;
  }



}
