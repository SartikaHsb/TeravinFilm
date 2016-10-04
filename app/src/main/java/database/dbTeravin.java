package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import model.Movies;

/**
 * Created by sartikahasibuan on 9/27/2016.
 */
public class dbTeravin extends SQLiteOpenHelper {
    private static final String DEBUG_TAG = "DatabaseTeravin";
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "DatabaseTeravin";

    /*Table Book*/
    public static final String TABLE_MOVIE = "TABLE_MOVIE";
    public static final String ADULT = "ADULT";
    public static final String BACKDROPPATH = "BACKDROPPATH";
    public static final String BELONGSTOCOLLECTION = "BELONGSTOCOLLECTION";
    public static final String BUDGET = "BUDGET";
    //public static final String GENRES = "GENRES";
    public static final String HOMEPAGE = "HOMEPAGE";
    public static final String ID = "ID";
    public static final String IMDB_ID = "IMDB_ID";
    public static final String ORIGINALLANGUAGE = "ORIGINALLANGUAGE";
    public static final String ORIGINALTITLE = "ORIGINALTITLE";
    public static final String OVERVIEW = "OVERVIEW";
    public static final String POPULARITY = "POPULARITY";
    public static final String POSTERPATH = "POSTERPATH";
    //public static final String PRODUCTIONCOMPANIES = "PRODUCTIONCOMPANIES";
    //public static final String PRODUCTIONCOUNTRIES = "PRODUCTIONCOUNTRIES";
    public static final String RELEASEDATE = "RELEASEDATE";
    public static final String REVENUE = "REVENUE";
    public static final String RUNTIME = "RUNTIME";
    //public static final String SPOKENLANGUAGES = "SPOKENLANGUAGES";
    public static final String STATUS = "STATUS";
    public static final String TAGLINE = "TAGLINE";
    public static final String TITLE = "TITLE";
    public static final String VIDEO = "VIDEO";
    public static final String VOTEAVERAGE = "VOTEAVERAGE";
    public static final String VOTECOUNT = "VOTECOUNT";

    private static final String CREATE_TABLE_MOVIE = "create table " + TABLE_MOVIE
            + " (" + ADULT + " text , "
                    + BACKDROPPATH + " text , "
                    + BELONGSTOCOLLECTION + " text , "
                    + BUDGET + " text , "
                   // + GENRES + " text , "
                    + HOMEPAGE + " text , "
                    + ID + " text primary key, "
                    + IMDB_ID + " text , "
                    + ORIGINALLANGUAGE + " text , "
                    + ORIGINALTITLE + " text , "
                    + OVERVIEW + " text , "
                    + POPULARITY + " text , "
                    + POSTERPATH + " text , "
                   // + PRODUCTIONCOMPANIES + " text , "
                   // + PRODUCTIONCOUNTRIES + " text , "
                    + RELEASEDATE + " text , "
                    + REVENUE + " text , "
                    + RUNTIME + " text , "
                   // + SPOKENLANGUAGES + " text , "
                    + STATUS + " text , "
                    + TAGLINE + " text , "
                    + TITLE + " text , "
                    + VIDEO + " text , "
                    + VOTEAVERAGE + " text , "
                    + VOTECOUNT + " text  );";

