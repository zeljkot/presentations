package streams.endtoend;
/*
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.IntStream;

//@RestController
public class PersonRestJdbcController {

    private PersonRepository personRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonRestJdbcController(PersonRepository personRepository) {

        this.personRepository = personRepository;
        System.out.println("#### Adding elements");
        IntStream.range(0, 100000)
                .mapToObj(id -> new Person(id, "First " + id, "Last " + id))
                .forEach(person -> {
                    if (person.getId() % 10000 == 0) System.out.print(person.getId() + " ");
                    personRepository.save(person);
                });
        System.out.println("#### Done");
    }

    @GetMapping()
    public Iterable<Person> getPersons() {

        return personRepository.findAll();
    }

    @GetMapping("jdbc")
    public List<Person> getPersonsJdbc() {

        return jdbcTemplate.query("select id, first_name, last_name from person",
                (rs, rowNum) -> mapPerson(rs));
    }

    @GetMapping("jdbcstream")
    public StreamingResponseBody getPersonsStream() {

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writerFor(Person.class);
        return outputStream -> {
            jdbcTemplate.query("select id, first_name, last_name from person", new RowCallbackHandler() {
                @Override
                public void processRow(ResultSet rs) throws SQLException {
                    Person person = mapPerson(rs);
                    try {
                        objectWriter.writeValue(outputStream, person);
                        if (person.getId() % 100 == 0) outputStream.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        };
    }

    @NotNull
    private Person mapPerson(ResultSet rs) throws SQLException {
        return new Person(rs.getInt(1), rs.getString(2), rs.getString(3));
    }
}
*/