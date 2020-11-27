package com.example.teamproject;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class TimeTable extends Dialog implements View.OnClickListener{ // 시간표입니다.



    private TextView btn_cancel;
    private TextView station_before;
    private TextView station_now;
    private TextView station_after;
    private ImageView line_border;
    private TextView time_after;
    private TextView time_before;
    private ImageButton select_line1;
    private ImageButton select_line2;
    private int station;

    public TimeTable(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_table);

        btn_cancel = (TextView)findViewById(R.id.btn_cancel_timetable);
        time_before = (TextView)findViewById(R.id.time_before);
        time_after = (TextView)findViewById(R.id.time_after);
        station_before = (TextView)findViewById(R.id.before_station);
        station_now = (TextView)findViewById(R.id.now_station);
        station_after = (TextView)findViewById(R.id.after_station);

        select_line1 = (ImageButton)findViewById(R.id.select_line1);

        line_border = (ImageView)findViewById(R.id.line_border);

        btn_cancel.setOnClickListener(this);

        station_now.setText(Integer.toString(station));


        if(101<=station && station<=123) {
            line_border.setImageResource(R.drawable.line1);
            select_line1.setImageResource(R.drawable.ho1);
            cal_table(station);
        }
        else if(201<=station && station<=217){
            line_border.setImageResource(R.drawable.line2);
            select_line1.setImageResource(R.drawable.ho2);
            cal_table(station);
        }
        else if(301<=station && station<=308){
            line_border.setImageResource(R.drawable.line3);
            select_line1.setImageResource(R.drawable.ho3);
            cal_table(station);
        }
        else if(401<=station && station<=417){
            line_border.setImageResource(R.drawable.line4);
            select_line1.setImageResource(R.drawable.ho4);
            cal_table(station);
        }
        else if(501<=station && station<=507){
            line_border.setImageResource(R.drawable.line5);
            select_line1.setImageResource(R.drawable.ho5);
            cal_table(station);
        }
        else if(601<=station && station<=622){
            line_border.setImageResource(R.drawable.line6);
            select_line1.setImageResource(R.drawable.ho6);
            cal_table(station);
        }
        else if(701<=station && station<=707){
            line_border.setImageResource(R.drawable.line7);
            select_line1.setImageResource(R.drawable.ho7);
            cal_table(station);
        }
        else if(801<=station && station<=806){
            line_border.setImageResource(R.drawable.line8);
            select_line1.setImageResource(R.drawable.ho8);
            cal_table(station);
        }
        else if(901<=station && station<=904){
            line_border.setImageResource(R.drawable.line9);
            select_line1.setImageResource(R.drawable.ho9);
            cal_table(station);
        }

    }

    public void setStation(int station){
        this.station = station;
    }


    public static String time(int s) {

        String time = "";
        for(int i = 0; s < 86400; i++) {
            int sec1, min, hour;
            sec1 = s;

            min = sec1 / 60;
            hour = min / 60;
            min = min % 60;

            time += String.format("%02d:%02d \n", hour, min);

            s += 15*60;
        }

        return time;
    }

    @Override

    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_cancel_timetable:

                dismiss();

        }

    }



    public void cal_table(int s){ // 시간표에서의 이벤트 처리

        time_before = (TextView)findViewById(R.id.time_before);
        time_after = (TextView)findViewById(R.id.time_after);
        station_before = (TextView)findViewById(R.id.before_station);
        station_after = (TextView)findViewById(R.id.after_station);
        line_border = (ImageView)findViewById(R.id.line_border);
        select_line1 = (ImageButton)findViewById(R.id.select_line1);
        select_line2 = (ImageButton)findViewById(R.id.select_line2);

        if(station==101) {

            int station = 101; // 역의 이름

            int lineN = 1; // 호선
            int station1 = 102; // 왼역 이름
            int sec1 = 3600*6; // 왼역 시작 시간
            int station2 = 123; // 오른역 이름
            int sec2 = 3600*6; // 오른역 시작 시간

            int lineN1 = 2;
            int station3 = 201;
            int sec3 = 3600*6;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);

            select_line1.setImageResource(R.drawable.ho1);
            select_line2.setImageResource(R.drawable.ho2);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line1);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line2);
                    time_before.setText("");
                    time_after.setText(time3);
                    station_before.setText("");
                    station_after.setText(Integer.toString(station3));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==102){
            int station = 102; // 역의 이름

            int lineN = 1; // 호선
            int station1 = 103; // 왼역 이름
            int sec1 = 3600*6 + 200; // 왼역 시작 시간
            int station2 = 101; // 오른역 이름
            int sec2 = 3600*6 + 12680; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==103){
            int lineN = 1; // 호선
            int station1 = 104; // 왼역 이름
            int sec1 = 3600*6 + 500; // 왼역 시작 시간
            int station2 = 102; // 오른역 이름
            int sec2 = 3600*6 + 12380; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==104){
            int lineN = 1; // 호선
            int station1 = 105; // 왼역 이름
            int sec1 = 3600*6 + 1500; // 왼역 시작 시간
            int station2 = 103; // 오른역 이름
            int sec2 = 3600*6 + 11380; // 오른역 시작 시간

            int lineN1 = 4;
            int station3 = 401;
            int sec3 = 3600*6;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);

            select_line1.setImageResource(R.drawable.ho1);
            select_line2.setImageResource(R.drawable.ho4);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line1);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line4);
                    time_before.setText("");
                    time_after.setText(time3);
                    station_before.setText("");
                    station_after.setText(Integer.toString(station3));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);

        }
        else if(station==105){
            int lineN = 1; // 호선
            int station1 = 106; // 왼역 이름
            int sec1 = 3600*6 + 2000; // 왼역 시작 시간
            int station2 = 104; // 오른역 이름
            int sec2 = 3600*6 + 10880; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==106){
            int lineN = 1; // 호선
            int station1 = 107; // 왼역 이름
            int sec1 = 3600*6 + 2150; // 왼역 시작 시간
            int station2 = 105; // 오른역 이름
            int sec2 = 3600*6 + 10730; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==107){
            int lineN = 1; // 호선
            int station1 = 108; // 왼역 이름
            int sec1 = 3600*6 + 2470; // 왼역 시작 시간
            int station2 = 106; // 오른역 이름
            int sec2 = 3600*6 + 10410; // 오른역 시작 시간

            int lineN1 = 3;
            int station3 = 308;
            int sec3 = 3600*6;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);

            select_line1.setImageResource(R.drawable.ho1);
            select_line2.setImageResource(R.drawable.ho3);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line1);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line3);
                    time_before.setText("");
                    time_after.setText(time3);
                    station_before.setText("");
                    station_after.setText(Integer.toString(station3));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==108){
            int lineN = 1; // 호선
            int station1 = 109; // 왼역 이름
            int sec1 = 3600*6 + 2870; // 왼역 시작 시간
            int station2 = 105; // 오른역 이름
            int sec2 = 3600*6 + 10010; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==109){
            int lineN = 1; // 호선
            int station1 = 108; // 왼역 이름
            int sec1 = 3600*6 + 3670; // 왼역 시작 시간
            int station2 = 110; // 오른역 이름
            int sec2 = 3600*6 + 9210; // 오른역 시작 시간

            int lineN1 = 5;
            int station3 = 507;
            int sec3 = 3600*6;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);

            select_line1.setImageResource(R.drawable.ho1);
            select_line2.setImageResource(R.drawable.ho5);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line1);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line5);
                    time_before.setText("");
                    time_after.setText(time3);
                    station_before.setText("");
                    station_after.setText(Integer.toString(station3));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==110){
            int lineN = 1; // 호선
            int station1 = 111; // 왼역 이름
            int sec1 = 3600*6 + 4570; // 왼역 시작 시간
            int station2 = 109; // 오른역 이름
            int sec2 = 3600*6 + 8310; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);

            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==111){
            int lineN = 1; // 호선
            int station1 = 112; // 왼역 이름
            int sec1 = 3600*6 + 5070; // 왼역 시작 시간
            int station2 = 110; // 오른역 이름
            int sec2 = 3600*6 + 7810; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==112){
            int lineN = 1; // 호선
            int station1 = 113; // 왼역 이름
            int sec1 = 3600*6 + 6070; // 왼역 시작 시간
            int station2 = 111; // 오른역 이름
            int sec2 = 3600*6 + 6810; // 오른역 시작 시간

            int lineN1 = 9;
            int station3 = 901;
            int sec3 = 3600*6;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);

            select_line1.setImageResource(R.drawable.ho1);
            select_line2.setImageResource(R.drawable.ho9);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line1);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line9);
                    time_before.setText("");
                    time_after.setText(time3);
                    station_before.setText("");
                    station_after.setText(Integer.toString(station3));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==113){
            int lineN = 1; // 호선
            int station1 = 114; // 왼역 이름
            int sec1 = 3600*6 + 8070; // 왼역 시작 시간
            int station2 = 112; // 오른역 이름
            int sec2 = 3600*6 + 4810; // 오른역 시작 시간

            int lineN1 = 8;
            int station3 = 801;
            int sec3 = 3600*6;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);

            select_line1.setImageResource(R.drawable.ho1);
            select_line2.setImageResource(R.drawable.ho8);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line1);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line8);
                    time_before.setText("");
                    time_after.setText(time3);
                    station_before.setText("");
                    station_after.setText(Integer.toString(station3));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==114){
            int station = 114; // 역의 이름

            int lineN = 1; // 호선
            int station1 = 115; // 왼역 이름
            int sec1 = 3600*6 + 8570; // 왼역 시작 시간
            int station2 = 113; // 오른역 이름
            int sec2 = 3600*6 + 4310; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==115){
            int lineN = 1; // 호선
            int station1 = 116; // 왼역 이름
            int sec1 = 3600*6 + 8790; // 왼역 시작 시간
            int station2 = 114; // 오른역 이름
            int sec2 = 3600*6 + 4090; // 오른역 시작 시간

            int lineN1 = 4;
            int station3 = 407;
            int sec3 = 3600*6 + 3310;
            int station4 = 408;
            int sec4 = 3600*6 + 5840;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);
            String time4 = time(sec4);

            select_line1.setImageResource(R.drawable.ho1);
            select_line2.setImageResource(R.drawable.ho4);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line1);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line4);
                    time_before.setText(time3);
                    time_after.setText(time4);
                    station_before.setText(Integer.toString(station3));
                    station_after.setText(Integer.toString(station4));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==116){
            int station = 116; // 역의 이름

            int lineN = 1; // 호선
            int station1 = 117; // 왼역 이름
            int sec1 = 3600*6 + 9020; // 왼역 시작 시간
            int station2 = 115; // 오른역 이름
            int sec2 = 3600*6 + 3860; // 오른역 시작 시간

            int lineN1 = 6;
            int station3 = 606;
            int sec3 = 3600*6 + 8850;
            int station4 = 607;
            int sec4 = 3600*6 + 2400;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);
            String time4 = time(sec4);

            select_line1.setImageResource(R.drawable.ho1);
            select_line2.setImageResource(R.drawable.ho6);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line1);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line6);
                    time_before.setText(time3);
                    time_after.setText(time4);
                    station_before.setText(Integer.toString(station3));
                    station_after.setText(Integer.toString(station4));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==117){
            int lineN = 1; // 호선
            int station1 = 118; // 왼역 이름
            int sec1 = 3600*6 + 9320; // 왼역 시작 시간
            int station2 = 116; // 오른역 이름
            int sec2 = 3600*6 + 3560; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==118){
            int lineN = 1; // 호선
            int station1 = 119; // 왼역 이름
            int sec1 = 3600*6 + 9820; // 왼역 시작 시간
            int station2 = 117; // 오른역 이름
            int sec2 = 3600*6 + 3060; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==119){
            int lineN = 1; // 호선
            int station1 = 120; // 왼역 이름
            int sec1 = 3600*6 + 10300; // 왼역 시작 시간
            int station2 = 118; // 오른역 이름
            int sec2 = 3600*6 + 2580; // 오른역 시작 시간

            int lineN1 = 9;
            int station3 = 902;
            int sec3 = 3600*6 + 2200;
            int station4 = 903;
            int sec4 = 3600*6 + 2010;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);
            String time4 = time(sec4);

            select_line1.setImageResource(R.drawable.ho1);
            select_line2.setImageResource(R.drawable.ho9);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line1);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line9);
                    time_before.setText(time3);
                    time_after.setText(time4);
                    station_before.setText(Integer.toString(station3));
                    station_after.setText(Integer.toString(station4));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==120){
            int lineN = 1; // 호선
            int station1 = 121; // 왼역 이름
            int sec1 = 3600*6 + 10800; // 왼역 시작 시간
            int station2 = 119; // 오른역 이름
            int sec2 = 3600*6 + 2080; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==121){
            int lineN = 1; // 호선
            int station1 = 122; // 왼역 이름
            int sec1 = 3600*6 + 11200; // 왼역 시작 시간
            int station2 = 120; // 오른역 이름
            int sec2 = 3600*6 + 1680; // 오른역 시작 시간

            int lineN1 = 6;
            int station3 = 602;
            int sec3 = 3600*6 + 10880;
            int station4 = 603;
            int sec4 = 3600*6 + 850;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);
            String time4 = time(sec4);

            select_line1.setImageResource(R.drawable.ho1);
            select_line2.setImageResource(R.drawable.ho6);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line1);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line6);
                    time_before.setText(time3);
                    time_after.setText(time4);
                    station_before.setText(Integer.toString(station3));
                    station_after.setText(Integer.toString(station4));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==122){
            int lineN = 1; // 호선
            int station1 = 123; // 왼역 이름
            int sec1 = 3600*6 + 12100; // 왼역 시작 시간
            int station2 = 121; // 오른역 이름
            int sec2 = 3600*6 + 780; // 오른역 시작 시간

            int lineN1 = 5;
            int station3 = 504;
            int sec3 = 3600*6 + 2400;
            int station4 = 505;
            int sec4 = 3600*6 + 1600;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);
            String time4 = time(sec4);

            select_line1.setImageResource(R.drawable.ho1);
            select_line2.setImageResource(R.drawable.ho5);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line1);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line5);
                    time_before.setText(time3);
                    time_after.setText(time4);
                    station_before.setText(Integer.toString(station3));
                    station_after.setText(Integer.toString(station4));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==123){
            int lineN = 1; // 호선
            int station1 = 101; // 왼역 이름
            int sec1 = 3600*6 + 12400; // 왼역 시작 시간
            int station2 = 118; // 오른역 이름
            int sec2 = 3600*6 + 480; // 오른역 시작 시간

            int lineN1 = 3;
            int station3 = 304;
            int sec3 = 3600*6;
            int station4 = 305;
            int sec4 = 3600*6;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);
            String time4 = time(sec4);

            select_line1.setImageResource(R.drawable.ho1);
            select_line2.setImageResource(R.drawable.ho3);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line1);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line3);
                    time_before.setText(time3);
                    time_after.setText(time4);
                    station_before.setText(Integer.toString(station3));
                    station_after.setText(Integer.toString(station4));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==201){
            int lineN = 2; // 호선
            int station1 = 202; // 왼역 이름
            int sec1 = 3600*6 + 1000; // 왼역 시작 시간
            int station2 = 101; // 오른역 이름
            int sec2 = 3600*6 + 5630; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==202){
            int lineN = 2; // 호선
            int station1 = 203; // 왼역 이름
            int sec1 = 3600*6 + 1250; // 왼역 시작 시간
            int station2 = 201; // 오른역 이름
            int sec2 = 3600*6 + 5380; // 오른역 시작 시간

            int lineN1 = 7;
            int station3 = 303;
            int sec3 = 3600*6;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);

            select_line1.setImageResource(R.drawable.ho2);
            select_line2.setImageResource(R.drawable.ho7);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line2);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line7);
                    time_before.setText("");
                    time_after.setText(time3);
                    station_before.setText("");
                    station_after.setText(Integer.toString(station3));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==203){
            int lineN = 2; // 호선
            int station1 = 204; // 왼역 이름
            int sec1 = 3600*6 + 1730; // 왼역 시작 시간
            int station2 = 202; // 오른역 이름
            int sec2 = 3600*6 + 4900; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==204){
            int lineN = 2; // 호선
            int station1 = 205; // 왼역 이름
            int sec1 = 3600*6 + 2130; // 왼역 시작 시간
            int station2 = 203; // 오른역 이름
            int sec2 = 3600*6 + 4500; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==205){
            int lineN = 2; // 호선
            int station1 = 206; // 왼역 이름
            int sec1 = 3600*6 + 2380; // 왼역 시작 시간
            int station2 = 204; // 오른역 이름
            int sec2 = 3600*6 + 4250; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==206){
            int lineN = 2; // 호선
            int station1 = 207; // 왼역 이름
            int sec1 = 3600*6 + 2880; // 왼역 시작 시간
            int station2 = 205; // 오른역 이름
            int sec2 = 3600*6 + 3750; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==207){
            int lineN = 2; // 호선
            int station1 = 208; // 왼역 이름
            int sec1 = 3600*6 + 3200; // 왼역 시작 시간
            int station2 = 206; // 오른역 이름
            int sec2 = 3600*6 + 3430; // 오른역 시작 시간

            int lineN1 = 3;
            int station3 = 301;
            int sec3 = 3600*6;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);

            select_line1.setImageResource(R.drawable.ho2);
            select_line2.setImageResource(R.drawable.ho3);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line2);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line3);
                    time_before.setText("");
                    time_after.setText(time3);
                    station_before.setText("");
                    station_after.setText(Integer.toString(station3));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==208){
            int lineN = 2; // 호선
            int station1 = 209; // 왼역 이름
            int sec1 = 3600*6 + 3450; // 왼역 시작 시간
            int station2 = 207; // 오른역 이름
            int sec2 = 3600*6 + 3180; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==209){
            int lineN = 2; // 호선
            int station1 = 210; // 왼역 이름
            int sec1 = 3600*6 + 3750; // 왼역 시작 시간
            int station2 = 208; // 오른역 이름
            int sec2 = 3600*6 + 2880; // 오른역 시작 시간

            int lineN1 = 5;
            int station3 = 501;
            int sec3 = 3600*6;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);

            select_line1.setImageResource(R.drawable.ho2);
            select_line2.setImageResource(R.drawable.ho5);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line2);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line5);
                    time_before.setText("");
                    time_after.setText(time3);
                    station_before.setText("");
                    station_after.setText(Integer.toString(station3));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==210){
            int lineN = 2; // 호선
            int station1 = 211; // 왼역 이름
            int sec1 = 3600*6 + 3900; // 왼역 시작 시간
            int station2 = 209; // 오른역 이름
            int sec2 = 3600*6 + 2730; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==211){
            int lineN = 2; // 호선
            int station1 = 212; // 왼역 이름
            int sec1 = 3600*6 + 4800; // 왼역 시작 시간
            int station2 = 210; // 오른역 이름
            int sec2 = 3600*6 + 1830; // 오른역 시작 시간

            int lineN1 = 9;
            int station3 = 621;
            int sec3 = 3600*6;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);

            select_line1.setImageResource(R.drawable.ho2);
            select_line2.setImageResource(R.drawable.ho9);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line2);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line9);
                    time_before.setText("");
                    time_after.setText(time3);
                    station_before.setText("");
                    station_after.setText(Integer.toString(station3));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==212){
            int lineN = 2; // 호선
            int station1 = 213; // 왼역 이름
            int sec1 = 3600*6 + 5120; // 왼역 시작 시간
            int station2 = 211; // 오른역 이름
            int sec2 = 3600*6 + 1510; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==213){
            int lineN = 2; // 호선
            int station1 = 214; // 왼역 이름
            int sec1 = 3600*6 + 5270; // 왼역 시작 시간
            int station2 = 212; // 오른역 이름
            int sec2 = 3600*6 + 1360; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==214){
            int lineN = 2; // 호선
            int station1 = 215; // 왼역 이름
            int sec1 = 3600*6 + 5770; // 왼역 시작 시간
            int station2 = 213; // 오른역 이름
            int sec2 = 3600*6 + 860; // 오른역 시작 시간

            int lineN1 = 8;
            int station3 = 618;
            int sec3 = 3600*6;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);

            select_line1.setImageResource(R.drawable.ho2);
            select_line2.setImageResource(R.drawable.ho8);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line2);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line8);
                    time_before.setText("");
                    time_after.setText(time3);
                    station_before.setText("");
                    station_after.setText(Integer.toString(station3));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==215){
            int lineN = 2; // 호선
            int station1 = 216; // 왼역 이름
            int sec1 = 3600*6 + 5980; // 왼역 시작 시간
            int station2 = 214; // 오른역 이름
            int sec2 = 3600*6 + 650; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==216){
            int lineN = 2; // 호선
            int station1 = 217; // 왼역 이름
            int sec1 = 3600*6 + 6130; // 왼역 시작 시간
            int station2 = 215; // 오른역 이름
            int sec2 = 3600*6 + 500; // 오른역 시작 시간

            int lineN1 = 4;
            int station3 = 417;
            int sec3 = 3600*6;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);

            select_line1.setImageResource(R.drawable.ho2);
            select_line2.setImageResource(R.drawable.ho4);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line2);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line4);
                    time_before.setText("");
                    time_after.setText(time3);
                    station_before.setText("");
                    station_after.setText(Integer.toString(station3));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==217){
            int lineN = 2; // 호선
            int station1 = 216; // 오른역 이름
            int sec1 = 3600*6; // 오른역 시작 시간

            String time1 = time(sec1);

            time_before.setText(time1);
            station_before.setText(Integer.toString(station1));
        }
       else if(station==301){
            int lineN = 3; // 호선
            int station1 = 302; // 왼역 이름
            int sec1 = 3600*6 + 300; // 왼역 시작 시간
            int station2 = 207; // 오른역 이름
            int sec2 = 3600*6 + 3760; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==302){
            int lineN = 3; // 호선
            int station1 = 303; // 왼역 이름
            int sec1 = 3600*6 + 600; // 왼역 시작 시간
            int station2 = 301; // 오른역 이름
            int sec2 = 3600*6 + 3460; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==303){
            int lineN = 3; // 호선
            int station1 = 304; // 왼역 이름
            int sec1 = 3600*6 + 1080; // 왼역 시작 시간
            int station2 = 302; // 오른역 이름
            int sec2 = 3600*6 + 2980; // 오른역 시작 시간

            int lineN1 = 7;
            int station3 = 202;
            int sec3 = 3600*6 + 5140;
            int station4 = 503;
            int sec4 = 3600*6 + 1000;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);
            String time4 = time(sec4);

            select_line1.setImageResource(R.drawable.ho3);
            select_line2.setImageResource(R.drawable.ho7);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line3);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line7);
                    time_before.setText(time3);
                    time_after.setText(time4);
                    station_before.setText(Integer.toString(station3));
                    station_after.setText(Integer.toString(station4));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==304){
            int lineN = 3; // 호선
            int station1 = 123; // 왼역 이름
            int sec1 = 3600*6 + 1480; // 왼역 시작 시간
            int station2 = 303; // 오른역 이름
            int sec2 = 3600*6 + 2580; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);

            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==305){
            int lineN = 3; // 호선
            int station1 = 306; // 왼역 이름
            int sec1 = 3600*6 + 2030; // 왼역 시작 시간
            int station2 = 123; // 오른역 이름
            int sec2 = 3600*6 + 2030; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==306){
            int lineN = 3; // 호선
            int station1 = 307; // 왼역 이름
            int sec1 = 3600*6 + 2280; // 왼역 시작 시간
            int station2 = 305; // 오른역 이름
            int sec2 = 3600*6 + 1780; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==307){
            int lineN = 3; // 호선
            int station1 = 308; // 왼역 이름
            int sec1 = 3600*6 + 3180; // 왼역 시작 시간
            int station2 = 306; // 오른역 이름
            int sec2 = 3600*6 + 880; // 오른역 시작 시간

            int lineN1 = 4;
            int station3 = 402;
            int sec3 = 3600*6 + 1150;
            int station4 = 401;
            int sec4 = 3600*6 + 8000;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);
            String time4 = time(sec4);

            select_line1.setImageResource(R.drawable.ho3);
            select_line2.setImageResource(R.drawable.ho4);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line3);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line4);
                    time_before.setText(time3);
                    time_after.setText(time4);
                    station_before.setText(Integer.toString(station3));
                    station_after.setText(Integer.toString(station4));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==308){

            int lineN = 3; // 호선
            int station1 = 309; // 왼역 이름
            int sec1 = 3600*6 + 3660; // 왼역 시작 시간
            int station2 = 307; // 오른역 이름
            int sec2 = 3600*6 + 400; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
         else if(station==401){
            int lineN = 4; // 호선
            int station1 = 307; // 왼역 이름
            int sec1 = 3600*6 + 1000; // 왼역 시작 시간
            int station2 = 104; // 오른역 이름
            int sec2 = 3600*6 + 8150; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);

            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==402){
            int lineN = 4; // 호선
            int station1 = 403; // 왼역 이름
            int sec1 = 3600*6 + 1450; // 왼역 시작 시간
            int station2 = 307; // 오른역 이름
            int sec2 = 3600*6 + 7700; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==403){
            int lineN = 4; // 호선
            int station1 = 404; // 왼역 이름
            int sec1 = 3600*6 + 1660; // 왼역 시작 시간
            int station2 = 402; // 오른역 이름
            int sec2 = 3600*6 + 7490; // 오른역 시작 시간

            int lineN1 = 5;
            int station3 = 506;
            int sec3 = 3600*6 + 1300;
            int station4 = 507;
            int sec4 = 3600*6 + 2700;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);
            String time4 = time(sec4);

            select_line1.setImageResource(R.drawable.ho4);
            select_line2.setImageResource(R.drawable.ho5);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line4);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line5);
                    time_before.setText(time3);
                    time_after.setText(time4);
                    station_before.setText(Integer.toString(station3));
                    station_after.setText(Integer.toString(station4));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==404){
            int lineN = 4; // 호선
            int station1 = 405; // 왼역 이름
            int sec1 = 3600*6 + 1980; // 왼역 시작 시간
            int station2 = 403; // 오른역 이름
            int sec2 = 3600*6 + 7170; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==405){
            int lineN = 4; // 호선
            int station1 = 406; // 왼역 이름
            int sec1 = 3600*6 + 2190; // 왼역 시작 시간
            int station2 = 404; // 오른역 이름
            int sec2 = 3600*6 + 6960; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==406){
            int lineN = 4; // 호선
            int station1 = 407; // 왼역 이름
            int sec1 = 3600*6 + 2690; // 왼역 시작 시간
            int station2 = 405; // 오른역 이름
            int sec2 = 3600*6 + 6460; // 오른역 시작 시간

            int lineN1 = 9;
            int station3 = 901;
            int sec3 = 3600*6 + 3320;
            int station4 = 605;
            int sec4 = 3600*6 + 900;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);
            String time4 = time(sec4);

            select_line1.setImageResource(R.drawable.ho4);
            select_line2.setImageResource(R.drawable.ho9);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line4);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line9);
                    time_before.setText(time3);
                    time_after.setText(time4);
                    station_before.setText(Integer.toString(station3));
                    station_after.setText(Integer.toString(station4));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==407){
            int lineN = 4; // 호선
            int station1 = 408; // 왼역 이름
            int sec1 = 3600*6 + 2990; // 왼역 시작 시간
            int station2 = 406; // 오른역 이름
            int sec2 = 3600*6 + 6160; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==408){
            int lineN = 4; // 호선
            int station1 = 409; // 왼역 이름
            int sec1 = 3600*6 + 3790; // 왼역 시작 시간
            int station2 = 115; // 오른역 이름
            int sec2 = 3600*6 + 5360; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);

            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==409){
            int lineN = 4; // 호선
            int station1 = 410; // 왼역 이름
            int sec1 = 3600*6 + 4090; // 왼역 시작 시간
            int station2 = 408; // 오른역 이름
            int sec2 = 3600*6 + 5060; // 오른역 시작 시간

            int lineN1 = 8;
            int station3 = 803;
            int sec3 = 3600*6 + 3110;
            int station4 = 608;
            int sec4 = 3600*6 + 2900;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);
            String time4 = time(sec4);

            select_line1.setImageResource(R.drawable.ho4);
            select_line2.setImageResource(R.drawable.ho8);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line4);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line8);
                    time_before.setText(time3);
                    time_after.setText(time4);
                    station_before.setText(Integer.toString(station3));
                    station_after.setText(Integer.toString(station4));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==410){
            int lineN = 4; // 호선
            int station1 = 411; // 왼역 이름
            int sec1 = 3600*6 + 4570; // 왼역 시작 시간
            int station2 = 409; // 오른역 이름
            int sec2 = 3600*6 + 4580; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==411){
            int lineN = 4; // 호선
            int station1 = 412; // 왼역 이름
            int sec1 = 3600*6 + 4870; // 왼역 시작 시간
            int station2 = 410; // 오른역 이름
            int sec2 = 3600*6 + 4280; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==412){
            int lineN = 4; // 호선
            int station1 = 413; // 왼역 이름
            int sec1 = 3600*6 + 5770; // 왼역 시작 시간
            int station2 = 411; // 오른역 이름
            int sec2 = 3600*6 + 3380; // 오른역 시작 시간

            int lineN1 = 6;
            int station3 = 609;
            int sec3 = 3600*6 + 7080;
            int station4 = 610;
            int sec4 = 3600*6 + 4170;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);
            String time4 = time(sec4);

            select_line1.setImageResource(R.drawable.ho4);
            select_line2.setImageResource(R.drawable.ho6);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line4);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line6);
                    time_before.setText(time3);
                    time_after.setText(time4);
                    station_before.setText(Integer.toString(station3));
                    station_after.setText(Integer.toString(station4));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==413){
            int lineN = 4; // 호선
            int station1 = 413; // 왼역 이름
            int sec1 = 3600*6 + 6170; // 왼역 시작 시간
            int station2 = 412; // 오른역 이름
            int sec2 = 3600*6 + 2980; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==414){
            int lineN = 4; // 호선
            int station1 = 415; // 왼역 이름
            int sec1 = 3600*6 + 6600; // 왼역 시작 시간
            int station2 = 413; // 오른역 이름
            int sec2 = 3600*6 + 2550; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==415){
            int lineN = 4; // 호선
            int station1 = 416; // 왼역 이름
            int sec1 = 3600*6 + 6750; // 왼역 시작 시간
            int station2 = 414; // 오른역 이름
            int sec2 = 3600*6 + 2400; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==416){
            int lineN = 4; // 호선
            int station1 = 417; // 왼역 이름
            int sec1 = 3600*6 + 7750; // 왼역 시작 시간
            int station2 = 415; // 오른역 이름
            int sec2 = 3600*6 + 1400; // 오른역 시작 시간

            int lineN1 = 7;
            int station3 = 706;
            int sec3 = 3600*6 + 910;
            int station4 = 707;
            int sec4 = 3600*6 + 5230;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);
            String time4 = time(sec4);

            select_line1.setImageResource(R.drawable.ho4);
            select_line2.setImageResource(R.drawable.ho7);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line4);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line7);
                    time_before.setText(time3);
                    time_after.setText(time4);
                    station_before.setText(Integer.toString(station3));
                    station_after.setText(Integer.toString(station4));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==417){
            int lineN = 4; // 호선
            int station1 = 216; // 왼역 이름
            int sec1 = 3600*6 + 8250; // 왼역 시작 시간
            int station2 = 416; // 오른역 이름
            int sec2 = 3600*6 + 900; // 오른역 시작 시간

            int lineN1 = 6;
            int station3 = 616;
            int sec3 = 3600*6 + 2520;
            int station4 = 617;
            int sec4 = 3600*6 + 8830;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);
            String time4 = time(sec4);

            select_line1.setImageResource(R.drawable.ho4);
            select_line2.setImageResource(R.drawable.ho6);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line4);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line6);
                    time_before.setText(time3);
                    time_after.setText(time4);
                    station_before.setText(Integer.toString(station3));
                    station_after.setText(Integer.toString(station4));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
       else if(station==501){
            int lineN = 5; // 호선
            int station1 = 209; // 왼역 이름
            int sec1 = 3600*6 + 3680; // 왼역 시작 시간
            int station2 = 502; // 오른역 이름
            int sec2 = 3600*6  + 320; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==502){
            int lineN = 5; // 호선
            int station1 = 501; // 왼역 이름
            int sec1 = 3600*6 + 3360; // 왼역 시작 시간
            int station2 = 503; // 오른역 이름
            int sec2 = 3600*6  + 640; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==503){
            int lineN = 1; // 호선
            int station1 = 502; // 왼역 이름
            int sec1 = 3600*6 + 2930; // 왼역 시작 시간
            int station2 = 504; // 오른역 이름
            int sec2 = 3600*6 + 1070; // 오른역 시작 시간

            int lineN1 = 7;
            int station3 = 303;
            int sec3 = 3600*6 + 4440;
            int station4 = 601;
            int sec4 = 3600*6 + 1700;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);
            String time4 = time(sec4);

            select_line1.setImageResource(R.drawable.ho5);
            select_line2.setImageResource(R.drawable.ho7);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line5);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line7);
                    time_before.setText(time3);
                    time_after.setText(time4);
                    station_before.setText(Integer.toString(station3));
                    station_after.setText(Integer.toString(station4));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==504){
            int lineN = 5; // 호선
            int station1 = 503; // 왼역 이름
            int sec1 = 3600*6 + 2720; // 왼역 시작 시간
            int station2 = 122; // 오른역 이름
            int sec2 = 3600*6  + 1280; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==505){
            int lineN = 5; // 호선
            int station1 = 122; // 왼역 이름
            int sec1 = 3600*6 + 1920; // 왼역 시작 시간
            int station2 = 506; // 오른역 이름
            int sec2 = 3600*6  + 2080; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==506){
            int lineN = 5; // 호선
            int station1 = 505; // 왼역 이름
            int sec1 = 3600*6 + 1620; // 왼역 시작 시간
            int station2 = 403; // 오른역 이름
            int sec2 = 3600*6 + 2380; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==507){
            int lineN = 5; // 호선
            int station1 = 403; // 왼역 이름
            int sec1 = 3600*6 + 1000; // 왼역 시작 시간
            int station2 = 109; // 오른역 이름
            int sec2 = 3600*6 + 3000; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==601){
            int lineN = 6; // 호선
            int station1 = 622; // 왼역 이름
            int sec1 = 3600*6; // 왼역 시작 시간
            int station2 = 602; // 오른역 이름
            int sec2 = 3600*6; // 오른역 시작 시간

            int lineN1 = 7;
            int station3 = 503;
            int sec3 = 3600*6 + 3940;
            int station4 = 701;
            int sec4 = 3600*6 + 2200;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);
            String time4 = time(sec4);

            select_line1.setImageResource(R.drawable.ho6);
            select_line2.setImageResource(R.drawable.ho7);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line6);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line7);
                    time_before.setText(time3);
                    time_after.setText(time4);
                    station_before.setText(Integer.toString(station3));
                    station_after.setText(Integer.toString(station4));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==602){
            int lineN = 6; // 호선
            int station1 = 601; // 왼역 이름
            int sec1 = 3600*6 + 11580; // 왼역 시작 시간
            int station2 = 121; // 오른역 이름
            int sec2 = 3600*6 + 150; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==603){
            int lineN = 6; // 호선
            int station1 = 121; // 왼역 이름
            int sec1 = 3600*6  + 10380; // 왼역 시작 시간
            int station2 = 604; // 오른역 이름
            int sec2 = 3600*6 + 1350; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);

            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==604){
            int lineN = 6; // 호선
            int station1 = 603; // 왼역 이름
            int sec1 = 3600*6 + 10080; // 왼역 시작 시간
            int station2 = 605; // 오른역 이름
            int sec2 = 3600*6  + 1650; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==605){
            int lineN = 6; // 호선
            int station1 = 604; // 왼역 이름
            int sec1 = 3600*6 + 9650; // 왼역 시작 시간
            int station2 = 606; // 오른역 이름
            int sec2 = 3600*6  + 2080; // 오른역 시작 시간

            int lineN1 = 9;
            int station3 = 406;
            int sec3 = 3600*6 + 3110;
            int station4 = 902;
            int sec4 = 3600*6 + 1100;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);
            String time4 = time(sec4);

            select_line1.setImageResource(R.drawable.ho6);
            select_line2.setImageResource(R.drawable.ho9);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line6);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line9);
                    time_before.setText(time3);
                    time_after.setText(time4);
                    station_before.setText(Integer.toString(station3));
                    station_after.setText(Integer.toString(station4));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==606){
            int lineN = 6; // 호선
            int station1 = 605; // 왼역 이름
            int sec1 = 3600*6 + 9170; // 왼역 시작 시간
            int station2 = 116; // 오른역 이름
            int sec2 = 3600*6 + 2080; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);

            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==607){
            int lineN = 6; // 호선
            int station1 = 116; // 왼역 이름
            int sec1 = 3600*6 + 8600; // 왼역 시작 시간
            int station2 = 608; // 오른역 이름
            int sec2 = 3600*6 + 2650; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==608){
            int lineN = 6; // 호선
            int station1 = 607; // 왼역 이름
            int sec1 = 3600*6 + 8100; // 왼역 시작 시간
            int station2 = 609; // 오른역 이름
            int sec2 = 3600*6 + 3150; // 오른역 시작 시간

            int lineN1 = 8;
            int station3 = 409;
            int sec3 = 3600*6 + 2610;
            int station4 = 804;
            int sec4 = 3600*6 + 3400;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);
            String time4 = time(sec4);

            select_line1.setImageResource(R.drawable.ho6);
            select_line2.setImageResource(R.drawable.ho8);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line6);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line8);
                    time_before.setText(time3);
                    time_after.setText(time4);
                    station_before.setText(Integer.toString(station3));
                    station_after.setText(Integer.toString(station4));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==609){
            int lineN = 6; // 호선
            int station1 = 608; // 왼역 이름
            int sec1 = 3600*6 + 7400; // 왼역 시작 시간
            int station2 = 412; // 오른역 이름
            int sec2 = 3600*6 + 3850; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);

            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==610){
            int lineN = 6; // 호선
            int station1 = 412; // 왼역 이름
            int sec1 = 3600*6 + 6080; // 왼역 시작 시간
            int station2 = 611; // 오른역 이름
            int sec2 = 3600*6 + 5170; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==611){
            int lineN = 6; // 호선
            int station1 = 610; // 왼역 이름
            int sec1 = 3600*6 + 5380; // 왼역 시작 시간
            int station2 = 612; // 오른역 이름
            int sec2 = 3600*6 + 5870; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==612){
            int lineN = 6; // 호선
            int station1 = 611; // 왼역 이름
            int sec1 = 3600*6 + 4680; // 왼역 시작 시간
            int station2 = 613; // 오른역 이름
            int sec2 = 3600*6 + 6570; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==613){
            int lineN = 6; // 호선
            int station1 = 612; // 왼역 이름
            int sec1 = 3600*6 + 4530; // 왼역 시작 시간
            int station2 = 614; // 오른역 이름
            int sec2 = 3600*6  + 6720; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==614){
            int lineN = 6; // 호선
            int station1 = 613; // 왼역 이름
            int sec1 = 3600*6 + 4200; // 왼역 시작 시간
            int station2 = 615; // 오른역 이름
            int sec2 = 3600*6 + 7150; // 오른역 시작 시간

            int lineN1 = 7;
            int station3 = 707;
            int sec3 = 3600*6;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);

            select_line1.setImageResource(R.drawable.ho6);
            select_line2.setImageResource(R.drawable.ho7);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line6);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line7);
                    time_before.setText("");
                    time_after.setText(time3);
                    station_before.setText("");
                    station_after.setText(Integer.toString(station3));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==615){
            int lineN = 6; // 호선
            int station1 = 614; // 왼역 이름
            int sec1 = 3600*6 + 3700; // 왼역 시작 시간
            int station2 = 616; // 오른역 이름
            int sec2 = 3600*6 + 7650; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==616){
            int lineN = 6; // 호선
            int station1 = 615; // 왼역 이름
            int sec1 = 3600*6 + 3000; // 왼역 시작 시간
            int station2 = 417; // 오른역 이름
            int sec2 = 3600*6 + 8350; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);

            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==617){
            int lineN = 6; // 호선
            int station1 = 417; // 왼역 이름
            int sec1 = 3600*6 + 2200; // 왼역 시작 시간
            int station2 = 618; // 오른역 이름
            int sec2 = 3600*6 + 9150; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==618){
            int lineN = 6; // 호선
            int station1 = 617; // 왼역 이름
            int sec1 = 3600*6 + 1900; // 왼역 시작 시간
            int station2 = 619; // 오른역 이름
            int sec2 = 3600*6 + 9450; // 오른역 시작 시간

            int lineN1 = 8;
            int station3 = 705;
            int sec3 = 3600*6 + 700;
            int station4 = 214;
            int sec4 = 3600*6 + 5310;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);
            String time4 = time(sec4);

            select_line1.setImageResource(R.drawable.ho6);
            select_line2.setImageResource(R.drawable.ho8);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line6);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line8);
                    time_before.setText(time3);
                    time_after.setText(time4);
                    station_before.setText(Integer.toString(station3));
                    station_after.setText(Integer.toString(station4));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==619){
            int lineN = 6; // 호선
            int station1 = 618; // 왼역 이름
            int sec1 = 3600*6 + 1650; // 왼역 시작 시간
            int station2 = 620; // 오른역 이름
            int sec2 = 3600*6 + 9700; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==620){
            int lineN = 6; // 호선
            int station1 = 619; // 왼역 이름
            int sec1 = 3600*6 + 950; // 왼역 시작 시간
            int station2 = 621; // 오른역 이름
            int sec2 = 3600*6 + 10400; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==621){
            int lineN = 6; // 호선
            int station1 = 620; // 왼역 이름
            int sec1 = 3600*6 + 630; // 왼역 시작 시간
            int station2 = 622; // 오른역 이름
            int sec2 = 3600*6 + 10720; // 오른역 시작 시간

            int lineN1 = 9;
            int station3 = 904;
            int sec3 = 3600*6 + 300;
            int station4 = 211;
            int sec4 = 3600*6 + 3410;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);
            String time4 = time(sec4);

            select_line1.setImageResource(R.drawable.ho6);
            select_line2.setImageResource(R.drawable.ho9);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line6);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line9);
                    time_before.setText(time3);
                    time_after.setText(time4);
                    station_before.setText(Integer.toString(station3));
                    station_after.setText(Integer.toString(station4));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==622){
            int lineN = 6; // 호선
            int station1 = 621; // 왼역 이름
            int sec1 = 3600*6 + 150; // 왼역 시작 시간
            int station2 = 601; // 오른역 이름
            int sec2 = 3600*6 + 11200; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==701){
            int lineN = 7; // 호선
            int station1 = 601; // 왼역 이름
            int sec1 = 3600*6 + 3510; // 왼역 시작 시간
            int station2 = 702; // 오른역 이름
            int sec2 = 3600*6 + 2630; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==702){
            int lineN = 7; // 호선
            int station1 = 701; // 왼역 이름
            int sec1 = 3600*6 + 3360; // 왼역 시작 시간
            int station2 = 703; // 오른역 이름
            int sec2 = 3600*6 + 2780; // 오른역 시작 시간

            int lineN1 = 9;
            int station3 = 903;
            int sec3 = 3600*6 + 1050;
            int station4 = 904;
            int sec4 = 3600*6 + 3160;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);
            String time4 = time(sec4);

            select_line1.setImageResource(R.drawable.ho7);
            select_line2.setImageResource(R.drawable.ho9);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line7);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line9);
                    time_before.setText(time3);
                    time_after.setText(time4);
                    station_before.setText(Integer.toString(station3));
                    station_after.setText(Integer.toString(station4));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==703){
            int lineN = 7; // 호선
            int station1 = 702; // 왼역 이름
            int sec1 = 3600*6 + 2760; // 왼역 시작 시간
            int station2 = 704; // 오른역 이름
            int sec2 = 3600*6 + 3380; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==704){
            int lineN = 7; // 호선
            int station1 = 703; // 왼역 이름
            int sec1 = 3600*6 + 2060; // 왼역 시작 시간
            int station2 = 705; // 오른역 이름
            int sec2 = 3600*6 + 4080; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==705){
            int lineN = 7; // 호선
            int station1 = 704; // 왼역 이름
            int sec1 = 3600*6 + 1810; // 왼역 시작 시간
            int station2 = 706; // 오른역 이름
            int sec2 = 3600*6 + 4330; // 오른역 시작 시간

            int lineN1 = 8;
            int station3 = 806;
            int sec3 = 3600*6 + 950;
            int station4 = 618;
            int sec4 = 3600*6 + 5060;

            String time1 = time(sec1);
            String time2 = time(sec2);
            String time3 = time(sec3);
            String time4 = time(sec4);

            select_line1.setImageResource(R.drawable.ho7);
            select_line2.setImageResource(R.drawable.ho8);

            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));

            select_line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line7);
                    time_before.setText(time1);
                    time_after.setText(time2);
                    station_before.setText(Integer.toString(station1));
                    station_after.setText(Integer.toString(station2));
                }
            });
            select_line2 = (ImageButton)findViewById(R.id.select_line2);
            select_line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    line_border.setImageResource(R.drawable.line8);
                    time_before.setText(time3);
                    time_after.setText(time4);
                    station_before.setText(Integer.toString(station3));
                    station_after.setText(Integer.toString(station4));
                }
            });

            time_before.setText(time1);
            time_after.setText(time2);
        }
        else if(station==706){
            int lineN = 7; // 호선
            int station1 = 705; // 왼역 이름
            int sec1 = 3600*6 + 1210; // 왼역 시작 시간
            int station2 = 416; // 오른역 이름
            int sec2 = 3600*6 + 4930; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==707){
            int lineN = 7; // 호선
            int station1 = 416; // 왼역 이름
            int sec1 = 3600*6 + 480; // 왼역 시작 시간
            int station2 = 614; // 오른역 이름
            int sec2 = 3600*6 + 5660; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==801){
            int lineN = 8; // 호선
            int station1 = 113; // 왼역 이름
            int sec1 = 3600*6 + 5410; // 왼역 시작 시간
            int station2 = 802; // 오른역 이름
            int sec2 = 3600*6 + 600; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==802){
            int lineN = 8; // 호선
            int station1 = 801; // 왼역 이름
            int sec1 = 3600*6 + 4410; // 왼역 시작 시간
            int station2 = 803; // 오른역 이름
            int sec2 = 3600*6 + 1600; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==803){
            int lineN = 8; // 호선
            int station1 = 802; // 왼역 이름
            int sec1 = 3600*6 + 3710; // 왼역 시작 시간
            int station2 = 409; // 오른역 이름
            int sec2 = 3600*6 + 2300; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);

            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==804){
            int lineN = 8; // 호선
            int station1 = 608; // 왼역 이름
            int sec1 = 3600*6 + 1910; // 왼역 시작 시간
            int station2 = 805; // 오른역 이름
            int sec2 = 3600*6 + 4100; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==805){
            int lineN = 8; // 호선
            int station1 = 804; // 왼역 이름
            int sec1 = 3600*6 + 1760; // 왼역 시작 시간
            int station2 = 806; // 오른역 이름
            int sec2 = 3600*6 + 4250; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==806){
            int lineN = 8; // 호선
            int station1 = 805; // 왼역 이름
            int sec1 = 3600*6 + 1550; // 왼역 시작 시간
            int station2 = 705; // 오른역 이름
            int sec2 = 3600*6  + 4460; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==901){
            int lineN = 9; // 호선
            int station1 = 112; // 왼역 이름
            int sec1 = 3600*6 + 3620; // 왼역 시작 시간
            int station2 = 406; // 오른역 이름
            int sec2 = 3600*6 + 600; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==902){
            int lineN = 9; // 호선
            int station1 = 605; // 왼역 이름
            int sec1 = 3600*6 + 2630; // 왼역 시작 시간
            int station2 = 119; // 오른역 이름
            int sec2 = 3600*6 + 1580; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==903){
            int lineN = 9; // 호선
            int station1 = 119; // 왼역 이름
            int sec1 = 3600*6 + 1200; // 왼역 시작 시간
            int station2 = 702; // 오른역 이름
            int sec2 = 3600*6 + 3010; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
        else if(station==904){
            int lineN = 9; // 호선
            int station1 = 702; // 왼역 이름
            int sec1 = 3600*6 + 550; // 왼역 시작 시간
            int station2 = 621; // 오른역 이름
            int sec2 = 3600*6 + 3660; // 오른역 시작 시간

            String time1 = time(sec1);
            String time2 = time(sec2);
            time_before.setText(time1);
            time_after.setText(time2);
            station_before.setText(Integer.toString(station1));
            station_after.setText(Integer.toString(station2));
        }
    }
}
