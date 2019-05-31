package yeongdejong.com.assamhouse;

import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by T00185309 - Yeong De Jong on 16/04/2017.
 */

/*****************************************************
 * Title: Android Custom ListView with Images and Text - Example
 * Author: Raj Amal
 * Site owner/sponsor: learn2crack.com
 * Date: October 29, 2013
 * Availability: https://www.learn2crack.com/2013/10/android-custom-listview-images-text-example.html (Accessed 16 April 2017)
 * Modified: Identifiers rename
 * *****************************************************/
public class CustomListViewAdapter extends ArrayAdapter<Recipes> {
    Context context;

    public CustomListViewAdapter(Context context, int resource, List<Recipes> recipes) {
        super(context, resource, recipes);
        this.context = context;
    }

    //Private class holder class
    private class ViewHolder {
        ImageView imageView;
        TextView textView;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Recipes recipes = getItem(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.custom_listview, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.cuisineImage);
            holder.textView = (TextView) convertView.findViewById(R.id.cuisineName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imageView.setImageResource(recipes.getImage());
        holder.textView.setText(recipes.getName());

        return convertView;
    }
}
/** End of [ non-original or refactor ] code **/
