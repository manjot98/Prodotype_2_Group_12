package com.example.prototype_1_group_12;

// not sure about number of repos - https://stackoverflow.com/questions/53922862/single-on-multiple-dao-and-repository-in-android-room-database-project/53939077

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

// Repository allows access to multiple data sources
// Determines whether to fetch local or network data

public class RoutesRepository {

    private RoutesDAO routesDAO;
    private LiveData<List<Routes>> allRoutes;

    RoutesRepository(Application application){
        RPDatabase rpDatabase = RPDatabase.getDatabase(application);
        routesDAO = rpDatabase.routesDAO();
        allRoutes = routesDAO.displayRoutes();
    }

    // When route has been modified (name, description), LiveDate will notify the observer that the data has changed
    LiveData<List<Routes>> getAllRoutes(){
        return allRoutes;
    }

    // ExecutorService manages terimnation and methods
    // Tracking progress for asynchronous tasks
    void insert(Routes routes){
        RPDatabase.databaseWriteExecutor.execute(() -> {
            routesDAO.insert(routes);
        });
    }
}
