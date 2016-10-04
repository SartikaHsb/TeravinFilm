package util;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.ArrayList;
import java.util.Arrays;

import database.dbTeravin;

/**
 * Created by sartikahasibuan on 9/28/2016.
 */
public class utilTeravin {

    protected Context context;
    private  static utilTeravin utilTeravin_;
    private static dbTeravin db;

    /*
    * Check First Time Launch
    * */
    private static SharedPreferences pref;
    private static SharedPreferences.Editor editor;
    private static int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "Teravin";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public static boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    protected utilTeravin(Context context) {
        this.context = context;
    }

    public static utilTeravin getInstance(Context context) {
        if(utilTeravin_ == null) {
            utilTeravin_ = new utilTeravin(context.getApplicationContext());
            pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
            editor = pref.edit();
            //check wheter the app is closed and re-open again
            if(!isFirstTimeLaunch()){

            }else{
                //initialize database
                db = new dbTeravin(context);
                //flag first launch
                editor.putBoolean(IS_FIRST_TIME_LAUNCH, true);
                editor.commit();
            }

        }
        return utilTeravin_;
    }


    /*
    * Check Conectivity
    * */
    public boolean isInternetAvailable() {
        ConnectivityManager manager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkinfo = manager.getActiveNetworkInfo();
        return networkinfo!=null && networkinfo.isConnected();
    }

    //convert arraylist into String
    public String ConvertArrayListToString(ArrayList<?> arr){
        String result="";
        for(int i=0;i<arr.size();i++){
            result +=""+arr.get(i)+",";
        }
        return result;
    }

    //save to local database
    public void savetoLocalDB(String ADULT,String BACKDROPPATH,String BELONGSTOCOLLECTION,String HOMEPAGE,
                              String ID,String IMDB_ID,String ORIGINALLANGUAGE,String ORIGINALTITLE,String OVERVIEW,String POPULARITY,
                              String POSTERPATH,String RELEASEDATE,String REVENUE,
                              String RUNTIME,String STATUS,String TAGLINE,String TITLE,String VIDEO,String VOTEAVERAGE,
                              String VOTECOUNT){

        db.InsertMovies( ADULT, BACKDROPPATH, BELONGSTOCOLLECTION, HOMEPAGE,
                ID, IMDB_ID, ORIGINALLANGUAGE, ORIGINALTITLE, OVERVIEW, POPULARITY,
                POSTERPATH, RELEASEDATE, REVENUE,
                RUNTIME, STATUS, TAGLINE, TITLE, VIDEO, VOTEAVERAGE,
                VOTECOUNT);
    }



}
