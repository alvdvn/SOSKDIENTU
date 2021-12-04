package com.example.soskdientu.activity.DatLichKham;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.soskdientu.R;
import com.example.soskdientu.activity.CaNhanActivity;
import com.example.soskdientu.activity.HomeActivity;
import com.example.soskdientu.model.CaNhan;
import com.example.soskdientu.model.DatLichKham;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class InfoActivity extends AppCompatActivity {
    EditText hoten, cmnd, ngaykham, giokham, trieuchung;
    CheckBox bhyt;
    ImageView back;
    Button xacnhan;
    List<CaNhan> listcn;
    CaNhan caNhan;
    String sdt;
    DatePickerDialog.OnDateSetListener setListener;
    int hour1,minute1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        anhxa();
        Intent intent =getIntent();
        Bundle bundle = intent.getExtras();
        sdt = bundle.getString("sdt");

        getlistuser(sdt);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month =month+1;
                String date =day+"/"+month+"/"+year;

            }
        };
        ngaykham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        InfoActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        String date  = day+"/"+month+"/"+year;
                        ngaykham.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
        giokham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        InfoActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        hour1 = hourOfDay;
                        minute1 = minute;
                        String time = hour1+":"+minute1;
                        SimpleDateFormat f24hour = new SimpleDateFormat(
                                "HH:mm"
                        );
                        try {
                            Date date =f24hour.parse(time);
                            SimpleDateFormat f12hour = new SimpleDateFormat(
                                    "hh:mm aa"
                            );
                            giokham.setText(f12hour.format(date));

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                    }
                },12,0,false
                );
                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(hour1,minute1);
                timePickerDialog.show();
            }
        });
        xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myreb = database.getReference("user/"+sdt);
                DatLichKham lich = new DatLichKham(
                        hoten.getText().toString(),cmnd.getText().toString(),
                        ngaykham.getText().toString(),giokham.getText().toString(),trieuchung.getText().toString(),bhyt()

                );
                myreb.child("LichKham").child(ngaykham.getText().toString()).setValue(lich, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        Toast.makeText(getApplicationContext(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(InfoActivity.this, ChitietActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("sdt",sdt);
                        bundle.putString("hoten",hoten.getText().toString());
                        bundle.putString("cmnd",cmnd.getText().toString());
                        bundle.putString("ngaykham",ngaykham.getText().toString());
                        bundle.putString("giokham",giokham.getText().toString());
                        bundle.putString("trieuchung",trieuchung.getText().toString());
                        bundle.putString("bhyt",bhyt());
                        intent1.putExtras(bundle);
                        startActivity(intent1);
                    }
                });
            }
        });

    }
    private  String bhyt(){
        String bh;
        if (bhyt.isSelected()){
            bh = "Có";
        }
        else{
            bh="Không";
        }
        return bh;
    }

    private  void anhxa(){
        hoten =findViewById(R.id.ed_hvtdl);
        cmnd = findViewById(R.id.ed_cmnddl);
        ngaykham =findViewById(R.id.ed_date);
        giokham = findViewById(R.id.ed_time);
        trieuchung =findViewById(R.id.ed_trieuchung);
        bhyt = findViewById(R.id.cb_bhyt);
        back = findViewById(R.id.btnback);
        xacnhan = findViewById(R.id.btnxacnhan);
    }
    private void getlistuser(String sdt1){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myreb = database.getReference("user/"+sdt1+"/HoSoCaNhan");
        myreb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    caNhan = dataSnapshot.getValue(CaNhan.class);


                }
                hoten.setText(caNhan.getHoTen());
                cmnd.setText(caNhan.getSoCanCuoc());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "ko thể kết nối sv", Toast.LENGTH_SHORT).show();
            }

        });


    }
}