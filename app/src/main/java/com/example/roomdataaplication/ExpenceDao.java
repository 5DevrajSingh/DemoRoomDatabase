package com.example.roomdataaplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ExpenceDao {

    @Query("select * from expence")
    List<Expence> getAllExpence();
//
//    @Insert
//    void addTx(Expence expence);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertData(Expence varargs);

    @Update
    void updateTx(Expence expence);

    @Delete
    void deleteTx(Expence expence);
}
