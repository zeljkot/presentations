package presentation.swagger;

import io.swagger.annotations.*;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Component
@Path("/persons")
@Api(tags = {"person"})
public class PersonsApiController {

    @Inject
    PersonRepository personRepository;

    @ApiOperation(value = "", notes = "Gets `Person` objects. Optional query param of **size** determines size of returned array ", response = Person.class, responseContainer = "Iterable", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = Person.class, responseContainer = "Iterable")
    })
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Person> personsGet(
            @QueryParam("size")
            //@NotNull
            @ApiParam(value = "Size of array", required = true)
                    Double size
    ) {
        return personRepository.findAll();
    }

    @DELETE
    @Path("{id}")
    @ApiOperation(value = "Deletes the person", notes = "Person is *permanently* deleted", response = Void.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Void.class),
            @ApiResponse(code = 403, message = "Person not found", response = Void.class)}
    )
    public void delete(
            @PathParam("id")
            @ApiParam(value = "Person ID", required = true)
                    Integer id
    ) {
        personRepository.delete(id);
    }

    @GET
    @Path("{id}")
    @ApiOperation(value = "Retrieves person by ID", notes = "", response = Person.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Person.class)}
    )
    public Person get(
            @PathParam("id")
            @ApiParam(value = "Person ID", required = true)
                    Integer id
    ) {
        return Optional.ofNullable(personRepository.findOne(id))
                .orElseThrow(() -> new NotFoundException());
    }

    @PUT
    @Path("{id}")
    @ApiOperation(value = "Adds new user", notes = "", response = Integer.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Integer.class)}
    )
    public void put(
            @PathParam("id")
            @ApiParam(value = "Person ID", required = true)
                    Integer id,
            @ApiParam(value = "Person data")
                    Person person
    ) {
        if (id == person.getId()) {
            personRepository.save(person);
        } else {
            personRepository.save(person);
        }
    }

    @POST
    @ApiOperation(value = "Adds new user", notes = "", response = Integer.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Integer.class)}
    )
    public Integer personsPost(
            @ApiParam(value = "")
                    Person person
    ) {
        Person newPerson = personRepository.save(person);
        return newPerson.getId();
    }

}
