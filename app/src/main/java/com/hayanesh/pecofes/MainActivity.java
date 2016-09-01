package com.hayanesh.pecofes;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.plattysoft.leonids.ParticleSystem;
import com.viksaa.sssplash.lib.model.ConfigSplash;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnTouchListener {
        private Button button;
        private CardView home;
        protected DrawerLayout drawer;
        private TextView textView;
        public Typeface customtypeface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        //Custom Font-Not working

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/DancingScript-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        home = (CardView) findViewById(R.id.home);
        home.setOnTouchListener(this);
        /*try{
            Glide.with(this).load(R.drawable.logo).into((ImageView)findViewById(R.id.thumbnail));
        }catch (Exception e)
        {
            e.printStackTrace();
        }*/
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        //Navigation Drawer-caption


        textView =(TextView)findViewById(R.id.title_des);
        customtypeface = Typeface.createFromAsset(getAssets(),"fonts/DancingScript-Regular.ttf");
        textView.setTypeface(customtypeface);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View header=navigationView.getHeaderView(0);
        TextView textView1 = (TextView)header.findViewById(R.id.nav_textView1);
        textView1.setTypeface(customtypeface);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onTouch(final View view, MotionEvent motionEvent) {
        new ParticleSystem(this, 100,R.drawable.star_pink, 1000)
                .setScaleRange(0.7f,1.3f)
                .setAcceleration(0.00013f, 90)
                .setSpeedByComponentsRange(0f, 0f, 0.05f, 0.1f)
                .setFadeOut(400, new AccelerateInterpolator())
                .emitWithGravity(view, Gravity.TOP,30,300);

        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            Intent i = new Intent(getApplicationContext(),Report.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            if(!"MainActivity".equals(this.getClass().getSimpleName().toString()))
            {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        } else if (id == R.id.nav_gallery) {
            Intent event = new Intent(getApplicationContext(),EventActivity.class);
            startActivity(event);
        } else if (id == R.id.nav_slideshow) {
            Intent i = new Intent(getApplicationContext(),ContactDetails.class);
            startActivity(i);
        } else if (id == R.id.nav_manage) {
                Intent registration = new Intent(getApplicationContext(),Registration.class);
                startActivity(registration);
        } else if (id == R.id.nav_share) {
            Intent fb = new Intent(getApplicationContext(),Website.class);
            startActivity(fb);
        } else if (id == R.id.nav_send) {
            Intent fb = new Intent(getApplicationContext(),Facebookpage.class);
            startActivity(fb);
        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
