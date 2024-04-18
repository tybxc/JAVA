import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MessageDisplayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageDisplayApplication.class, args);
    }
}

@RestController
class MessageController {

    @GetMapping("/")
    public String displayMessage() {
        return "If you can't explain it simply, you don't understand it well enough";
    }
}
