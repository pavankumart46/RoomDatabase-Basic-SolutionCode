package com.blogspot.pavankreddytadi.roomdatabase_basic;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
@Database(entities = {StudentDetails.class},version = 1,exportSchema = false)
public abstract class RoomDatabaseClass extends RoomDatabase
{
    public abstract StudentDetailsDao studentDetailsDao();
}
