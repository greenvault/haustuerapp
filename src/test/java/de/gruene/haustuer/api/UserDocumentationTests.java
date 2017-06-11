package de.gruene.haustuer.api;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by @atamanroman on 05.06.17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = WhoAmIController.class)
@AutoConfigureRestDocs("target/generated-snippets")
public class UserDocumentationTests {

  @Autowired
  private MockMvc mvc;

  @Test
  public void listUsers() throws Exception {
    this.mvc
      .perform(get("/me").accept(MediaType.APPLICATION_JSON).with(user("foo")))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.principal").value("foo"))
      .andDo(document("whoami"));
  }

}
