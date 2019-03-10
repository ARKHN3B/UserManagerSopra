package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // Si on ne précise pas l'attribut method dans la signature @RequestMapping, tout type de requête sera accepté ! (GET, PUT, ...)
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    // Utilisation d'une route avec la méthode GET
    @RequestMapping(value ="/show-name", method = RequestMethod.GET)
    public String showName(
            @RequestParam(value = "firstname", defaultValue = "firstname") String firstname,
            @RequestParam(value = "lastname", defaultValue = "lastname") String lastname
    ) {
        return "Hello " + firstname + " " + lastname;
    }

    // L'url par défaut sera le nom de la fonction (non-sensible à la casse)
    @RequestMapping(produces = "text/html") // produces permet de définir le type MIME en sortie
    public String testWithoutValMap() {
        return "This is a test without use a Request Mapping attribut !";
    }
}
