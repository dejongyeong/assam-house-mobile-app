package yeongdejong.com.assamhouse;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ScrollView;

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
public class DirectionTab extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.cuisine_direction_layout, container, false);
        ImageView image = (ImageView) rootView.findViewById(R.id.cuisineImage);
        TextView direction = (TextView) rootView.findViewById(R.id.cuisineDirection);

        //Setting Layout
        image.setImageResource(CuisineRecipeActivity.recipe.getImage());
        direction.setText(CuisineRecipeActivity.recipe.getDirection());

        return rootView;
    }
}