    public dbTeravin(Context context) {

        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(CREATE_TABLE_MOVIE);
            Log.d("dbTeravin","Yes");

            /******************************DUMMY DATA*********************************************/
            ContentValues values = new ContentValues();
           /* try
            {
                db.beginTransaction();

                values.put(ADULT, 1);
                values.put(BACKDROPPATH, "");
                values.put(BELONGSTOCOLLECTION, "Summary Buku Ajaib");
                values.put(BUDGET, "1");
               // values.put(GENRES, "1");
                values.put(HOMEPAGE, "10/07/2016");
                values.put(ID, "10/07/2016");
                values.put(IMDB_ID, "RM 0.0");
                values.put(ORIGINALLANGUAGE, 1);
                values.put(ORIGINALTITLE, "Buku Ajaib");
                values.put(OVERVIEW, "Summary Buku Ajaib");
                values.put(POPULARITY, "1");
                values.put(POSTERPATH, "1");
               // values.put(PRODUCTIONCOMPANIES, "10/07/2016");
               // values.put(PRODUCTIONCOUNTRIES, "10/07/2016");
                values.put(RELEASEDATE, "RM 0.0");
                values.put(REVENUE, "Summary Buku Ajaib");
                values.put(RUNTIME, "1");
                values.put(SPOKENLANGUAGES, "1");
                values.put(STATUS, "10/07/2016");
                values.put(TAGLINE, "10/07/2016");
                values.put(TITLE, "RM 0.0");
                values.put(VIDEO, "10/07/2016");
                values.put(VOTEAVERAGE, "10/07/2016");
                values.put(VOTECOUNT, "RM 0.0");

                db.insert(TABLE_MOVIE, null, values);


                db.endTransaction();
                Log.d("sucess","Sucess create table movie");
            }catch (Exception e){
                Log.e(" Insert Dummy Exception",Log.getStackTraceString(e));
            }*/

        }catch (SQLException se) {
            Log.e(" Oncreate SQLException",Log.getStackTraceString(se));
        } catch (Exception e) {
            Log.e(" Oncreate Exception",Log.getStackTraceString(e));
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DEBUG_TAG, "Upgrading database. Existing contents will be lost. ["
                + oldVersion + "]->[" + newVersion + "]");
        db.execSQL("DROP TABLE IF EXISTS" + CREATE_TABLE_MOVIE);
        onCreate(db);

    }
    public void InsertMovies(String ADULT,String BACKDROPPATH,String BELONGSTOCOLLECTION,String HOMEPAGE,
                             String ID,String IMDB_ID,String ORIGINALLANGUAGE,String ORIGINALTITLE,String OVERVIEW,String POPULARITY,
                             String POSTERPATH,String RELEASEDATE,String REVENUE,
                             String RUNTIME,String STATUS,String TAGLINE,String TITLE,String VIDEO,String VOTEAVERAGE,
                             String VOTECOUNT) {

        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put(this.ADULT , ADULT);
            values.put(this.BACKDROPPATH , BACKDROPPATH);
            values.put(this.BELONGSTOCOLLECTION , BELONGSTOCOLLECTION);
            values.put( this.BUDGET,BUDGET );
            //values.put(this.GENRES ,GENRES );
            values.put( this.HOMEPAGE,HOMEPAGE );
            values.put( this.ID, ID);
            values.put(this.IMDB_ID , IMDB_ID);
            values.put( this.ORIGINALLANGUAGE,ORIGINALLANGUAGE );
            values.put(this. ORIGINALTITLE,ORIGINALTITLE );
            values.put( this.OVERVIEW, OVERVIEW);
            values.put( this.POPULARITY,POPULARITY );
            values.put( this.POSTERPATH, POSTERPATH);
            //values.put(this.PRODUCTIONCOMPANIES ,PRODUCTIONCOMPANIES );
            //values.put( this.PRODUCTIONCOUNTRIES,PRODUCTIONCOUNTRIES );
            values.put(this. RELEASEDATE,RELEASEDATE );
            values.put(this.REVENUE ,REVENUE );
            values.put( this.RUNTIME,RUNTIME );
            //values.put(this. SPOKENLANGUAGES, SPOKENLANGUAGES);
            values.put( this.STATUS,STATUS );
            values.put(this. TAGLINE, TAGLINE);
            values.put( this.TITLE, TITLE);
            values.put( this.VIDEO, VIDEO);
            values.put(this.VOTEAVERAGE ,VOTEAVERAGE );
            values.put(this.VOTECOUNT ,VOTECOUNT );
            db.insert(TABLE_MOVIE, null, values);

            Log.d("Success","Save data to database");
            db.close();
        }
        catch (SQLiteException se) {
            Log.v("Exception Db Teravin",Log.getStackTraceString(se));
        } catch (Exception e) {
            Log.v("Exception Db Teravi",Log.getStackTraceString(e));
        } finally {
            db.close();
        }
    }

    public ArrayList<Movies> GellAllMovies() {
        ArrayList<Movies> allData = new ArrayList<Movies>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        try{

            cursor = db.query(TABLE_MOVIE , new String[] {
                    ADULT ,BACKDROPPATH , BELONGSTOCOLLECTION,BUDGET, HOMEPAGE ,ID,IMDB_ID,
                    ORIGINALLANGUAGE,ORIGINALTITLE,OVERVIEW,POPULARITY,POSTERPATH,RELEASEDATE,REVENUE,RUNTIME,STATUS,TAGLINE,
                    TITLE,VIDEO,VOTEAVERAGE,VOTECOUNT }, null, null, null, null, null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {

                allData.add(parseDataMovie(cursor));
                cursor.moveToNext();
            }
            cursor.close();
        }catch (SQLiteException se) {
            Log.e("Failed",Log.getStackTraceString(se));
        } catch (Exception e) {
            Log.e("Failed",Log.getStackTraceString(e));
        } finally {
            db.close();
        }
        return allData;
    }

    private Movies parseDataMovie(Cursor cursor) {
        Movies curData = new Movies();
        curData.setAdult(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(ADULT))));
        curData.setBackdropPath(cursor.getString(cursor.getColumnIndex(BACKDROPPATH)));
        curData.setBelongsToCollection(cursor.getString(cursor.getColumnIndex(BELONGSTOCOLLECTION)));
        curData.setBudget(Integer.parseInt(cursor.getString(cursor.getColumnIndex(BUDGET))));
        //curData.setGenres(cursor.getString(cursor.getColumnIndex(GENRES)));
        curData.setHomepage(cursor.getString(cursor.getColumnIndex(HOMEPAGE)));
        curData.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID))));
        curData.setImdbId(cursor.getString(cursor.getColumnIndex(IMDB_ID)));
        curData.setOriginalLanguage(cursor.getString(cursor.getColumnIndex(ORIGINALLANGUAGE)));
        curData.setOriginalTitle(cursor.getString(cursor.getColumnIndex(ORIGINALTITLE)));
        curData.setOverview(cursor.getString(cursor.getColumnIndex(OVERVIEW)));
        curData.setPopularity(Double.parseDouble(cursor.getString(cursor.getColumnIndex(POPULARITY))));
        curData.setPosterPath(cursor.getString(cursor.getColumnIndex(POSTERPATH)));
        //curData.setProductionCompanies(cursor.getString(cursor.getColumnIndex(PRODUCTIONCOMPANIES)));
       // curData.setProductionCountries(cursor.getString(cursor.getColumnIndex(PRODUCTIONCOUNTRIES)));
        curData.setReleaseDate(cursor.getString(cursor.getColumnIndex(RELEASEDATE)));
        curData.setRevenue(Integer.parseInt(cursor.getString(cursor.getColumnIndex(REVENUE))));
        curData.setRuntime(Integer.parseInt(cursor.getString(cursor.getColumnIndex(RUNTIME))));
        //curData.setSpokenLanguages(cursor.getString(cursor.getColumnIndex(SPOKENLANGUAGES)));
        curData.setStatus(cursor.getString(cursor.getColumnIndex(STATUS)));
        curData.setTagline(cursor.getString(cursor.getColumnIndex(TAGLINE)));
        curData.setTitle(cursor.getString(cursor.getColumnIndex(TITLE)));
        curData.setVideo(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(VIDEO))));
        curData.setVoteAverage(Double.parseDouble(cursor.getString(cursor.getColumnIndex(VOTEAVERAGE))));
        curData.setVoteCount(Integer.parseInt(cursor.getString(cursor.getColumnIndex(VOTECOUNT))));
        return curData;
    }


}