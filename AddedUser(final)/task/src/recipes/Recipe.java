package recipes;

import lombok.Data;

import java.time.LocalTime;

@Data
public class Recipe {

    private String name;
    private String category;
    private LocalTime date;
    private String description;
    private String[] ingredients;
    private String[] directions;
}