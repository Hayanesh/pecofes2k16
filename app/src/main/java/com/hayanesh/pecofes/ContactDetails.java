package com.hayanesh.pecofes;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.QuickContactBadge;
import android.widget.RelativeLayout;

import com.daimajia.easing.quint.QuintEaseIn;

import java.lang.reflect.Array;

public class ContactDetails extends MainActivity {
    private ListView listView,acclist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout r = (RelativeLayout)findViewById(R.id.test);
        r.setVisibility(RelativeLayout.GONE);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final String[] phoneno = {"9790498687",
                "9952358777",
                "9500898882",
                "9677544872",
                "8220311165",
                "9600661998",
                "7092205315",
                "9944073391",
                "7598123558",
                ""

        };
        //inflate your activity layout here!
        View contentView = inflater.inflate(R.layout.activity_contact_details, null, false);
        drawer.addView(contentView, 0);
        acclist = (ListView)findViewById(R.id.accname);
        listView = (ListView)findViewById(R.id.contactname);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent phone = new Intent(Intent.ACTION_DIAL);
                phone.setData(Uri.parse("tel:"+phoneno[i]));
                startActivity(phone);
            }
        });

        acclist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent phone = new Intent(Intent.ACTION_DIAL);
                phone.setData(Uri.parse("tel:"+phoneno[8+i]));
                startActivity(phone);
            }
        });
    }

}
