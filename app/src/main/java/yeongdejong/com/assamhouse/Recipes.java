package yeongdejong.com.assamhouse;

/**
 * Created by T00185309 - Yeong De Jong on 13/04/2017.
 */

public class Recipes {
    private int foodID;
    private String name;
    private String category;
    private int image;
    private String description;
    private String servings;
    private String prepareTime;
    private String cookTime;
    private String ingredient;
    private String direction;

    public Recipes() {
        this(0,"Unknown","Unknown",0,"Unknown","Unknown","Unknown","Unknown","Unknown","Unknown");
    }

    public Recipes(int foodID, String name, String category, int image, String description, String servings, String prepareTime, String cookTime, String ingredient, String direction) {
        setFoodID(foodID);
        setName(name);
        setCategory(category);
        setImage(image);
        setDescription(description);
        setServings(servings);
        setPrepareTime(prepareTime);
        setCookTime(cookTime);
        setIngredient(ingredient);
        setDirection(direction);
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setServings(String servings) {
        this.servings = servings;
    }

    public String getServings() {
        return servings;
    }

    public void setPrepareTime(String prepareTime) {
        this.prepareTime = prepareTime;
    }

    public String getPrepareTime() {
        return prepareTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    public String getCookTime() {
        return cookTime;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
}
