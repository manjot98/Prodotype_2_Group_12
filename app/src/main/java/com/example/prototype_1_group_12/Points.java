package com.example.prototype_1_group_12;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "point_table")
public class Points {

    private int pointId;

    @ColumnInfo(name = "long")
    private double longitude;

    @ColumnInfo(name = "lat")
    private double latitude;

    @ColumnInfo(name = "date")
    private Date date;

    public Points(int pointId, double longitude, double latitude, Date date ) {
        this.pointId = pointId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.date = date;
    }

    @NonNull
    public int getPointId() {
        return pointId;
    }

    public void setPointId(@NonNull int pointId) {
        this.pointId = pointId;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() { return latitude; }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
