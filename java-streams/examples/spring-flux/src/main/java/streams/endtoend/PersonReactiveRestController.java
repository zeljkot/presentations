package streams.endtoend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.util.stream.IntStream;

@RestController
@RequestMapping("flux")
public class PersonReactiveRestController {

    @Autowired
    private PersonReactiveRepository personRepository;

    @PostConstruct
    public void initData() {

        //personRepository.saveAll(s -> {s});
        System.out.println("#### Adding elements");
        IntStream.range(0, 100)
                .mapToObj(id -> new Person(id, "First " + id, "Last " + id))
                .forEach(person -> personRepository.save(person));

        System.out.println("personRepository.count() = " + personRepository.count());
    }

    //@Transactional(readOnly = true)
    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Person> getPersonsStream() {

        return personRepository.findAll();
    }
}
