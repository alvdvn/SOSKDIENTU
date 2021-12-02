package com.example.soskdientu.activity.Dangnhap_Dawngky;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.soskdientu.R;
import com.example.soskdientu.activity.CaNhanActivity;
import com.example.soskdientu.model.Nguoidung;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SigninActivity extends AppCompatActivity {
    EditText sdt,pass ,repass;
    CheckBox cbdk;
    Button btnsigin;
    String sodt,mk,rmk;

    List<Nguoidung> listnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        sdt =findViewById(R.id.Sdt);
        pass = findViewById(R.id.Password1);
        repass = findViewById(R.id.RPassword);
        cbdk = findViewById(R.id.cbdk);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference   myreb = database.getReference("user");

        btnsigin = findViewById( R.id.btnDangky);
        listnd = new ArrayList<>();

        getlistuser();





        btnsigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sodt = sdt.getText().toString();
                mk = pass.getText().toString();
                rmk= repass.getText().toString();


                try {
                if(sodt.isEmpty() || mk.isEmpty() || rmk.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Mời nhập đầy đủ thông tin trước khi đăng ký", Toast.LENGTH_SHORT).show();
                    clear();
                    return;
                }
                if(sdt.length()!=10){
                    Toast.makeText(getApplicationContext(), "Số điện thoại không hợp lệ , mời kiểm tra lại", Toast.LENGTH_SHORT).show();
                    clear();
                    return;
                }
                if(mk.length()<6){
                    Toast.makeText(getApplicationContext(), "Mật khẩu phải nhiều hơn 6 ký tự ", Toast.LENGTH_SHORT).show();
                    clear();
                    return;

                }
                if(checkrepass(mk,rmk)==false){
                    Toast.makeText(getApplicationContext(), "Nhập lại mật khẩu không khớp, mời nhập lại ", Toast.LENGTH_SHORT).show();
                    clear();
                    return;
                }
                if (checktrung(sodt)==true){
                    Toast.makeText(getApplicationContext(), "Số điện thoại đã tồn tại", Toast.LENGTH_SHORT).show();
                    return;
                }

                }catch(Exception e){
                    Log.e("Lỗi", "onClick: ",e );
                }

                Nguoidung  user = new Nguoidung(sodt,mk);
                myreb.child(user.getUsername()).child(user.getUsername()).setValue(user, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        Toast.makeText(getApplicationContext(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SigninActivity.this, CaNhanActivity.class);
                        intent.putExtra("sdt",sodt);
                        startActivity(intent);
                    }
                });

            }
        });
    }

    private boolean checkrepass(String pass,String rpass){
        Boolean check = false;
        if(pass.equals(rpass)){
            check =true;
        }

        return check;
    }
    private void clear(){
        sdt.setText("");
        pass.setText("");
        repass.setText("");
    }
    private boolean checktrung(String so)  {
        boolean check=false;
        for (Nguoidung x:listnd) {
            if(x.getUsername().equals(so)){
                check =true;
            }
        }


      return check;
    }
    private void getlistuser(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference   myreb = database.getReference("user");
        myreb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Nguoidung nguoidung = dataSnapshot.getValue(Nguoidung.class);
                    listnd.add(nguoidung);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "ko thể kết nối sv", Toast.LENGTH_SHORT).show();
            }
        });


    }
}