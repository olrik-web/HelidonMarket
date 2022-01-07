package dk.eaaa.resource;

import dk.eaaa.domain.Ad;
import dk.eaaa.resource.dto.AdContentDTO;
import dk.eaaa.resource.dto.AdDTO;
import dk.eaaa.resource.dto.CreateAdDTO;
import dk.eaaa.service.AdService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/ads")
public class AdResource {

    private AdService service;
    private AdMapper mapper;

    @Inject
    public AdResource(AdService service, AdMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Path("/")
    @GET
    public List<AdContentDTO> getAds(@QueryParam("category") String category) {
        return service.getAds(mapper.map(category)).stream().map(mapper::map).collect(Collectors.toList());
    }

    @Path("/{id}")
    @GET
    public AdDTO getAd(@PathParam("id") String id) {
        return mapper.map(service.getAd(mapper.mapId(id)));
    }

    @Path("/{userId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void createAd(CreateAdDTO ad, @PathParam("userId") String userId) {
        service.createAd(mapper.map(ad), mapper.mapId(userId));
    }
}
