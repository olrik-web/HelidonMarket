package dk.eaaa.resource;

import dk.eaaa.resource.dto.CreateUserDTO;
import dk.eaaa.resource.dto.UserDTO;
import dk.eaaa.service.AdService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/users")
public class UserResource {

    private AdService service;
    private AdMapper mapper;

    @Inject
    public UserResource(AdService service, AdMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Path("/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void createUser(CreateUserDTO createUserDTO) {
        service.createUser(mapper.map(createUserDTO));
    }
/*
    @Path("/")
    @GET
    public List<UserDTO> getUsers() {
        return service.getUsers().stream().map(mapper::map).collect(Collectors.toList());
    }

 */
}
