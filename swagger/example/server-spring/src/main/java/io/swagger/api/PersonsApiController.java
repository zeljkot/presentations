package io.swagger.api;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Person;
import io.swagger.model.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.math.BigDecimal;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-08-29T20:02:44.702Z")

@Controller
public class PersonsApiController implements PersonsApi {

    @Autowired
    PersonRepository personRepository;

    public ResponseEntity<Iterable<Person>> personsGet(
            @ApiParam(value = "Size of array", defaultValue = "20")
            @RequestParam(value = "size", required = false, defaultValue = "20")
                    BigDecimal size
    ) {
        // do some magic!
        return new ResponseEntity<Iterable<Person>>(personRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Void> personsIdDelete(
            @ApiParam(value = "", required = true)
            @PathVariable("id") Integer id
    ) {
        personRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Person> personsIdGet(
            @ApiParam(value = "", required = true)
            @PathVariable("id")
                    Integer id
    ) {
        return personRepository.findById(id)
                .map(person -> new ResponseEntity<Person>(person, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<Person>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Integer> personsIdPut(
            @ApiParam(value = "", required = true)
            @PathVariable("id")
                    Integer id,
            @ApiParam(value = "")
            @Valid @RequestBody
                    Person person
    ) {
        if (person.getId() == null) {
            person.setId(id);
        }
        if (id == person.getId()) {
            personRepository.save(person);
            return new ResponseEntity<Integer>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Integer> personsPost(@ApiParam(value = "") @Valid @RequestBody Person person) {
        if (person.getId() != null) {
            return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
        }
        Person newPerson = personRepository.save(person);
        return new ResponseEntity<Integer>(newPerson.getId(), HttpStatus.OK);
    }

}
