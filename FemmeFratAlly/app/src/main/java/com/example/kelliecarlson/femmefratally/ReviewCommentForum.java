package com.example.kelliecarlson.femmefratally;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Calendar;

/**
 * Created by kelliecarlson on 2/20/16.
 */
public class ReviewCommentForum extends AppCompatActivity{
    //have all the different areas for a meet up post
    //access from database, show them, delete them after 24h
    //look at timestamp

    Firebase myFirebaseRef = new Firebase("https://blistering-torch-4059.firebaseio.com/");

    public String college = "UPenn";
    public String fraternity = "AAA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.review_concern_forum);

        Intent intent = getIntent();
        college = intent.getStringExtra("college");


        final ListView listView = (ListView) findViewById(R.id.listView2);

        // Create a new Adapter
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // Use Firebase to populate the list.
        Firebase.setAndroidContext(this);

        String newURL = "https://blistering-torch-4059.firebaseio.com/colleges/" + college + "/frats/" + fraternity;

        double sum = 0;
        double count = 0;
        double average = 0;
        new Firebase(newURL)
                .addChildEventListener(new ChildEventListener() {
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        MyReview post = (MyReview) dataSnapshot.child("frats").getValue();
                        String s = post.getReview();
                        double x = post.getStars();
                        sum +=x;
                        count +=1;
                        average = sum/count;
                        adapter.add(s);
                    }

                    public void onChildRemoved(DataSnapshot dataSnapshot) {
                        MyReview post = (MyReview) dataSnapshot.child("frats").getValue();
                        String s = post.getReview();
                        double x = post.getStars();
                        sum -=x;
                        count -=1;
                        adapter.remove(s);                    }

                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    }

                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                    }

                    public void onCancelled(FirebaseError firebaseError) {
                    }
                });


        RatingBar stars = (RatingBar) findViewById(R.id.ratingBar3);
        stars.setValue((int) average);
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


}
