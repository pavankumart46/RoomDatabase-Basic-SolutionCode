package com.blogspot.pavankreddytadi.roomdatabase_basic;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.*;

@Dao
public interface StudentDetailsDao
{
    @Insert
    public void insert(StudentDetails studentDetails);

    @Query("Select * from student_details")
    public List<StudentDetails> viewAll();
}
