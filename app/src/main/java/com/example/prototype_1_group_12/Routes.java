package com.example.prototype_1_group_12;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

import static androidx.room.ForeignKey.CASCADE;

// One to many relationship
//  -Define its relationship to Routes
//  -ForeignKey allows to specify constraints

@Entity(tableName = "route_table", foreignKeys = @ForeignKey(entity = Points.class, parentColumns = "id", childColumns = "pointid", onDelete = CASCADE))
public class Routes {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "route_id")  // Allows specific customization about the column
    private int routeId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "description")
    private String desc;

    @ColumnInfo(name = "date")
    private Date date;

    public Routes(int routeId, String name, String desc, Date date) {
        this.routeId = routeId;
        this.name = name;
        this.desc = desc;
        this.date = date;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
