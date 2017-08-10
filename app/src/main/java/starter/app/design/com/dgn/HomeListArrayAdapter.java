package starter.app.design.com.dgn;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amarpreet911 on path_11/07/16.
 */
public class HomeListArrayAdapter extends ArrayAdapter<String> {

    Context context;
    ArrayList pathList;
    Typeface strokeTypeFace;
    public HomeListArrayAdapter(Context context, List pathList) {
        super(context, R.layout.home_list_row, pathList);
        this.context =  context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater listInflator = LayoutInflater.from(getContext());
        View listHomePath = listInflator.inflate(R.layout.home_list_row, parent, false);
       String textPosition = getItem(position);
        TextView listText = (TextView) listHomePath.findViewById(R.id.txtHomeRowId);
        listText.setText(textPosition);

        strokeTypeFace = Typeface.createFromAsset(getContext().getAssets(), "fonts/seasrn_1.ttf");

        listText.setTypeface(strokeTypeFace);
//listText.setTextColor(#ffc300);

        return listHomePath;
    }
}
