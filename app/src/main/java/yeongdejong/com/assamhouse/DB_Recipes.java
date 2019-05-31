package yeongdejong.com.assamhouse;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.*;
import android.database.Cursor;
import java.util.ArrayList;

/**
 * Created by T00185309 - Yeong De Jong on 11/04/2017.
 */

public class DB_Recipes extends SQLiteOpenHelper {

    public static final String DB_NAME = "assamhousedb";
    public static final String RECIPES_TABLE_NAME = "Recipes";
    public static final String RECIPES_COLUMN_FOOD_ID = "FoodID";
    public static final String RECIPES_COLUMN_NAME = "Name";
    public static final String RECIPES_COLUMN_CATEGORY = "Category";
    public static final String RECIPES_COLUMN_IMAGE = "Image";
    public static final String RECIPES_COLUMN_DESCRIPTION = "Description";
    public static final String RECIPES_COLUMN_SERVING = "Servings";
    public static final String RECIPES_COLUMN_PREPARE_TIME = "PrepareTime";
    public static final String RECIPES_COLUMN_COOK_TIME = "CookTime";
    public static final String RECIPES_COLUMN_INGREDIENT = "Ingredient";
    public static final String RECIPES_COLUMN_DIRECTION = "Direction";

    public DB_Recipes(Context context) {
        //CursorFactory null, Version 1
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TODO Auto-generated method stub
        String strSQL = "CREATE TABLE IF NOT EXISTS Recipes " +
                "(FoodID INTEGER PRIMARY KEY, Name TEXT, Category TEXT, Image BLOB, Description TEXT, Servings TEXT, PrepareTime TEXT, CookTime TEXT, Ingredient TEXT, Direction TEXT)";

        db.execSQL(strSQL);
    }

    /*****************************************************
     * Title: Android - SQLite Database
     * Author: tutorialspoint
     * Site owner/sponsor: tutorialspoint.com
     * Date: Unknown
     * Availability: https://www.tutorialspoint.com/android/android_sqlite_database.htm (Accessed 11 April 2017)
     * Modified: Used as a references for ContentValues
     * *****************************************************/
    public void insertKoreanCuisine() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        int foodID = getNextFoodID();
        contentValues.put("FoodID",foodID);
        contentValues.put("Name","Korean Mixed Rice (Bibimbap)");
        contentValues.put("Category","Korea");
        contentValues.put("Image",R.drawable.korean_bibimbap);
        contentValues.put("Description","Bibimbap a large bowl of rice topped with an array of individually prepared vegetables and beef.");
        contentValues.put("Servings","4-6 People");
        contentValues.put("PrepareTime","15-20 Minutes");
        contentValues.put("CookTime","5-10 Minutes");
        contentValues.put("Ingredient","\u2022 4 cloves garlic, minced, and divided\n\u2022 1/2lb. ground beef\n\u2022 1lb. bean sprouts\n2 zucchinis, julienned\n\u2022 1 carrot, julienned\n\u2022 6 shitake mushrooms, reconstituted and thinly sliced\n\u2022 1 bunch spinach, finely chopped\n\u2022 3 tablespoon soy sauce\n\u2022 1 tablespoon brown sugar\n\u2022 2 tablespoon sesame oil\n\u2022 2 cup short-grained rice, cooked\n\u2022 4 eggs, fried\nR\u2022 Red pepper paste");
        contentValues.put("Direction","Step 1:\nIn a wok over medium-high heat, heat oil and saute 1/3 the garlic until fragrant. Add beef and cook until browned, stirring frequently and transfer to platter.\n\nStep 2:\nIn same wok over medium-high heat, heat oil and saute the remaining 2/3 garlic until fragrant. Add bean sprouts, zucchini, carrot, and mushrooms, cook until al-dente, stirring frequently. Stir in spinach, soy sauce, and sugar. Season with salt and pepper. Cook until tender, stirring frequently. Combine with beef and toss with sesame oil.\n\nStep 3:\nSpoon over rice and top with fried egg and serve with red pepper paste.");
        db.insert(RECIPES_TABLE_NAME, null, contentValues);

