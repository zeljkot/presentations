package presentation.swagger;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Component
@Path("/persons")
@Api(tags = {"person"})
public class PersonsApiController {

    @Inject
    PersonRepository personRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Person> personsGet(
            @QueryParam("size")
                    Double size
    ) {
        if (size == null) {
            size = 20.0;
        }
        return personRepository.findAll();
    }

    @DELETE
    @Path("{id}")
    public void delete(
            @PathParam("id")
            @NotNull
                    Integer id
    ) {
        personRepository.delete(id);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person get(
            @PathParam("id")
            @NotNull
                    Integer id
    ) {
        return Optional.ofNullable(personRepository.findOne(id))
                .orElseThrow(() -> new NotFoundException());
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void put(
            @PathParam("id")
            @NotNull
                    Integer id,
            Person person
    ) {
        if (person.getId() == null) {
            person.setId(id);
        }
        if (id == person.getId()) {
            personRepository.save(person);
        } else {
            throw new BadRequestException("IDs do not match");
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Integer personsPost(
            Person person
    ) {
        if (person.getId() != null) {
            throw new BadRequestException("No ID on POST");
        }
        Person newPerson = personRepository.save(person);
        return newPerson.getId();
    }

}
