package yeongdejong.com.assamhouse;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by User on 17/04/2017.
 */

/*****************************************************
 * Title: Creating Tabs in Android Studio with Tabbed
 * Author: Learn Some Thing
 * Site owner/sponsor: youtube.com
 * Date: October 21, 2016
 * Availability: https://www.youtube.com/watch?v=00LLd7qr9sA (Accessed 17 April 2017)
 * Modified: Class Modified
 * *****************************************************/
public class IngredientTab extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.cuisine_ingredient_layout, container, false);
        ImageView image = (ImageView) rootView.findViewById(R.id.cuisineImage);
        TextView ingredient = (TextView) rootView.findViewById(R.id.cuisineIngredient);

        //Setting Layout
        image.setImageResource(CuisineRecipeActivity.recipe.getImage());
        ingredient.setText(CuisineRecipeActivity.recipe.getIngredient());

        return rootView;
    }
}