        foodID = getNextFoodID();
        contentValues.put("FoodID",foodID);
        contentValues.put("Name","Korean Kimchi Pancake");
        contentValues.put("Category","Korea");
        contentValues.put("Image",R.drawable.korean_kimchi_pancake);
        contentValues.put("Description","Traditional Korean pancake made from salted and fermented cabbages and radishes.");
        contentValues.put("Servings","2-4 People");
        contentValues.put("PrepareTime","5-10 Minutes");
        contentValues.put("CookTime","10-15 Minutes");
        contentValues.put("Ingredient","\u2022 1 cup chopped kimchi\n\u2022 3 tablespoons kimchi juice\n\u2022 2 tablespoons chopped onion\n\u2022 1/2 tablespoon salt\n\u2022 1/2 tablespoon sugar\n\u2022 1/2 cup flour\n\u2022 1/4 cup water");
        contentValues.put("Direction","Step 1:\nIn a bowl, place all ingredients and mix it well with a spoon.\n\nStep 2:\nHeat up a 12-inch non-stick pan over medium high head and drizzle about 2 tablespoons grape seed oil.\n\nStep 3:\nPlace the mixture of kimchi pancake batter on the pan and spread it thinly and evenly with a spoon.\n\nStep 4:\nCook it for 1 to 2 minutes until the bottom gets golden brown and crispy.\n\nStep 5:\nTurn it over with a spatula and lower the head to medium and cook for another 1-2 minutes.\n\nStep 6\nTurn in over one more time and cook for 30 seconds before transferring it to a serving plate.");
        db.insert(RECIPES_TABLE_NAME, null, contentValues);

