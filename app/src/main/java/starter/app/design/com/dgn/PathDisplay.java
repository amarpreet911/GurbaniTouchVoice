package starter.app.design.com.dgn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by amarpreet911 on path_12/07/16.
 */
public class PathDisplay extends Activity {
    String presentTuk;
    private BufferedReader br;
    private PathDispArrAdap pathDispListArrAdap;
    private int angCounter = 0;
    private int pathContextKey; //its an integer now storing number corresponding to the tuqk selected
    private String pathContextValue, mapTwoAudio;
    private ListView pathDisplayListView;
    private String paath;
    private int lineNumb = 1, j = 4;
    int angNumb = 0;
private int angLineCountSize = 0;
    TreeMap<Integer, String> mapTPS;
    TreeMap<Integer, String> mapTPSTwo;
    private HashMap<String, Integer> angLineCount;
    private int counter = 0;
    private int temp = j;
    private int ang = 0;
    private Context context;
    private String pathPositionString;
    MediaPlayer audioPlay = null;
    ArrayList<String> pathContextKeyList;
    ArrayList<String> pathContextValList;
    private InputStream ins;
    int listTwoCounter = 0, listOneCounter = 0;
    Typeface strokeTypeFace;
    int idNumb;
    Intent intent;
    TextView  baniTextDisp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.path_display);
        intent = getIntent();
       // Typeface strokeTypeFace =Typeface.createFromAsset(getAssets(), "fff_tusj.ttf");
        context = getApplicationContext();
        pathPositionString = intent.getStringExtra("PathPositionString");
        System.out.println("have reached the path display class");
        initializePath();
        populatePathList();
      //BaniTextView  baniTextDisp = (BaniTextView) findViewById(R.id.txtPathDispRowId);
        TextView  baniTextDisp;
    }


    void initializePath() {
        try {
            System.out.println("the string value is "+pathPositionString);
            mapTPS = new TreeMap<>();
            mapTPSTwo = new TreeMap<>();
           /* angLineCount = new HashMap<>();
            angLineCount.put("ang_1", 10);
            angLineCount.put("ang_2", 8);
            angLineCount.put("ang_3", 13);
            angLineCount.put("ang_4", 11);
            angLineCount.put("ang_5", 10);*/
            if(pathPositionString.equals("Tav Prasad Savaiye")) {
                System.out.println("we are in Tav Prasad Savaiye sahib path");
                angLineCountSize = 4;
                 ins = getResources().openRawResource(
                        getResources().getIdentifier("punjabi_tav_prasad_savaiye",
                                "raw", getPackageName()));
                br = new BufferedReader(new InputStreamReader(ins));
                paath =  "TavPrasadSavaiye";
            }
           else if(pathPositionString.equals("Kirtan Sohila")){
                System.out.println("we are in Kirtan Sohila sahib path");
                 ins = getResources().openRawResource(
                        getResources().getIdentifier("punjabi_kirtan_sohila",
                                "raw", getPackageName()));
                br = new BufferedReader(new InputStreamReader(ins));
                paath = "KirtanSohila";
            }
            /*br = new BufferedReader(new FileReader("/path_folder/punjabi_tav_prasad_savaiye"));*/
            while ((presentTuk = br.readLine()) != null) {
            listOneCounter++;
            System.out.println("the counter is "+listOneCounter+" & present tuk is "+presentTuk);
                mapTPS.put(listOneCounter, presentTuk);
            }
          //  int mapSize = mapTPS.size();

for(int run = 1; run <= mapTPS.size(); run++){

                counter ++;  //counter should start from 1
                /*mapTPS.put(presentTuk, "path_"+ang + i);*/ //00,01,02,03
                listTwoCounter++;
    System.out.println("in list counter 2 ang is " + ang + " and line numb is " + lineNumb);
    System.out.println("listTwoCounter is "+listTwoCounter+" ang is "+ang+" line numb is "+lineNumb+"and and lien numb is "+ang+lineNumb);
                mapTPSTwo.put(listTwoCounter, "path_" + ang + lineNumb);
               if(paath.equals("KirtanSohila")){
                   if (ang ==0){
                   //    ang++;
                   angLineCountSize = 4;}
                    else if(ang == 1){
                       angLineCountSize = 10;
                   }
                   else if(ang == 2){
                       angLineCountSize = 8;
                   }
                   else if(ang == 3){
                       angLineCountSize = 13;
                   }
                   else if(ang == 4){
                       angLineCountSize = 11;
                   }
                   else if(ang == 5){
                       angLineCountSize = 10;
                   }
               }
//put a check on counter too
               if((counter <= angLineCountSize) && (paath.equals("KirtanSohila"))){
                    lineNumb++;//lineNumb starts from 1
                    System.out.println("Entered complex KS");
                    /*if (lineNumb  > angLineCountSize){
                      ang = ang +1; //ang should start from 0
                        lineNumb = 1;
                        counter = 0;//newly added
                    }*/
                }
    else if((counter > angLineCountSize) && (paath.equals("KirtanSohila"))){
                   ang = ang +1; //ang should start from 0
                   lineNumb = 1;
                   counter = 0;
               }

//01 01 01 01 02 03.....then corrected
                if ((counter > j) && (counter < j+5) && (paath.equals("TavPrasadSavaiye"))) {
                  //  mapTPS.put(presentTuk, "path_"+ang + i);
                    lineNumb++;
                    j++;
                    if (lineNumb > angLineCountSize){
                        j = temp + angLineCountSize;
                        ang = ang +1;
                        lineNumb = 1;
                        temp = temp + angLineCountSize;
                    }
                }
                System.out.println("the current line is "+presentTuk);
                System.out.println("the ang part is "+presentTuk+ang+lineNumb);
            }
        } catch (Exception e) {
            System.out.println("exception occurred" +e);
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    void populatePathList(){
       // pathContextKeyList = new ArrayList<String>(mapTPS.keySet());
        pathContextValList = new ArrayList<String>(mapTPS.values());
        pathDisplayListView = (ListView) findViewById(R.id.pathDisplayList);

        pathDispListArrAdap = new PathDispArrAdap(this, pathContextValList);
        /*pathDispListArrAdap = new PathDispArrAdap(this, pathContextKeyList);*/
        pathDisplayListView.setAdapter(pathDispListArrAdap);



       /* baniTextDisp = (TextView) findViewById(R.id.txtPathDispRowId);
        strokeTypeFace =Typeface.createFromAsset(getAssets(), "fff_tusj.ttf");
System.out.println("here comes the val:::::::::::::::: "+strokeTypeFace );
       //below is null
        System.out.println("here comes the val of banitextdisp::::::::::::::: "+baniTextDisp );
        baniTextDisp.setTypeface(strokeTypeFace);*/


        pathDisplayListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(audioPlay != null){//.isPlaying()) {
    audioPlay.stop(); //if some other item is clicked
}
                System.out.println("position clicked at is " + position);

                pathContextValue =(String) (pathDisplayListView.getItemAtPosition(position));
try {
    Resources res = getResources();
    System.out.println("the value clicked is " + pathContextValue );//pathContextValue

    for (Map.Entry<Integer, String> entry : mapTPS.entrySet()) {
        if (entry.getValue().equals(pathContextValue)) {
            System.out.println("the key is "+entry.getKey());
           // String path = "path_";
            pathContextKey = entry.getKey();
            System.out.println("The path context key is "+pathContextKey );
        }
    }
    //gives the value for teh pathContextKey which is the value of treemap2 i.e audio value which will be searched next
    mapTwoAudio = mapTPSTwo.get(pathContextKey); //path00 for the first line//path 02x generated evn after clicking 6th line

     idNumb = context.getResources().getIdentifier(mapTwoAudio, "raw", getPackageName()); //pathContextValue //the key for this val should come
    // = MediaPlayer.create(this, R.raw.alert);
    audioPlay = MediaPlayer.create(context, idNumb);
    audioPlay.start();
    audioPlay.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            mp.stop();
        }
    });

}catch(Exception e){
    System.out.println("The exception in listner at pathdisplay is "+e);
    e.printStackTrace();
}


            }
        });
}

    @Override
    public void onBackPressed() {
if(audioPlay!=null)
     audioPlay.stop();
        goToBackScreen();
    }
    void goToBackScreen(){
        intent = new Intent(PathDisplay.this, HomePage.class);
        startActivity(intent);
        finish();
    }
}
