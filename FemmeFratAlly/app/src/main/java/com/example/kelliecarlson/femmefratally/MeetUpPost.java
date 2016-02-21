package com.example.kelliecarlson.femmefratally;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by sharoniegreenblatt on 2/20/16.
 */
public class MeetUpPost {

    private String when, locate, dest, other;
    private java.util.Date date;

    public MeetUpPost(String when, String locate, String dest, String other, java.util.Date date){
        this.when = when;
        this.locate = locate;
        this.dest = dest;
        this.other = other;
        this.date = date;

    }

    public String getWhen() {
        return when;
    }


    public String getLocate() {

        return locate;
    }

    public Date getDate() {
        return date;
    }

    public String getDest() {

        return dest;
    }

    public String getOther() {
        return other;
    }
}
