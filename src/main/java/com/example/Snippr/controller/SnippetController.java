package com.example.Snippr.controller;

import com.example.Snippr.model.Snippet;
import com.example.Snippr.service.SnipprService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SnippetController {

  @Autowired
  private SnipprService service;

//  @PostMapping("/token")
//  public ResponseEntity<String> getToken(){
//    return ResponseEntity.ok(null);
//  }


  @GetMapping("/snippet")
  @PreAuthorize("hasAuthority('SCOPE_profile')")
  public List<Snippet> getAllSnippets(){
    return service.getAllSnippets();
  }

  @GetMapping("/snippet/{id}")
  @PreAuthorize("hasAuthority('SCOPE_profile')")
  public Snippet getAnSnippet(@PathVariable(value = "id") Long id){
    return service.getSnippet(id);
  }

  @PostMapping("/snippet")
  @PreAuthorize("hasAuthority('SCOPE_profile')")
  public Snippet sendASnippet(@RequestBody Snippet snippet){
    return service.saveASnippet(snippet);
  }



}
