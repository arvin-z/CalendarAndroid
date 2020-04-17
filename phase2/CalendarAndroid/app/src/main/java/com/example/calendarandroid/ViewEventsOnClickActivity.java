package com.example.calendarandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.parse.ParseObject;

import java.util.ArrayList;

public class ViewEventsOnClickActivity extends AppCompatActivity implements ViewEventsAdapter.OnEventClickListener {

    RecyclerView r;
    LinearLayoutManager layoutManager;
    ArrayList<Event> event;
    ViewEventsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_events_on_click);
        r = findViewById(R.id.eventViewingRecycler);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        Intent extras = getIntent();
        Bundle data  = extras.getExtras();
        ArrayList<String[]> eventsData = new ArrayList<>();
        String[] singleEventData = new String[3];
        assert data != null;
        String[] name = data.getStringArray("name");
        String[] start = data.getStringArray("startDate");
        String[] end = data.getStringArray("endDate");
        assert name != null;
        int len = name.length;
        for(int i = 0; i < len; i++) {
            singleEventData[0] = name[i];
            singleEventData[1] = start[i];
            singleEventData[2] = end[i];
            eventsData.add(singleEventData);
            singleEventData = new String[3];
        }
        this.adapter = new ViewEventsAdapter(this, eventsData, this);
        r.setAdapter(this.adapter);
        r.setLayoutManager(layoutManager);

    }

    @Override
    public void onEventClick(int position) {
        Log.d("click", String.valueOf(position));
        //start activity to view individual event
    }
}