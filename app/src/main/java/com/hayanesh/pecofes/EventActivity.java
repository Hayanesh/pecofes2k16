package com.hayanesh.pecofes;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

public class EventActivity extends MainActivity {
    private RecyclerView recyclerView;
    private FestEventAdapter adapter;
    private List<FestEvent> eventList;
    private Typeface custom_font;
    private TextView schedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout r = (RelativeLayout)findViewById(R.id.test);
        r.setVisibility(RelativeLayout.GONE);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //inflate your activity layout here!
        View contentView = inflater.inflate(R.layout.activity_event, null, false);
        drawer.addView(contentView, 0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        initCollapsingToobar();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        eventList = new ArrayList<>();
        adapter = new FestEventAdapter(this, eventList);

        //schedule = (TextView)findViewById(R.id.schedule);
        //custom_font = Typeface.createFromAsset(getAssets(),"fonts/DancingScript-Bold.ttf");
        //schedule.setTypeface(custom_font);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
       // recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true));
        recyclerView.setAdapter(adapter);
        prepareEvents();
        try {
            Glide.with(this).load(R.drawable.cover).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    private void initCollapsingToobar(){
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle("Events");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }
    private void prepareEvents() {
        int[] covers = new int[]{
                R.drawable.choreo,
                R.drawable.fashion,
                R.drawable.variety,
                R.drawable.shortfilm,
                R.drawable.sing,
                R.drawable.dance,
                R.drawable.adapt,
                R.drawable.photo,
                R.drawable.mrpec,
                R.drawable.ipl,

        };

        FestEvent a = new FestEvent("ChoreoNite","WED SEP 28,6:30 PM",  covers[0]);
        eventList.add(a);

        a = new FestEvent("Fashion Parade","WED SEP 28,6:30 PM",  covers[1]);
        eventList.add(a);

        a = new FestEvent("Variety Variety","WED SEP 28,6:30 PM",  covers[2]);
        eventList.add(a);

        a = new FestEvent("Short Film","WED SEP 28,6:30 PM",  covers[3]);
        eventList.add(a);

        a = new FestEvent("Solo Singing","WED SEP 28,6:30 PM",  covers[4]);
        eventList.add(a);

        a = new FestEvent("Solo Dance","WED SEP 28,6:30 PM",  covers[5]);
        eventList.add(a);

        a = new FestEvent("Adapt Tunes","WED SEP 28,6:30 PM",  covers[6]);
        eventList.add(a);

        a = new FestEvent("Photography","WED SEP 28,6:30 PM",  covers[7]);
        eventList.add(a);

        a = new FestEvent("Mr.& Ms.Pecofes16","WED SEP 28,6:30 PM",  covers[8]);
        eventList.add(a);

        a = new FestEvent("IPL Auction","WED SEP 28,6:30 PM",  covers[9]);
        eventList.add(a);
        adapter.notifyDataSetChanged();
    }
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}

