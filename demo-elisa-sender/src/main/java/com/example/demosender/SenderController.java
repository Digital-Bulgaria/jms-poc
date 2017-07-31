package com.example.demosender;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/* Yes, I know this is not proper REST */
@RestController
public class SenderController {

  private Sender sender;

  public SenderController(Sender sender) {
    this.sender = sender;
  }

  @PostMapping(path = "send")
  public String post(@RequestBody String text) {
    sender.sendTextMessage(text);
    return "Message sent.";
  }
}
