package com.hayanesh.pecofes;

/**
 * Created by Hayanesh on 25-Aug-16.
 */

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.widget.RelativeLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;


public class SplashScreen extends AwesomeSplash {

    @Override
    public void initSplash(ConfigSplash configSplash) {

            /* you don't have to override every property */
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //Customize Circular Reveal
        configSplash.setBackgroundColor(R.color.colorPrimary); //any color you want form colors.xml
        configSplash.setAnimCircularRevealDuration(2000); //int ms
        configSplash.setRevealFlagX(Flags.REVEAL_LEFT);  //or Flags.REVEAL_LEFT
        configSplash.setRevealFlagY(Flags.REVEAL_TOP); //or Flags.REVEAL_TOP

        //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

        //Customize Logo
        //configSplash.setLogoSplash(R.drawable.pecofes); //or any other drawable
        //configSplash.setAnimLogoSplashDuration(2000); //int ms
        //configSplash.setAnimLogoSplashTechnique(Techniques.Bounce); //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)


        //Customize Title
        configSplash.setTitleSplash("PecOFes 2K16");
        configSplash.setTitleTextColor(R.color.splash_logo);
        configSplash.setTitleTextSize(32f); //float value
        configSplash.setAnimTitleDuration(2000);
        configSplash.setAnimTitleTechnique(Techniques.FadeIn);
        configSplash.setTitleFont("fonts/DancingScript-Regular.ttf"); //provide string to your font located in assets/fonts/


        //Customize Path
        configSplash.setPathSplash(Constants.LOGO_B); //set path String
        configSplash.setOriginalHeight(670); //in relation to your svg (path) resource
        configSplash.setOriginalWidth(1070); //in relation to your svg (path) resource
        configSplash.setAnimPathStrokeDrawingDuration(3000);
        configSplash.setPathSplashStrokeSize(1); //I advise value be <5
        configSplash.setPathSplashStrokeColor(R.color.splash_logo); //any color you want form colors.xml
        configSplash.setAnimPathFillingDuration(1000);
        configSplash.setPathSplashFillColor(R.color.splash_logo); //path object filling color
    }

    @Override
    public void animationsFinished() {

        //transit to another activity here
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
}

