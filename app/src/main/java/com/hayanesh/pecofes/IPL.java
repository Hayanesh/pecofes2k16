package com.hayanesh.pecofes;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IPL extends AppCompatActivity {
    private ListView listView,round1_des,round2_des;
    private ArrayAdapter<String> arrayAdapter,arrayAdapter1,arrayAdapter2;
    private TextView title,topic,description,price,priceamt,round1,round2;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipl);

        final ScrollView scrollview = ((ScrollView) findViewById(R.id.scrollView));
        scrollview.postDelayed(new Runnable() {
            @Override
            public void run() {
                scrollview.fullScroll(ScrollView.FOCUS_UP);
            }
        },10);

        //setting custom font to titles
        final Typeface customtypeface = Typeface.createFromAsset(this.getAssets(),"fonts/DancingScript-Bold.ttf");
        final Typeface customtypeface1 = Typeface.createFromAsset(this.getAssets(),"fonts/Satisfy-Regular.ttf");
        title = (TextView)findViewById(R.id.ipl_title);
        topic = (TextView)findViewById(R.id.ipl_topic);
        description = (TextView)findViewById(R.id.ipl_description);
        price = (TextView)findViewById(R.id.ipl_price);
        priceamt = (TextView)findViewById(R.id.ipl_priceamt);
        priceamt.setTypeface(customtypeface1);
        price.setTypeface(customtypeface);
        description.setTypeface(customtypeface1);
        topic.setTypeface(customtypeface);
        title.setTypeface(customtypeface);

        round1= (TextView)findViewById(R.id.ipl_round1_topic);
        round2=(TextView)findViewById(R.id.ipl_round2_topic);
        round1.setTypeface(customtypeface);
        round2.setTypeface(customtypeface1);

        round1_des = (ListView)findViewById(R.id.ipl_round1_abouttopic);
        String[] rules1 = getResources().getStringArray(R.array.round1_rules);
        final List<String> rule1 = new ArrayList<String>(Arrays.asList(rules1));
        arrayAdapter1 = new ArrayAdapter<String>(this,R.layout.mylist,rule1){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =  super.getView(position, convertView, parent);
                TextView tv = (TextView)view;
                tv.setTypeface(customtypeface1);
                return view;
            }
        };
        round1_des.setAdapter(arrayAdapter1);

        round2_des = (ListView)findViewById(R.id.ipl_round2_abouttopic);
        String[] rules2 = getResources().getStringArray(R.array.round2_rules);
        final List<String> rule2 = new ArrayList<String>(Arrays.asList(rules2));
        arrayAdapter2 = new ArrayAdapter<String>(this,R.layout.mylist,rule2){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =  super.getView(position, convertView, parent);
                TextView tv = (TextView)view;
                tv.setTypeface(customtypeface1);
                return view;
            }
        };
        round2_des.setAdapter(arrayAdapter2);

        listView = (ListView)findViewById(R.id.ipl_abouttopic);
        String[] rules = getResources().getStringArray(R.array.ipl_rules);
        final List<String> rule = new ArrayList<String>(Arrays.asList(rules));
        arrayAdapter = new ArrayAdapter<String>(this,R.layout.mylist,rule){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =  super.getView(position, convertView, parent);
                TextView tv = (TextView)view;
                tv.setTypeface(customtypeface1);
                return view;
            }
        };
        listView.setAdapter(arrayAdapter);
        FloatingActionButton floatingActionButton = (FloatingActionButton)findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Registration.class);
                startActivity(i);
            }
        });

    }




}
