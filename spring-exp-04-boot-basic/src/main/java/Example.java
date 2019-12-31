import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Example
 *
 * @author Eric at 2019-12-31_16:53
 */


//https://docs.spring.io/spring/docs/5.2.2.RELEASE/spring-framework-reference/web.html#spring-web
//@Controller and @ResponseBody
//writes directly to the response body
@RestController
@EnableAutoConfiguration    // Spring-boot根据dependencies去猜测如何进行自动配置
public class Example {

    @RequestMapping("/")
    String home() {
        return "Hello!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Example.class, args);
    }
}
