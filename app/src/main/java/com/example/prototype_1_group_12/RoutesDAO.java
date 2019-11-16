package com.example.prototype_1_group_12;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

// Data Access Object:
//  -Validates your SQL at compile-time and associates it with a method.
//  -By default, all queries must be executed on a separate thread, hence it must be implemented as an interface

// Routes should be able to do the following operations:
//  -Delete
//  -Add
//  -Update
//  -Display all routes

@Dao
public interface RoutesDAO {

    // On each insert, id increments
    // OnConflict.IGNORE keeps the existing rows (probable issue with route id?)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Routes route);

    @Query("DELETE FROM route_table WHERE route_id = :id")
    void deleteRoute(int id);

    @Query("UPDATE route_table SET name = :name, description = :desc  WHERE route_id = :id")
    void editRoute(int id, String name, String desc);

    @Query("SELECT * FROM route_table ORDER BY route_id ASC")
    LiveData<List<Routes>> displayRoutes();

    @Query("SELECT route_id FROM route_table WHERE date = :date")
    void setDate(String date);
}
