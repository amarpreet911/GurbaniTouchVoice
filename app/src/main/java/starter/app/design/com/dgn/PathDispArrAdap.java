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
 * Created by amarpreet911 on path_12/07/16.
 */
public class PathDispArrAdap extends ArrayAdapter<String> {
    private Context context;
    ArrayList pathContextKeyList;
    String textPosition;
    //BaniTextView listText;
    TextView listText;
    View listDisplayPath;
    Typeface strokeTypeFace;
    public PathDispArrAdap(Context context, ArrayList pathContextKeyList) {
        super(context,R.layout.path_display_row, pathContextKeyList);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater listInflator = LayoutInflater.from(getContext());
        listDisplayPath = listInflator.inflate(R.layout.path_display_row, parent, false);
        textPosition = getItem(position);
        listText = (TextView) listDisplayPath.findViewById(R.id.txtPathDispRowId);
        listText.setText(textPosition);
       /* listText = (BaniTextView) listDisplayPath.findViewById(R.id.txtPathDispRowId);*/
       // baniTextDisp = (TextView) findViewById(R.id.txtPathDispRowId);
        strokeTypeFace = Typeface.createFromAsset(getContext().getAssets(), "fonts/seasrn_1.ttf");
        System.out.println("here comes the val:::::::::::::::: "+strokeTypeFace );
        //below is null
        System.out.println("here comes the val of banitextdisp::::::::::::::: "+listText);
        listText.setTypeface(strokeTypeFace);

        return listDisplayPath;
    }
}

/*
Context context;
ArrayList pathList;
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
        return listHomePath;
    }*/
