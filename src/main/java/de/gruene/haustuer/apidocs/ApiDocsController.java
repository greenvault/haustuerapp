package de.gruene.haustuer.apidocs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/apidocs")
public class ApiDocsController {

  @GetMapping
  String redirect() {
    return "redirect:/apidocs/index.html";
  }

}
