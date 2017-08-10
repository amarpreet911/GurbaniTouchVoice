package starter.app.design.com.dgn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by amarpreet911 on path_11/07/16.
 */
public class HomePage extends Activity implements View.OnClickListener{

    private ListView homeListView;
    ArrayList<String> pathList;
    HomeListArrayAdapter homeListArrAdap;
     String pathPosition;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        populateListHome();
    }

    @Override
    public void onClick(View v) {

    }
    void populateListHome(){
        pathList = new ArrayList<String>();
        pathList.add("Tav Prasad Savaiye");
        pathList.add("Kirtan Sohila");
        homeListView = (ListView) findViewById(R.id.homeListView);

        homeListArrAdap = new HomeListArrayAdapter(this, pathList);
        homeListView.setAdapter(homeListArrAdap);
        homeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("position is "+position);
                //get the text at the position clicked
                pathPosition =(String) (homeListView.getItemAtPosition(position));
            Intent intent = new Intent(HomePage.this, PathDisplay.class);
                System.out.println("the val for path position is "+pathPosition);
            intent.putExtra("PathPositionString", pathPosition);
            startActivity(intent);
            finish();
        }
    });
    }
}