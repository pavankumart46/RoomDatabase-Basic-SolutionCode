package com.blogspot.pavankreddytadi.roomdatabase_basic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.arch.persistence.room.Room;
import java.util.*;

public class MainActivity extends AppCompatActivity
{
    public static RoomDatabaseClass roomDatabaseClass;
    EditText et_name,et_id;
    TextView tv_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = findViewById(R.id.student_name);
        et_id = findViewById(R.id.student_id);
        tv_view = findViewById(R.id.data_text_view);

        //initializing the object
        roomDatabaseClass = Room.databaseBuilder(this,RoomDatabaseClass.class,"MYROOM")
                .allowMainThreadQueries()
                .build();
    }

    public void saveData(View view)
    {
        String name = et_name.getText().toString();
        int id = Integer.parseInt(et_id.getText().toString());

        StudentDetails studentDetails = new StudentDetails(id,name);
        roomDatabaseClass.studentDetailsDao().insert(studentDetails);
        Toast.makeText(this, "DATA INSERTION SUCCESSFUL!", Toast.LENGTH_SHORT).show();
        et_id.setText("");
        et_name.setText("");
    }

    public void retrieveData(View view)
    {
        List<StudentDetails> list = roomDatabaseClass.studentDetailsDao().viewAll();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<list.size();i++)
        {
            stringBuilder.append(list.get(i).getStudent_id()+" "+list.get(i).getName()+"\n");
        }
        tv_view.setText(stringBuilder.toString());
    }
}
