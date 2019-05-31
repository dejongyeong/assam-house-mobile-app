package yeongdejong.com.assamhouse;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by T00185309 - Yeong De Jong on 17/04/2017.
 */

/*****************************************************
 * Title: Creating Tabs in Android Studio with Tabbed
 * Author: Learn Some Thing
 * Site owner/sponsor: youtube.com
 * Date: October 21, 2016
 * Availability: https://www.youtube.com/watch?v=00LLd7qr9sA (Accessed 17 April 2017)
 * Modified: Class Modified
 * *****************************************************/
public class DescriptionTab extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.cuisine_introduction_layout, container, false);
        ImageView image = (ImageView) rootView.findViewById(R.id.cuisineImage);
        TextView category = (TextView) rootView.findViewById(R.id.textCategory);
        TextView description = (TextView) rootView.findViewById(R.id.textDescription);
        TextView servings = (TextView) rootView.findViewById(R.id.textServings);
        TextView prepareTime = (TextView) rootView.findViewById(R.id.textPrepareTime);
        TextView cookTime = (TextView) rootView.findViewById(R.id.textCookTime);

        //Setting Layout
        image.setImageResource(CuisineRecipeActivity.recipe.getImage());
        category.setText(category.getText() + " " + CuisineRecipeActivity.recipe.getCategory());
        description.setText(description.getText() + "\n" + CuisineRecipeActivity.recipe.getDescription());
        servings.setText(servings.getText() + " " + CuisineRecipeActivity.recipe.getServings());
        prepareTime.setText(prepareTime.getText() + " " + CuisineRecipeActivity.recipe.getPrepareTime());
        cookTime.setText(cookTime.getText() + " " + CuisineRecipeActivity.recipe.getCookTime());

        return rootView;
    }
}
