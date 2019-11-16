package com.example.carpool.DataTypes;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class DBConnection {
    private DatabaseReference db;
    private User currentUser;
    private DataSnapshot userDataSnapshot;
    private DataSnapshot carPoolsSnapshot;

    public DBConnection() {
        this.db = FirebaseDatabase.getInstance().getReference();
    }

    /*Adds a new user entry in the database. Takes a pre-made user as a parameter.
     * The user is stored in the database as "Users/userKey/userObject"
     */
    public void addUserToDB(User newUser) {
        String uniqueId = User.getUserKey(newUser.getEmail());
        db.child("Users").child(uniqueId).setValue(newUser);
    }

    /*sets the current user object and updates the user object whenever the db is changed*/
    public void updateCurrentUser(String email){
        final String userKey = User.getUserKey(email);
        ValueEventListener readDB = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                setCarPoolsSnapshot(dataSnapshot.child("CarPools"));
                setUserDataSnapshot(dataSnapshot.child("Users"));
                DataSnapshot userSnap = dataSnapshot.child("Users").child(userKey);
                currentUser = userSnap.child(userKey).getValue(User.class);
                setCurrentUser(currentUser);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        db.addValueEventListener(readDB);
    }

    public void createCarpool(CarPool carPool){
        db.child("CarPools").child(carPool.getUuid()).setValue(carPool);
    }

    public ArrayList<CarPool> getCarpools(){
        ArrayList<CarPool> list = new ArrayList<CarPool>();
        for (DataSnapshot child: carPoolsSnapshot.getChildren()){
            list.add(child.getValue(CarPool.class));
        }
        return list;
    }

    public void setCurrentUser(User u) {
        currentUser = u;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setUserDataSnapshot(DataSnapshot d) {
        userDataSnapshot = d;
    }

    public DataSnapshot getUserDataSnapshot() {
        return userDataSnapshot;
    }

    public void setCarPoolsSnapshot(DataSnapshot d){
        carPoolsSnapshot = d;
    }
}
