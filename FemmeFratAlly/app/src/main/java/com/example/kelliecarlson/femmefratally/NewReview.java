package com.example.kelliecarlson.femmefratally;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.util.Calendar;
import com.firebase.client.Firebase;

/**
 * Created by kelliecarlson on 2/20/16.
 */
public class NewReview extends AppCompatActivity{

    Firebase myFirebaseRef = new Firebase("https://blistering-torch-4059.firebaseio.com/");
    Intent schoolFratInfo = getIntent();
    public String universityName = schoolFratInfo.getStringExtra("college");
    public String fraternityName = schoolFratInfo.getStringExtra("frat");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.write_a_new_review_concern);
    }

    public void back(View view){
        Intent intent = new Intent(this, ReviewCommentForum.class);
        startActivity(intent);
    }

    public void post(View view){
        TextView revi = (TextView) findViewById(R.id.editText11);
        String review = revi.getText().toString();

        Intent intentExtras = getIntent();
        Bundle extrasBundle = intentExtras.getExtras();
        final String s = extrasBundle.getString("college");
        final String f = extrasBundle.getString("fraternity");

        String newURL = "https://blistering-torch-4059.firebaseio.com/colleges/" + s +"/" + f;

        Firebase postRef = new Firebase(newURL);

        postRef.push().setValue(review);
        
        Intent intent = new Intent(this, ReviewCommentForum.class);
        startActivity(intent);
    }

}
