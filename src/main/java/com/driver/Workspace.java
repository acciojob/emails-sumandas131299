package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar = new ArrayList<>(); // Stores all the meetings



    public Workspace(String emailId) {
        super(emailId,Integer.MAX_VALUE);
        // The inboxCapacity is equal to the maximum value an integer can store.

    }

    public void addMeeting(Meeting meeting){
        System.out.println("New meeting added to the calender");
        this.calendar.add(meeting);
        //add the meeting to calendar

    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        ArrayList<Pair<LocalTime,Integer>> endtimes = new ArrayList<>();
        for(int i=0;i<this.calendar.size();i++){
            endtimes.add(Pair.of(this.calendar.get(i).getEndTime(),i));
        }
        Collections.sort(endtimes);
        LocalTime limit = endtimes.get(0).getKey();
        int cnt =0;
        if(!endtimes.isEmpty()) cnt++;

        for(int i=1;i<endtimes.size();i++){
            if(this.calendar.get(endtimes.get(i).getValue()).getStartTime().isAfter(limit)) {
                cnt++;
                limit = endtimes.get(i).getKey();
            }
        }
        return cnt;
    }
}
