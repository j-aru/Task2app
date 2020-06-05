package com.example.task2;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

public class DisplaySQLiteDataActivity extends AppCompatActivity {

    SQLiteHelper sqLiteHelper;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    ListAdapter listAdapter ;
    ListView LISTVIEW;

    ArrayList<String> ID_Array;
    ArrayList<String> NAME_Array;
    ArrayList<String> AGE_Array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_sqlite_data);

        LISTVIEW = (ListView) findViewById(R.id.listView1);

        ID_Array = new ArrayList<String>();

        NAME_Array = new ArrayList<String>();

        AGE_Array = new ArrayList<String>();

        sqLiteHelper = new SQLiteHelper(this);

    }

    @Override
    protected void onResume() {

        ShowSQLiteDBdata() ;

        super.onResume();
    }

    private void ShowSQLiteDBdata() {

        sqLiteDatabase = sqLiteHelper.getWritableDatabase();

        cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper.TABLE_NAME+"", null);

        ID_Array.clear();
        NAME_Array.clear();
        AGE_Array.clear();

        if (cursor.moveToFirst()) {
            do {

                ID_Array.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Column_ID)));

                NAME_Array.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Column_1_Name)));

                AGE_Array.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Column_2_Age)));


            } while (cursor.moveToNext());
        }

        listAdapter = new ListAdapter(DisplaySQLiteDataActivity.this,

                ID_Array,
                NAME_Array,
                AGE_Array
        );

        LISTVIEW.setAdapter(listAdapter);

        cursor.close();
    }
}