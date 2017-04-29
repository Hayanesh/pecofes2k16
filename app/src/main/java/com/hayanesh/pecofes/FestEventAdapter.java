package com.hayanesh.pecofes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Hayanesh on 23-Aug-16.
 */
public class FestEventAdapter extends RecyclerView.Adapter<FestEventAdapter.MyViewHolder> {
    private Context mContext;
    private List<FestEvent> eventList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView schedule, name;
        public ImageView thumbnail;
        public Button enroll;
        public Button moreinfo;

        public MyViewHolder(View view) {
            super(view);
            schedule = (TextView) view.findViewById(R.id.schedule);
            name = (TextView) view.findViewById(R.id.name);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            enroll = (Button) view.findViewById(R.id.participate);
            moreinfo = (Button) view.findViewById(R.id.moreinfo);
        }
    }

    public FestEventAdapter(Context mContext, List<FestEvent> eventList) {
        this.mContext = mContext;
        this.eventList = eventList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.festevent_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        FestEvent festevent = eventList.get(position);
        holder.schedule.setText(festevent.getSchedule());
        holder.name.setText(festevent.getName());

        holder.enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, Registration.class);
                mContext.startActivity(i);
            }
        });
        Glide.with(mContext).load(festevent.getThumbnail()).into(holder.thumbnail);
        switch (position) {
            case 0:
                holder.moreinfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        Intent i = new Intent(mContext, Choreonite.class);
                        mContext.startActivity(i);

                    }
                });
                break;
            case 1:
                holder.moreinfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        Intent i = new Intent(mContext, FashionParade.class);
                        mContext.startActivity(i);

                    }
                });
                break;
            case 2:
                holder.moreinfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        Intent i = new Intent(mContext, Variety.class);
                        mContext.startActivity(i);

                    }
                });
                break;
            case 3:
                holder.moreinfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        Intent i = new Intent(mContext,ShortFilms.class);
                        mContext.startActivity(i);

                    }
                });
                break;
            case 4:
                holder.moreinfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        Intent i = new Intent(mContext, SoloSinging.class);
                        mContext.startActivity(i);

                    }
                });
                break;
            case 5:
                holder.moreinfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        Intent i = new Intent(mContext, Dance.class);
                        mContext.startActivity(i);

                    }
                });
                break;
            case 6:
                holder.moreinfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        Intent i = new Intent(mContext, AdaptTunes.class);
                        mContext.startActivity(i);

                    }
                });
                break;
            case 7:
                holder.moreinfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        Intent i = new Intent(mContext, TitleCard.class);
                        mContext.startActivity(i);

                    }
                });
                break;
            case 8:
                holder.moreinfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        Intent i = new Intent(mContext, MrPec.class);
                        mContext.startActivity(i);

                    }
                });
                break;
            case 9:
                holder.moreinfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        Intent i = new Intent(mContext, IPL.class);
                        mContext.startActivity(i);

                    }
                });
                break;
            case 10:
                holder.moreinfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        Intent i = new Intent(mContext, Literary.class);
                        mContext.startActivity(i);

                    }
                });
                break;

        }
    }
        @Override
        public int getItemCount () {
            return eventList.size();
        }
    }

