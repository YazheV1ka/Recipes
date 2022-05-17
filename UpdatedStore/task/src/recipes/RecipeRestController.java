package recipes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class RecipeRestController {

    int id = 0;
    Map<Integer, Recipe> recipeBook = new HashMap<>();

    @PostMapping(path = "/recipe/new", consumes = "application/json", produces = "application/json")
    public Integer adding(@RequestBody Recipe recipe) {
        if (!recipeBook.containsValue(recipe)) {
            recipeBook.put(++id, recipe);
        }
        return id;
    }

    @GetMapping("/recipe/{id}")
    public Recipe retrieving(@PathVariable int id) {
        Recipe recipe = recipeBook.get(id);
        if (recipe == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        return recipe;
    }

    @PutMapping("/recipe/{id}")
    public Integer editRecipe(@RequestBody Recipe recipe, @PathVariable int id) {
        if (!recipeBook.containsValue(recipe)) {
            recipeBook.put(++id, recipe);
        }
        return id;
    }

    @DeleteMapping("/recipe/{id}")
    public void deleteDocument(@RequestParam(value="id") Integer id){
        recipeBook.remove(id);
    }
}