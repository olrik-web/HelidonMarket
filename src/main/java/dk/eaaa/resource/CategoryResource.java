package dk.eaaa.resource;

import dk.eaaa.domain.Category;
import dk.eaaa.resource.dto.CategoryCountDTO;
import dk.eaaa.service.AdService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/categories")
public class CategoryResource {

    private AdService service;
    private AdMapper mapper;

    @Inject
    public CategoryResource(AdService service, AdMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Path("/")
    @GET
    public List<Category> getCategories() {
        return service.getCategories().stream().collect(Collectors.toList());
    }

    @Path("/count")
    @GET
    public List<CategoryCountDTO> getNumberOfCategories() {
        return service.getNumberOfCategories().entrySet()
                .stream().map(c -> new CategoryCountDTO(mapper.map(c.getKey()), c.getValue()))
                .collect(Collectors.toList());
    }
}
