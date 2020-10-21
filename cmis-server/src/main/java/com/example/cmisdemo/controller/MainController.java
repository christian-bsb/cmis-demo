package com.example.cmisdemo.controller;

import com.example.cmisdemo.model.Greeting;
import com.example.cmisdemo.model.RepositoryInfo;
import com.example.cmisdemo.service.RepositoryService;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*

see  https://spring.io/guides/gs/rest-service/
 */
@RestController
public class MainController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @Autowired RepositoryService repositoryService;

  @GetMapping("/")
  public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }

  @GetMapping("/repository/{repositoryId}")
  public RepositoryInfo getRepositoryInfo(@PathVariable String repositoryId) {
    return repositoryService.getRepository(repositoryId).getInfo();
  }

  @GetMapping("/repositories")
  public List<RepositoryInfo> getRepositories() {
    return repositoryService.getRepositoryInfos();
  }
}
