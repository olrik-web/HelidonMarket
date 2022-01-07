package dk.eaaa.resource.dto;

public class CategoryCountDTO {
    private final CategoryDTO category;
    private final int count;

    public CategoryCountDTO(CategoryDTO category, int count) {
        this.category = category;
        this.count = count;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public int getCount() {
        return count;
    }
}