        foodID = getNextFoodID();
        contentValues.put("FoodID",foodID);
        contentValues.put("Name","Korean Spicy Rice Cake");
        contentValues.put("Category","Korea");
        contentValues.put("Image",R.drawable.korean_rice_cakes);
        contentValues.put("Description","Traditional Korean hot and spicy rice cake.");
        contentValues.put("Servings","2-4 People");
        contentValues.put("PrepareTime","10 Minutes");
        contentValues.put("CookTime","20 Minutes");
        contentValues.put("Ingredient","\u2022 300g rice cakes\n\u2022 1-2 sheets flat fish cakes\n\u2022 6-7 large dried anchovies\n\u2022 1 large piece dried sea kelp\n\u2022 3 cups water\n\u2022 1/4 small cabbage, diced\n\u2022 1/2 onion, sliced\n\u2022 1 small carrot, thinly sliced\n\u2022 2 heaping tablespoons Korean chili paste\n\u2022 1 tablespoon Korean chili flakes\n\u2022 1 tablespoons soy sauce\n\u2022 1 tablespoon sugar\n\u2022 1 green onion, chopped\n\u2022 2-4 hard boiled eggs\n\u2022 1 tablespoon corn syrup, optional");
        contentValues.put("Direction","Step 1:\nIn a small pot, combine 3 cups water with dried anchovies and sea kelp. Bring to boil first, then simmer over low heat for 10 minutes. Remove from the heat and let it soak for 5 minutes. Discard the anchovies and the sea kelp and reserve 2 cups of the stock. Set aside.\n\nStep 2:\nMeanwhile if your rice cakes are frozen, soak them in the cold water for 10 minutes. Drain and set aside.\n\nStep 3:\nIn a skillet, combine Korean chili paste, chili flakes, soy sauce, sugar, corn syrup. Pour the reserved 2 cups of anchovy stock and mix everything well. Put cabbage, onion, carrot, and rice cakes in the skillet and bring to boil over medium heat. When it starts to boil, stir occasionally to incorporate everything with the sauce and let them simmer for 15 minutes.  Adjust the heat so that it doesn't burn or stick on the bottom in a skillet. Stir occasionally.\n\nStep 4:\nWhen the sauce gets reduced half-way and everything is tender, remove from the heat and place hard boiled eggs on top. Sprinkle with green onion as garnish. Serve hot.");
        db.insert(RECIPES_TABLE_NAME, null, contentValues);
    }

    public void insertIndonesiaCuisine() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        int foodID = getNextFoodID();
        contentValues.put("FoodID",foodID);
        contentValues.put("Name","Indonesian Fried Rice");
        contentValues.put("Category","Indonesia");
        contentValues.put("Image",R.drawable.indo_fried_rice);
        contentValues.put("Description","Traditional Indonesian fried rice served with fried egg.");
        contentValues.put("Servings","4 People");
        contentValues.put("PrepareTime","10 Minutes");
        contentValues.put("CookTime","10 Minutes");
        contentValues.put("Ingredient","\u2022 2 tablespoon oil\n\u2022 150g chicken breast, halved\n\u2022 3 1/2 tablespoons sweet soy sauce\n\u2022 2 garlic cloves, minced\n\u2022 1 tablespoon red chili\n\u2022 1/2 onion, diced\n\u2022 3 1/2 cups cooked long grain rice, cooled\n\u2022 1 egg");
        contentValues.put("Direction","Step 1:\nHeat oil in a large skillet over high heat. Drizzle sweet soy sauce over both sides of the chicken then cook until browned on both sides and cooked through. Remove from skillet, allow to cool slightly then dice.\n\nStep 2:\nHeat 1 tbsp oil in a wok (or skillet) over high heat. Add garlic and chili and cook until fragrant, then add onion. Cook onion until translucent.\n\nStep 3:\nAdd rice and sweet soy sauce. Cook, breaking up the rice, until the rice is heated through and the sweet soy sauce has been evenly dispersed and stains the rice brown. Add chicken and stir.\n\nStep 4:\nTransfer rice to a serving platter. Sprinkle with scallions or shallots and fried shallots if using.\n\nStep 5:\nCook eggs, sunny side up, to your liking and serves the rice with a fried egg");
        db.insert(RECIPES_TABLE_NAME, null, contentValues);

        foodID = getNextFoodID();
        contentValues.put("FoodID",foodID);
        contentValues.put("Name","Indonesian Friend Noodles");
        contentValues.put("Category","Indonesia");
        contentValues.put("Image",R.drawable.indo_fried_noodles);
        contentValues.put("Description","Traditional Indonesian style fried noodles served with fried egg.");
        contentValues.put("Servings","4 People");
        contentValues.put("PrepareTime","20 Minutes");
        contentValues.put("CookTime","10-15 Minutes");
        contentValues.put("Ingredient","\u2022 3 tablespoons peanut oil\n\u2022 2 large eggs, lightly beaten\n\u2022 6 ounces dried Chinese egg noodles\n\u2022 6 ounces skinless, boneless chicken breast, thinly sliced\n\u2022 4 ounces boneless pork loin chop, sliced\n\u2022 2 garlic cloves, minced\n\u2022 2 cups thinly sliced cabbage\n\u2022 3/4 cups sliced green onions\n\u2022 1 celery stalk, thinly sliced\n\u2022 3 tablespoons chicken broth\n\u2022 1 tablespoons sweet soy sauce\n\u2022 1 tablespoon lower-sodium soy sauce\n\u2022 1/2 cup fried onions");
        contentValues.put("Direction","Step 1:\nHeat 1 tablespoon oil in a large nonstick skillet over medium-high heat. Pour eggs into pan and swirl to form a thin omelet. Cook 1 minute or until cooked on bottom. Carefully turn omelet over and cook for 30 seconds. Remove from pan. Roll up omelet and cut roll crosswise into thin strips. Keep warm.\n\nStep 2:\nCook noodles according to package directions. Drain and rinse with cold water and set aside.\n\nStep 3:\nHeat a wok over high heat. Add 2 tablespoons oil and swirl. Add chicken, pork, and garlic and stir-fry for 1-2 minutes. Add cabbage, green onions, and celery and stir-fry for another 1 minute. Stir in broth, sweet soy sauce, and soy sauce. Add noodles and stir-fry for another 3 minutes or until thoroughly heated and noodles begin to lightly brown. Add egg and toss gently. Top with fried onions. Serve immediately.");
        db.insert(RECIPES_TABLE_NAME, null, contentValues);

        foodID = getNextFoodID();
        contentValues.put("FoodID",foodID);
        contentValues.put("Name","Indonesian Grilled Chicken");
        contentValues.put("Category","Indonesia");
        contentValues.put("Image",R.drawable.indo_grilled_chicken);
        contentValues.put("Description","Traditional indonesian style Grilled Chicken");
        contentValues.put("Servings","4 People");
        contentValues.put("PrepareTime","65-75 Minutes");
        contentValues.put("CookTime","25-30 Minutes");
        contentValues.put("Ingredient","\u2022 1/2 cup orange juice\n\u2022 1/4 cup peanut butter\n\u2022 1 tablespoon curry powder\n\u2022 1lb. boneless skinless chicken breast, cut into strips\n\u2022 1 medium bell pepper, cut into 1/2-inch strips\n\u2022 1/2 cup shredded coconut toasted\n\u2022 1/2 cup golden raisin\n\u2022 Cooked Rice");
        contentValues.put("Direction","Step 1:\nPut the orange juice, peanut butter, and curry powder in blender container. Blend until smooth.\n\nStep 2:\nPlace the chicken strips in a medium bowl, pour the orange juice mixture all and stir to combine.\n\nStep 3:\nCover the chicken and place in refrigerator for 1 hour.\n\nStep 4:\nRemove the chicken from the marinade, discarding the marinade.\n\nStep 5:\nSpray a grill pan with nonstick cooking spray and place chicken strips on top along with bell pepper strips and cook over medium coals 10-15 Minutes, turning frequently, until pepper is tender and chicken is no longer pink in center.\n\nStep 6:\nSpoon cooked chicken on top of rice and garnish with coconut and raisins.");
        db.insert(RECIPES_TABLE_NAME, null, contentValues);
    }

    public void insertVietnamCuisine() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        int foodID = getNextFoodID();
        contentValues.put("FoodID",foodID);
        contentValues.put("Name","Vietnam Sugar Cane Prawn");
        contentValues.put("Category","Vietnam");
        contentValues.put("Image",R.drawable.viet_sugar_cane_prawn);
        contentValues.put("Description","Marinated prawn paste, sugar cane sticks, and sauces");
        contentValues.put("Servings","3-4 People");
        contentValues.put("PrepareTime","10 Minutes");
        contentValues.put("CookTime","15-20 Minutes");
        contentValues.put("Ingredient","\u2022 1 1/2 pound raw shrimp\n\u2022 3 cloves garlic\n\u2022 1/8 tablespoons salt\n\u2022 1/2 tablespoons sugar\n\u2022 3 dashes fish sauce\n\u2022 1 egg white, beaten until frothy\n\u2022 2 dashes white pepper powder\n\u2022 2 teaspoons cooking oil\n\u2022 Sugar cane, skin peeled, quartered into 5in' length");
        contentValues.put("Direction","Step 1:\nRinse and remove vein of the shrimp and pat dry the shrimp thoroughly with paper towels.\n\nStep 2:\nPut the shrimp, garlic, white pepper, lard/cooking oil into a food processor and blend well to form a smooth paste. Transfer the shrimp paste into a bowl.\n\nStep 3:\nBeat the egg white with an electronic hand beater until frothy. Combine the shrimp paste with beaten egg white and blend well. Chill in the refrigerator for 30 minutes and then divide the shrimp paste into four equal portions.\n\nStep 4:\nOil both hands and wrap the shrimp paste around the sugar cane. Shape them nicely and leave 1.5 inch of the sugar cane exposed. Heat up a wok of oil and deep fry until golden brown. Serve immediately.");
        db.insert(RECIPES_TABLE_NAME, null, contentValues);

        foodID = getNextFoodID();
        contentValues.put("FoodID",foodID);
        contentValues.put("Name","Vietnamese Pho");
        contentValues.put("Category","Vietnam");
        contentValues.put("Image",R.drawable.viet_beef_noodles);
        contentValues.put("Description","Vietnam Beef Noodle Soup");
        contentValues.put("Servings","4-6 People");
        contentValues.put("PrepareTime","20 Minutes");
        contentValues.put("CookTime","20 Minutes");
        contentValues.put("Ingredient","\u2022 8 ounces rice noodles\n\u2022 12 ounces lean bean sirloin, fat trimmed\n\u2022 Salt\n\u2022 Ground Pepper\n\u2022 1 large onion, halved\n\u2022 1-4 inch piece ginger\n\u2022 3 cups low-sodium beef broth\n\u2022 5 star anise pods\n\u2022 1 cinnamon stick\n\u2022 4 scallions\n\u2022 2 jalapeno peppers\n\u2022 1/2 cup fresh cilantro\n\u2022 3 tablespoons fish sauce\n\u2022 1 cup bean sprouts");
        contentValues.put("Direction","Step 1:\nPrepare the rice noodles as the label directs. Meanwhile, place a large pot over high heat\n\nStep 2:\nPoke the meat all over with a fork to tenderize it and season with salt and pepper.\n\nStep 3:\nSear the meat until charred but still rare, 2 to 3 minutes per side, then transfer to a plate.\n\nStep 4:\nAdd the onion and ginger to the pot and cook about 4 minutes.\n\nStep 5:\nAdd the broth, 3 cups water, the star anise and cinnamon, reduce the heat and simmer about 20 minutes.Meanwhile, thinly slice the scallions and jalapenos (remove seeds for less heat) and tear the cilantro.\n\nStep 6:\nThinly slice the meat against the grain. Drain the noodles.\n\nStep 7:\nAdd the fish sauce to the broth and boil 5 minutes.Discard the ginger, star anise and cinnamon stick, and slice the onion.\n\nStep 8:\nDivide the noodles among 4 bowls, top with the broth, beef, scallions, cilantro, bean sprouts, jalapenos and onion.");
        db.insert(RECIPES_TABLE_NAME, null, contentValues);

        foodID = getNextFoodID();
        contentValues.put("FoodID",foodID);
        contentValues.put("Name","Vietnam Spring Roll");
        contentValues.put("Category","Vietnam");
        contentValues.put("Image",R.drawable.viet_spring_roll);
        contentValues.put("Description","Wrapping shrimps, carrot, bean sprout, Thai basil, mint, fish sauce, and peanut with rice paper");
        contentValues.put("Servings","3-4 People");
        contentValues.put("PrepareTime","45 Minutes");
        contentValues.put("CookTime","5 Minutes");
        contentValues.put("Ingredient","\u2022 2 ounce rice vermicelli\n\u2022 8 rice wrappers\n\u2022 8 large cooked shrimp, peeled\n\u2022 1 1/3 tablespoons chopped Thai basil\n\u2022 3 tablespoons chopped mint leaves\n\u2022 3 tablespoons chopped cilantro\n\u2022 2 leaves lettuce, chopped\n\u2022 4 tablespoons fish sauce\n\u2022 1/4 cup water\n\u2022 2 tablespoons fresh lime juice\n\u2022 1 clove garlic, minced\n\u2022 2 tablespoons white sugar\n\u2022 1/2 teaspoon garlic chili sauce\n\u2022 3 tablespoons Hoisin sauce\n\u2022 1 teaspoon finely chopped peanuts");
        contentValues.put("Direction","Step 1:\nBring a medium saucepan of water to boil. Boil rice vermicelli 3 to 5 minutes, or until al-dente, and drain.\n\nStep 2:\nFill a large bowl with warm water. Dip one wrapper into the hot water for 1 second to soften. Lay wrapper flat. In a row across the center, place 2 shrimp halves, a handful of vermicelli, basil, mint, cilantro and lettuce, leaving about 2 inches uncovered on each side. Fold uncovered sides inward, then tightly roll the wrapper, beginning at the end with the lettuce. Repeat with remaining ingredients.\n\nStep 3:\nIn a small bowl, mix the fish sauce, water, lime juice, garlic, sugar and chili sauce.\n\nStep 4:\nIn another small bowl, mix the Hoisin sauce and peanuts.Serve rolled spring rolls with the fish sauce and hoisin sauce mixtures.");
        db.insert(RECIPES_TABLE_NAME, null, contentValues);
    }

    public void insertThailandCuisine() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        int foodID = getNextFoodID();
        contentValues.put("FoodID",foodID);
        contentValues.put("Name","Thai Fish Cake");
        contentValues.put("Category","Thailand");
        contentValues.put("Image",R.drawable.thai_fish_cake);
        contentValues.put("Description","Deep fried fish marinated in lemongrass, spices, lime, and curry paste.");
        contentValues.put("Servings","4 People");
        contentValues.put("PrepareTime","20 Minutes");
        contentValues.put("CookTime","10 Minutes");
        contentValues.put("Ingredient","\u2022 300g White fist fillets, chopped\n\u2022 2 cloves chopped garlic\n\u2022 5cm ginger, chopped\n\u2022 1 stalk lemon grass\n\u2022 3 spring onions\n\u2022 1 red chili\n\u2022 Coriander\n\u2022 1 tablespoon groundnut oil\n\u2022 3 tablespoons fish sauce\n\u2022 1/2 tablespoons salt\n\u2022 1 lime zest\n\u2022 1 tablespoon sugar\n\u2022 1 egg lightly beaten");
        contentValues.put("Direction","Step 1:\nPut garlic, ginger, lemongrass, spring onion, coriander, and tablespoon of oil into a food processor. Pulse until it is well chopped up.\n\nStep 2:\nAdd fish, fish sauce, salt, lime zest, sugar, and egg, and whizz until it forms a smooth paste. Scoop out into a bowl and, using your hands, pick up the mixture and repeatedly through it against the side of the bowl. Do this for 3-4 minutes. Chill the mixture for 15 minutes.\n\nStep 3:\nShape into little patties and shallow fry for a few minutes on each side until golden brown and cooked through.");
        db.insert(RECIPES_TABLE_NAME, null, contentValues);

        foodID = getNextFoodID();
        contentValues.put("FoodID",foodID);
        contentValues.put("Name","Thai Green Curry");
        contentValues.put("Category","Thailand");
        contentValues.put("Image",R.drawable.thai_green_curry);
        contentValues.put("Description","Choice of dish with green curry sauce, coconut milk, long bean, tomato, and Thai basil.");
        contentValues.put("Servings","6 People");
        contentValues.put("PrepareTime","5-10 Minutes");
        contentValues.put("CookTime","25-30 Minutes");
        contentValues.put("Ingredient","\u2022 225g potatoes, cut into chunks\n\u2022 100g green beans\n\u2022 1 tablespoon vegetable oil\n\u2022 1 clove garlic, chopped\n\u2022 4 tablespoon Thai green curry\n\u2022 400ml coconut milk\n\u2022 2 tablespoon Thai fish sauce\n\u2022 1 tablespoon sugar\n\u2022 450g boneless chicken\n\u2022 Basil leaves\n\u2022 3 wide strips lime zest");
        contentValues.put("Direction","Step 1:\nPut the potatoes in a pan of boiling water and cook for 5 minutes. Throw in the beans and cook for a further 3 minutes, by which time both should be just tender but not too soft. Drain and put to one side.\n\nStep 2:\nIn a wok or large frying pan, heat the oil until very hot, then drop in the garlic and cook until golden, this should take only a few seconds. Don’t let it go very dark or it will spoil the taste. Spoon in the curry paste and stir it around for a few seconds to begin to cook the spices and release all the flavours. Next, pour in the coconut milk and let it come to a bubble.\n\nStep 3:\nStir in the fish sauce and sugar, then the pieces of chicken. Turn the heat down to a simmer and cook, covered, for about 8 minutes until the chicken is cooked.\n\nStep 4:\nTip in the potatoes and beans and let them warm through in the hot coconut milk, then add a lovely citrus flavour by stirring in the shredded lime leaves (or lime zest). The basil leaves go in next, but only leave them briefly on the heat or they will quickly lose their brightness. Scatter with the lime garnish and serve immediately with boiled rice.");
        db.insert(RECIPES_TABLE_NAME, null, contentValues);

        foodID = getNextFoodID();
        contentValues.put("FoodID",foodID);
        contentValues.put("Name","Thai Tom Yum");
        contentValues.put("Category","Thailand");
        contentValues.put("Image",R.drawable.thai_tom_yum);
        contentValues.put("Description","Choice of dish in hot and sour soup broth with lemongrass, onion, tomato, chillies, lime, and coriander leaves.");
        contentValues.put("Servings","4 People");
        contentValues.put("PrepareTime","10 Minutes");
        contentValues.put("CookTime","30-60 Minutes");
        contentValues.put("Ingredient","\u2022 1 litre chicken stock\n\u2022 300ml water\n\u2022 6 sticks lemongrass\n\u2022 4 fresh coriander roots\n\u2022 110g fresh galangal\n\u2022 8 tomatoes\n\u2022 6 kaffir lime leaves\n\u2022 1-2 limes, juice only\n\u2022 75ml tamarind water\n\u2022 3 red chilies\n\u2022 75ml fish sauce\n\u2022 75g palm sugar\n\u2022 12 raw tiger prawns\n\u2022 2 boneless skinless chicken breast");
        contentValues.put("Direction","Step 1:\nPlace the stock and water into a large pan over a high heat and bring to the boil.\n\nStep 2:\nAdd the lemongrass, coriander roots, galangal, tomatoes, lime leaves, lime juice, tamarind water and red chillies. Return to the boil, then reduce the heat and simmer for 15-20 minutes.\n\nStep 3:\nTaste the stock and add as much fish sauce and palm sugar as necessary to keep the salty-sour-hot-sweet taste, then remove from the heat.\n\nStep 4:\nTransfer 220ml/8fl oz of the stock into a separate pan over a high heat and bring to the boil. Add the chicken and cook for 1-2 minutes, then add the prawns and cook for a further 1-2 minutes, or until completely cooked through.\n\nStep 5:\nTo serve, pour the soup into two bowls and top up with the hot stock. Garnish with Thai basil, coriander and a wedge of lime.");
        db.insert(RECIPES_TABLE_NAME, null, contentValues);
    }

    public void insertMalaysiaCuisine() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        int foodID = getNextFoodID();
        contentValues.put("FoodID",foodID);
        contentValues.put("Name","Malaysian Curry Chicken");
        contentValues.put("Category","Malaysia");
        contentValues.put("Image",R.drawable.malaysian_curry_chicken);
        contentValues.put("Description","Spicy chicken in thick coconut curry sauce with lemon grass and chillies");
        contentValues.put("Servings","4-6 People");
        contentValues.put("PrepareTime","15 Minutes");
        contentValues.put("CookTime","30-45 Minutes");
        contentValues.put("Ingredient","\u2022 2 tablespoons oil\n\u2022 1/2 onion, diced\n\u2022 25g curry powder for meat\n\u2022 1 1/2lbs. Chicken, chopped\n\u2022 3 cups water\n\u2022 1 big tomato, cut into wedges, optional\n\u2022 2 small potatoes, peeled, cut into wedges\n\u2022 1/2 cup coconut milk\n\u2022 Salt to taste");
        contentValues.put("Direction","Step 1:\nAdd the oil to a big pot and heat it up until hot.\n\nStep 2:\nAdd the onions and stir-fry until aromatic before adding the curry powder. Do a few quick stirs until you smell the aroma, then add the chicken, stir to combine well, for about 1 minute.\n\nStep 3:\nAdd the water into the pot and bring it to boil.\n\nStep 4:\nLower the heat and add the tomatoes and potatoes. Cover the pot and let simmer for about 30-45 minutes, or until chicken becomes tender.\n\nStep 5:\nAdd the coconut milk and salt to taste and simmer for another 5 minutes or so. Dish out and serve immediately with steamed rice.");
        db.insert(RECIPES_TABLE_NAME, null, contentValues);

        foodID = getNextFoodID();
        contentValues.put("FoodID",foodID);
        contentValues.put("Name","Malaysia Tamarind Prawns");
        contentValues.put("Category","Malaysia");
        contentValues.put("Image",R.drawable.malaysia_assam_prawns);
        contentValues.put("Description","Malaysia Tamarind Prawns or also known as Assam-Prawns is a Malaysia-Nyonya recipe.");
        contentValues.put("Servings","3-4 People");
        contentValues.put("PrepareTime","15-20 Minutes");
        contentValues.put("CookTime","10-15 Minutes");
        contentValues.put("Ingredient","\u2022 300g white prawns\n\u2022 1 1/2 tablespoons tamarind pulp\n\u2022 4 tablespoons water\n\u2022 1 tablespoons sugar\n\u2022 1/4 tablespoons salt\n\u2022 3 tablespoons cooking oil");
        contentValues.put("Direction","Step 1:\nMix the tamarind pulp with 4 tablespoons water. Extract the juice from the tamarind by pressing the pulp.\n\nStep 2:\nRemove the heads of the prawns and remove vein of the prawns by slitting the back. Rinse prawns with water and pat dry with paper towers.\n\nStep 3:\nAdd the tamarind juice and pulp, salt, and sugar into the prawns and mix well with your hand. Marinate for 15 minutes. Remove the tamarind pulp before cooking.\n\nStep 4:\nHeat up a wok and add cooking oil. As soon as it's heated, drop the prawns into the wok and pan fry until cooked and slightly burnt. Dish out and serve immediately.");
        db.insert(RECIPES_TABLE_NAME, null, contentValues);

        foodID = getNextFoodID();
        contentValues.put("FoodID",foodID);
        contentValues.put("Name","Bean Sprout with Salted Fish");
        contentValues.put("Category","Malaysia");
        contentValues.put("Image",R.drawable.malaysia_bean_sprout_with_salted_fish);
        contentValues.put("Description","Stir Fried bean sprout, salted fish, and garlic.");
        contentValues.put("Servings","2-3 People");
        contentValues.put("PrepareTime","5 Minutes");
        contentValues.put("CookTime","5-10 Minutes");
        contentValues.put("Ingredient","\u2022 Bean Sprouts\n\u2022 Salted Fish cut into small pieces\n\u2022 3 cloves of garlic, chopped\n\u2022 2 stalks of scallions, chopped\n\u2022 Soy sauce, to taste\n\u2022 Oyster Sauce, to taste");
        contentValues.put("Direction","Step 1:\nRinse and clean the bean sprouts and remove the roots.\n\nStep 2:\nHeat the wok with cooking oil and stir fry the chopped garlic.\n\nStep 3:\nAdd in salted fish pieces and toasted until they become fragrant.\n\nStep 4:\nAdd in bean sprouts, soy sauce, oyster sauce, and chopped scallion. Quickly stir the ingredients a few times and serve hot.");
        db.insert(RECIPES_TABLE_NAME, null, contentValues);
    }

    //Get Cuisine of selected Category
    /*****************************************************
     * Title: Android - SQLite Database
     * Author: tutorialspoint
     * Site owner/sponsor: tutorialspoint.com
     * Date: Unknown
     * Availability: https://www.tutorialspoint.com/android/android_sqlite_database.htm (Accessed 11 April 2017)
     * Modified: Used as a references
     * *****************************************************/
    public ArrayList<Recipes> getSelectedCategory(String category) {
        ArrayList<Recipes> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Recipes WHERE Category = '" + category + "' ORDER BY FoodID",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            Recipes recipes = new Recipes();
            recipes.setFoodID(Integer.parseInt(cursor.getString(cursor.getColumnIndex(DB_Recipes.RECIPES_COLUMN_FOOD_ID))));
            recipes.setName(cursor.getString(cursor.getColumnIndex(DB_Recipes.RECIPES_COLUMN_NAME)));
            recipes.setCategory(cursor.getString(cursor.getColumnIndex(DB_Recipes.RECIPES_COLUMN_CATEGORY)));
            recipes.setImage(cursor.getInt(cursor.getColumnIndex(DB_Recipes.RECIPES_COLUMN_IMAGE)));
            recipes.setDescription(cursor.getString(cursor.getColumnIndex(DB_Recipes.RECIPES_COLUMN_DESCRIPTION)));
            recipes.setServings(cursor.getString(cursor.getColumnIndex(DB_Recipes.RECIPES_COLUMN_SERVING)));
            recipes.setPrepareTime(cursor.getString(cursor.getColumnIndex(DB_Recipes.RECIPES_COLUMN_PREPARE_TIME)));
            recipes.setCookTime(cursor.getString(cursor.getColumnIndex(DB_Recipes.RECIPES_COLUMN_COOK_TIME)));
            recipes.setIngredient(cursor.getString(cursor.getColumnIndex(DB_Recipes.RECIPES_COLUMN_INGREDIENT)));
            recipes.setDirection(cursor.getString(cursor.getColumnIndex(DB_Recipes.RECIPES_COLUMN_DIRECTION)));
            arrayList.add(recipes);
            cursor.moveToNext();
        }
        //Check if Array List is empty
        if(arrayList.size() == 0)
            return null;
        else
            return arrayList;
    }

    public ArrayList<Recipes> getSearchRecipes(String category, String key) {
        ArrayList<Recipes> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Recipes WHERE Category = '" + category + "' AND Name LIKE '%" + key + "%' ORDER BY FoodID",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            Recipes recipes = new Recipes();
            recipes.setFoodID(Integer.parseInt(cursor.getString(cursor.getColumnIndex(DB_Recipes.RECIPES_COLUMN_FOOD_ID))));
            recipes.setName(cursor.getString(cursor.getColumnIndex(DB_Recipes.RECIPES_COLUMN_NAME)));
            recipes.setCategory(cursor.getString(cursor.getColumnIndex(DB_Recipes.RECIPES_COLUMN_CATEGORY)));
            recipes.setImage(cursor.getInt(cursor.getColumnIndex(DB_Recipes.RECIPES_COLUMN_IMAGE)));
            recipes.setDescription(cursor.getString(cursor.getColumnIndex(DB_Recipes.RECIPES_COLUMN_DESCRIPTION)));
            recipes.setServings(cursor.getString(cursor.getColumnIndex(DB_Recipes.RECIPES_COLUMN_SERVING)));
            recipes.setPrepareTime(cursor.getString(cursor.getColumnIndex(DB_Recipes.RECIPES_COLUMN_PREPARE_TIME)));
            recipes.setCookTime(cursor.getString(cursor.getColumnIndex(DB_Recipes.RECIPES_COLUMN_COOK_TIME)));
            recipes.setIngredient(cursor.getString(cursor.getColumnIndex(DB_Recipes.RECIPES_COLUMN_INGREDIENT)));
            recipes.setDirection(cursor.getString(cursor.getColumnIndex(DB_Recipes.RECIPES_COLUMN_DIRECTION)));
            arrayList.add(recipes);
            cursor.moveToNext();
        }
        return arrayList;
    }


    //Get Number of Rows
    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, RECIPES_TABLE_NAME);
        return numRows;
    }

    //Get the next FoodID
    private int getNextFoodID() {
        int nextFoodID = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        String strSQL = "SELECT MAX(FoodID) FROM " + RECIPES_TABLE_NAME;
        Cursor cursor = db.rawQuery(strSQL,null);
        if(cursor.moveToFirst()) {
            do {
                nextFoodID = cursor.getInt(0) + 1;
            } while(cursor.moveToNext());
        }
        return nextFoodID;
    }

    //Delete Data
    public void removeAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + RECIPES_TABLE_NAME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS recipes");
        onCreate(db);
    }
}
