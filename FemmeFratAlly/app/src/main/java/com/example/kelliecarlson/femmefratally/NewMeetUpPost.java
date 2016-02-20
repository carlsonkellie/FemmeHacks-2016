package com.example.kelliecarlson.femmefratally;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.firebase.client.Firebase;

/**
 * Created by sharoniegreenblatt on 2/20/16.
 */
public class NewMeetUpPost extends AppCompatActivity{
    Firebase myFirebaseRef = new Firebase("https://blistering-torch-4059.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.write_a_new_meet_up_post);
    }


}
