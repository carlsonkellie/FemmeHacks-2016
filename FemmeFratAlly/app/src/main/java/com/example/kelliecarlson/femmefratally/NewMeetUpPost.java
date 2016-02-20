package com.example.kelliecarlson.femmefratally;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

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

    public void back(View view){
        Intent intent = new Intent(this, MeetUpForum.class);
        startActivity(intent);
    }

    public void post(View view){

        TextView when = (TextView) findViewById(R.id.editText7);
        TextView locat = (TextView) findViewById(R.id.editText8);
        TextView dest = (TextView) findViewById(R.id.editText9);
        TextView other = (TextView) findViewById(R.id.editText10);

        String whent = when.getText().toString();
        String locate = locat.getText().toString();
        String desti = dest.getText().toString();
        String othert = other.getText().toString();

        Intent intent = new Intent(this, MeetUpForum.class);
        startActivity(intent);

    }


}
