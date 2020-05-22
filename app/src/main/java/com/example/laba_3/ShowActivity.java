package com.example.laba_3;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends Activity {
    MyDB_Helper dbHelper_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_activity);
        TextView text_id = (TextView)findViewById(R.id.text_id);
        TextView text_fio = (TextView)findViewById(R.id.text_fio);
        TextView text_date = (TextView)findViewById(R.id.text_date);
        text_id.append("№\n");
        text_fio.append("FIO studenta\n");
        text_date.append("Vremya dobavleniya\n");
        dbHelper_2 = new MyDB_Helper(this);
        SQLiteDatabase database_2 = dbHelper_2.getWritableDatabase();
        String query = "SELECT " + MyDB_Helper.KEY_ID + ", "
                + MyDB_Helper.KEY_FIO + ", "
                + MyDB_Helper.KEY_DATE + " FROM " + MyDB_Helper.TABLE_STUDENTS;
        Cursor cursor = database_2.rawQuery(query, null);
        int idIndex = cursor.getColumnIndex(MyDB_Helper.KEY_ID);
        int fioIndex = cursor.getColumnIndex(MyDB_Helper.KEY_FIO);
        int dateIndex = cursor.getColumnIndex(MyDB_Helper.KEY_DATE);
        //catCursor.moveToFirst();
        String id_2;
        String fio_2;
        String date_2;
        while (cursor.moveToNext()) {

            id_2 = cursor.getString(idIndex);
            text_id.append(id_2 + " \n");
            fio_2 = cursor.getString(fioIndex);
            text_fio.append(fio_2 + " \n");
            date_2 = cursor.getString(dateIndex);
            text_date.append(date_2 + " \n");
        }
        cursor.close();
    }


}
