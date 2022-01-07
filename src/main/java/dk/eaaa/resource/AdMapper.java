package dk.eaaa.resource;

import dk.eaaa.domain.*;
import dk.eaaa.resource.dto.*;

import javax.enterprise.context.Dependent;
import java.time.LocalDate;

@Dependent
public class AdMapper {
    public AdDTO map(Ad ad) {
        return new AdDTO(
                ad.getAdContent().getId().toString(),
                map(ad.getAdContent().getCategory()).getName(),
                ad.getAdContent().getType(),
                ad.getAdContent().getHeadline(),
                ad.getAdContent().getText(),
                ad.getAdContent().getPrice(),
                ad.getAdContent().getCreation_date(),
                map(ad.getUser())
        );
    }

    public AdContentDTO map(AdContent adContent) {
        return new AdContentDTO(
                adContent.getId().toString(),
                map(adContent.getCategory()).getName(),
                adContent.getType(),
                adContent.getHeadline(),
                adContent.getText(),
                adContent.getPrice(),
                adContent.getCreation_date()
        );
    }

    public AdContent map(CreateAdDTO createAdDTO) {
        return new AdContent(
                null,
                map(createAdDTO.getCategory()),
                createAdDTO.getType(),
                createAdDTO.getHeadline(),
                createAdDTO.getText(),
                createAdDTO.getPrice(),
                LocalDate.now()
        );
    }

    public Id mapId(String id) {
        return new Id(id);
    }

    public UserDTO map(User user) {
        return new UserDTO(
                user.getUserContent().getId().toString(),
                user.getUserContent().getFirst_name(),
                user.getUserContent().getLast_name(),
                user.getUserContent().getPhone_number(),
                user.getUserContent().getPhone_code(),
                user.getUserContent().getEmail(),
                user.getUserContent().getCreation_date(),
                user.getUserContent().getCity(),
                user.getUserContent().getCompany(),
                user.getUserContent().getType(),
                user.getUserContent().getZipcode());
    }

    public UserContent map(CreateUserDTO createUserDTO) {
        return new UserContent(
                null,
                createUserDTO.getFirst_name(),
                createUserDTO.getLast_name(),
                createUserDTO.getPhone_number(),
                createUserDTO.getPhone_code(),
                createUserDTO.getEmail(),
                null,
                createUserDTO.getCity(),
                createUserDTO.getCompany(),
                createUserDTO.getType(),
                createUserDTO.getZipcode());
    }

    public CategoryDTO map(Category category) {
        return new CategoryDTO(category.name());
    }

    public Category map(String category) {
        return Category.valueOf(category);
    }
}
