package com.tokarieva;

import java.util.Calendar;
import java.util.Date;

public class Transform {
    public long milisToSecs(long milis){
        return milis/1000;
    }

    public long milisToMins(long milis){
        return (milis/1000)/60;
    }

    public long milisToHours(long milis){
        long mins = (milis/1000)/60;
        return mins/60;
    }

    public long milisToDays(long milis){
        return (((milis/1000)/60)/60)/24;
    }

    public long milisToYears(long milis){
        return ((((milis/1000)/60)/60)/24)/366;
    }

    public void milisecsSinceDay(int year, int month, int day, int hour, int minute){

        Calendar c = Calendar.getInstance();
        c.set(year, month, day, hour, minute);

        long currentTimeInMilis = System.currentTimeMillis();
        long past = currentTimeInMilis - c.getTimeInMillis();
        long years = milisToYears(past);
        System.out.println(past);
    }
}
