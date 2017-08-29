package presentation.swagger;

import io.swagger.annotations.*;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Component
@Path("/persons")
@Api(value = "Person administration", tags = {"person"})
public class PersonsApiController {

    private static final String DEFAULT_SIZE_STRING = "20";
    private static final int DEFAULT_SIZE = Integer.parseInt(DEFAULT_SIZE_STRING);

    @Inject
    PersonRepository personRepository;

    @ApiOperation(value = "Get all persons", notes = "Gets `Person` objects. Optional query param of **size** determines size of returned array ")
    //, response = Person.class, responseContainer = "Iterable")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = Person.class, responseContainer = "Iterable")
    })
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Person> getAll(
            @QueryParam("size")
            @ApiParam(value = "Size of array", defaultValue = DEFAULT_SIZE_STRING)
                    Integer size
    ) {
        if (size == null) {
            size = DEFAULT_SIZE;
        }
        return personRepository.findAll();
    }

    @DELETE
    @Path("{id}")
    @ApiOperation(value = "Deletes the person", notes = "Person is *permanently* deleted")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User deleted"),
            @ApiResponse(code = 403, message = "Person not found")}
    )
    public void delete(
            @PathParam("id")
            @NotNull
            @ApiParam(value = "Person ID")
                    Integer id
    ) {
        personRepository.delete(id);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Retrieves person by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not found")
    })
    public Person get(
            @PathParam("id")
            @NotNull
            @ApiParam(value = "Person ID")
                    Integer id
    ) {
        return Optional.ofNullable(personRepository.findOne(id))
                .orElseThrow(() -> new NotFoundException());
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Adds new user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User updated"),
            @ApiResponse(code = 400, message = "User error")
    })
    public void put(
            @PathParam("id")
            @NotNull
            @ApiParam(value = "Person ID")
                    Integer id,
            @ApiParam(value = "Person data")
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
    @ApiOperation(value = "Adds new user", notes = "Returns user ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User saved. Returns user ID", response = Integer.class),
            @ApiResponse(code = 400, message = "User error")
    })
    public Integer personsPost(
            @ApiParam(value = "")
                    Person person
    ) {
        if (person.getId() != null) {
            throw new BadRequestException("No ID on POST");
        }
        Person newPerson = personRepository.save(person);
        return newPerson.getId();
    }
}
