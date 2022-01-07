package dk.eaaa.repository;

import dk.eaaa.domain.Category;
import dk.eaaa.domain.Id;
import javax.enterprise.context.Dependent;
import java.util.UUID;

@Dependent
public class Mapper {
    public Id map(UUID id) {
        return new Id(id.toString());
    }

    public Category map(String category) {
        return Category.valueOf(category);
    }

}
