package streams.endtoend;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
@RequestMapping("stream")
public class PersonStreamRestController {

    @Autowired
    private PersonRepository personRepository;

    public void initData(PersonRepository personRepository) {

        System.out.println("#### Adding elements");
        IntStream.range(0, 100)
                .mapToObj(id -> new Person(id, "First " + id, "Last " + id))
                .forEach(person -> personRepository.save(person));
    }

    @GetMapping("classic")
    public Iterable<Person> getPersons() {

        return personRepository.findAll();
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    @GetMapping("stream")
    public StreamingResponseBody getPersonsStream() {

        return new StreamingResponseBody() {

            @Autowired
            ShovelBean shovelBean;

            @Override
            public void writeTo(OutputStream outputStream) throws IOException {
                shovelBean().shovel(outputStream);
            }
        };
    }

    class ShovelBean {
        @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
        public void shovel(OutputStream outputStream) {
            try (
                    PrintWriter writer = new PrintWriter(outputStream);
                    Stream<Person> stream = personRepository.streamAll()
            ) {
                stream
                        .map(person -> person.getFirstName() + " " + person.getLastName())
                        .forEach(name -> {
                            writer.println(name);
                            writer.flush();
                        });
            }
        }
    }

    @Bean
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    ShovelBean shovelBean() {
        return new ShovelBean();
    }
}

    */
