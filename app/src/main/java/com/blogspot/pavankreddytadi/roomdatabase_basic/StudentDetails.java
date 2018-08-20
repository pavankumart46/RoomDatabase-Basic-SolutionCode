package com.blogspot.pavankreddytadi.roomdatabase_basic;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "student_details")
public class StudentDetails
{
    @PrimaryKey
    int student_id;
    String name;

    public StudentDetails(int student_id, String name)
    {
        this.student_id = student_id;
        this.name = name;
    }

    public int getStudent_id()
    {
        return student_id;
    }

    public String getName()
    {
        return name;
    }
}
