package com.example.kelliecarlson.femmefratally;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

/**
 * Created by kelliecarlson on 2/20/16.
 */
public class MeetUpForum extends AppCompatActivity {

    //have all the different areas for a meet up post
    //access from database, show them, delete them after 24h
    //look at timestamp


    Firebase myFirebaseRef = new Firebase("https://blistering-torch-4059.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.meet_up_forum);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void backButton(View view) {
        Intent intent = new Intent(this, FratMainScreen.class);
        startActivity(intent);
    }

    public void writeNewPost(View view) {
        Intent intent = new Intent(this, NewMeetUpPost.class);
        startActivity(intent);
    }

}


