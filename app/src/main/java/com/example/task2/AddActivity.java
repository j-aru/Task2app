package com.example.task2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabaseObj;
    EditText editTextName, editTextAge;
    String NameHolder, AgeHolder, SQLiteDataBaseQueryHolder;
    Button EnterData;
    Boolean EditTextEmptyHold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        EnterData = (Button)findViewById(R.id.button);
        editTextName = (EditText)findViewById(R.id.editText);
        editTextAge = (EditText)findViewById(R.id.editText2);

        EnterData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                SQLiteDataBaseBuild();

                SQLiteTableBuild();

                CheckEditTextStatus();

                InsertDataIntoSQLiteDatabase();

                EmptyEditTextAfterDataInsert();


            }
        });


    }

    public void SQLiteDataBaseBuild(){

        sqLiteDatabaseObj = openOrCreateDatabase("AndroidDataBase", Context.MODE_PRIVATE, null);

    }

    public void SQLiteTableBuild(){

        sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS AndroidTable(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name VARCHAR, age VARCHAR);");

    }

    public void CheckEditTextStatus(){

        NameHolder = editTextName.getText().toString() ;
        AgeHolder = editTextAge.getText().toString();

        if(TextUtils.isEmpty(NameHolder) || TextUtils.isEmpty(AgeHolder)){

            EditTextEmptyHold = false ;

        }
        else {

            EditTextEmptyHold = true ;
        }
    }

    public void InsertDataIntoSQLiteDatabase(){

        if(EditTextEmptyHold == true)
        {

            SQLiteDataBaseQueryHolder = "INSERT INTO AndroidTable (name,age) VALUES('"+NameHolder+"', '"+AgeHolder+"');";

            sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);

            Toast.makeText(AddActivity.this,"Data Inserted Successfully", Toast.LENGTH_LONG).show();

        }
        else {

            Toast.makeText(AddActivity.this,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();

        }

    }

    public void EmptyEditTextAfterDataInsert(){

        editTextName.getText().clear();

        editTextAge.getText().clear();

    }

}