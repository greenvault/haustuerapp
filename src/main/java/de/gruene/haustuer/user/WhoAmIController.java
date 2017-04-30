package de.gruene.haustuer.user;

import java.util.HashMap;
import java.util.Map;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/me")
public class WhoAmIController {

  @GetMapping
  public Map<String, String> whoAmI(Authentication authentication) {
    HashMap<String, String> response = new HashMap<>();
    response.put("principal", authentication.getName());

    return response;
  }

}
