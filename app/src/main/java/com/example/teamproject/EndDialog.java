package com.example.teamproject;

import android.app.Activity;
import android.app.Dialog;

import android.content.Context;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;


import android.view.View;

import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class EndDialog extends Activity implements View.OnClickListener{ //도넛모양의 레이아웃입니다.

    private TimeTable table;

    private Context mContext;
    private ImageView btn_station_in;
    private ImageView btn_center;
    private ImageView btn_depart;
    private ImageView btn_dest;
    private ImageView btn_timetable;
    public TextView center_text;
    private StringBuilder sb;
    private String route="";
    String depart="",dest="";
    int int_depart=0, int_dest=0;

    int station;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setContentView(R.layout.dialog_end);

        btn_station_in = (ImageView) findViewById(R.id.btn_station_in);
        btn_center = (ImageView) findViewById(R.id.btn_center);
        btn_depart = (ImageView) findViewById(R.id.btn_depart);
        btn_dest = (ImageView) findViewById(R.id.btn_dest);
        btn_timetable = (ImageView)findViewById(R.id.txt8);
        center_text = (TextView) findViewById(R.id.center_text);

        btn_center.setOnClickListener(this);
        btn_dest.setOnClickListener(this);
        btn_depart.setOnClickListener(this);
        btn_timetable.setOnClickListener(this);
        center_text.setOnClickListener(this);

        Intent intent = getIntent();
        station = intent.getExtras().getInt("station");
        center_text.setText(Integer.toString(station));

    }

    @Override

    public void onClick(View v) { // 여기에서 클릭 이벤트 작업하세요

        switch (v.getId()) {

            case  R.id.txt8:
                table = new TimeTable(this);
                table.setStation(station);
                table.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                table.requestWindowFeature(Window.FEATURE_NO_TITLE);
                table.setCancelable(true);
                table.show();
                //Toast.makeText(getApplicationContext(), Integer.toString(station), Toast.LENGTH_SHORT).show();
                break;


            case R.id.btn_depart: /// 도출 출출

                Intent intent = getIntent();
                station = intent.getExtras().getInt("station");
                int_depart = intent.getExtras().getInt("depart_station");
                int_dest = intent.getExtras().getInt("dest_station");


                if(int_dest!=0 && int_depart==0){ // 도출

                    Intent newIntent = new Intent(this,Popup_dijkstra.class);
                    newIntent.putExtra("depart",station);
                    newIntent.putExtra("dest",int_dest);
                    startActivity(newIntent);

                    Intent resultintent = new Intent();
                    resultintent.putExtra("depart_station",station);
                    resultintent.putExtra("reset_code",1);
                    setResult(1, resultintent);

                    //출발지,도착지,경로 초기화
                    depart = "";
                    dest = "";
                    route = "";

                    finish();

                }

                else if(int_dest==0 && int_depart!=0){ // 출출

                    Intent resultintent = new Intent();
                    resultintent.putExtra("depart_station",station);
                    resultintent.putExtra("reset_code",0);
                    setResult(1, resultintent);

                    //출발지,도착지,경로 초기화
                    depart = "";
                    dest = "";
                    route = "";

                    finish();

                }
                Intent resultintent = new Intent();
                resultintent.putExtra("depart_station",station);
                setResult(1, resultintent);
                finish();

                break;

            case R.id.btn_dest:

                Intent dest_intent = getIntent();
                station = dest_intent.getExtras().getInt("station");
                int_depart = dest_intent.getExtras().getInt("depart_station");
                int_dest = dest_intent.getExtras().getInt("dest_station");

                if(int_dest==0 && int_depart!=0){ // 출도

                    Intent newIntent = new Intent(this,Popup_dijkstra.class);
                    newIntent.putExtra("depart",int_depart);
                    newIntent.putExtra("dest",station);
                    startActivity(newIntent);

                    Intent dest_resultintent = new Intent();
                    //dest_resultintent.putExtra("depart_station",station);
                    dest_resultintent.putExtra("reset_code",1);
                    setResult(2, dest_resultintent);

                    //출발지,도착지,경로 초기화
                    depart = "";
                    dest = "";
                    route = "";

                    finish();

                }

                else if(int_dest==0 && int_depart!=0){ // 도도

                    Intent dest_resultintent = new Intent();
                    dest_resultintent.putExtra("dest_station",station);
                    dest_resultintent.putExtra("reset_code",0);
                    setResult(1, dest_resultintent);

                    //출발지,도착지,경로 초기화
                    depart = "";
                    dest = "";
                    route = "";

                    finish();

                }
                else {

                    Intent resultintent2 = new Intent();
                    resultintent2.putExtra("dest_station", station);
                    setResult(2, resultintent2);
                    finish();
                }
                break;
        }
    }
}

