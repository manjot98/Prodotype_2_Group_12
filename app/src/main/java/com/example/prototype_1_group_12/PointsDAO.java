package com.example.prototype_1_group_12;

import android.graphics.Point;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.Date;
import java.util.List;

// Points should be able to do the following operations:
//  -Add
//  -Update
//  -Display all points tracked
@Dao
public interface PointsDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertPoint(Points points);

    // Updates via GoogleMaps API
    @Query("UPDATE point_table SET long = :longitude AND lat = :latitude WHERE pointId = :id")
    LiveData<List<Points>> setLongitudeLatitude(int id, double longitude, double latitude);

    // For View Routes, show static routes from point A - B
    @Query("SELECT * FROM point_table WHERE pointId = :id AND long = :longitude AND lat = :latitude")
    void getPoints(int id, double longitude, double latitude);

    /*
    @Query("SELECT pointId FROM point_table WHERE long = :longitude")
    LiveData<List<Points>> setLongitude(double longitude);

    @Query("SELECT pointId FROM point_table WHERE lat = :latitude")
    LiveData<List<Points>> setLatitude(double latitude);

    @Query("SELECT pointId FROM point_table WHERE date = :date")
    void getDate(Date date);
     */
}
