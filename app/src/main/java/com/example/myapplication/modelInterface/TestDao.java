package com.example.myapplication.modelInterface;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.myapplication.model.Test;

import java.util.List;



@Dao
public interface TestDao {

    @Insert
    void insertAll(Test... test);

    @Delete
    void  Delete(Test test);

    @Query("SELECT * FROM test")
    List<Test> getAllTest();

    @Query("SELECT * FROM test WHERE id=:ident")
    List<Test> getTestById(int ident);
    
}
