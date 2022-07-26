package bwina.java_social_server.domain.info;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("info")
public class InfoController {
    @GetMapping("about")
    public ResponseEntity<String> getPublic() {
        return ResponseEntity.ok("OK");
    }
}
