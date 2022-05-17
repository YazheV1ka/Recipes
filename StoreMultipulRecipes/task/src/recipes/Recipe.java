package recipes;

import lombok.Data;

@Data
public class Recipe {

    private String name;
    private String description;
    private String[] ingredients;
    private String[] directions;
}