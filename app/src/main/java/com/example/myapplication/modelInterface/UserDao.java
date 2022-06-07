package com.example.myapplication.modelInterface;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.myapplication.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertALL(User... user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM user")
    List<User> getAllUser();

    @Query("SELECT * FROM user WHERE login=:log AND password=:pass")
    List<User> getUserByLoginAndPassword(String log, String pass);
}
