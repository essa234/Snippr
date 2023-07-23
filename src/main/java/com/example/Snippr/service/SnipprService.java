package com.example.Snippr.service;

import com.example.Snippr.model.Snippet;
import com.example.Snippr.repository.Repository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SnipprService {

  @Autowired
  private Repository repository;

  public Snippet getSnippet(Long id){
    return repository.getById(id);
  }

  public List<Snippet> getAllSnippets(){
    return repository.findAll();
  }

  public Snippet saveASnippet(Snippet snippet){
    return repository.save(snippet);
  }
}
