package com.hayanesh.pecofes;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Report extends AppCompatActivity {
    private TextView title,name1,name2,name3;
    private TextView class1,class2,class3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/DancingScript-Regular.ttf");
        Typeface customtypeface1 = Typeface.createFromAsset(this.getAssets(),"fonts/Satisfy-Regular.ttf");
        title = (TextView)findViewById(R.id.textView);
        name1 = (TextView)findViewById(R.id.textView2);
        name2 = (TextView)findViewById(R.id.textView4);
        name3 = (TextView)findViewById(R.id.textView6);
        title.setTypeface(typeface);
        name1.setTypeface(typeface);
        name2.setTypeface(typeface);
        name3.setTypeface(typeface);
        class1 = (TextView)findViewById(R.id.textView3);
        class2 = (TextView)findViewById(R.id.textView5);
        class3 = (TextView)findViewById(R.id.textView7);
        class1.setTypeface(customtypeface1);
        class2.setTypeface(customtypeface1);
        class3.setTypeface(customtypeface1);
    }
}
