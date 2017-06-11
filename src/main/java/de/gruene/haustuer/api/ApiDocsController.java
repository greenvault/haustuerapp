package de.gruene.haustuer.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/docs")
public class ApiDocsController {

  @GetMapping
  String redirect() {
    return "redirect:/docs/index.html";
  }

}
