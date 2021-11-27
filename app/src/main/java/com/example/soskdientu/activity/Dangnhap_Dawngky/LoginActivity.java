package com.example.soskdientu.activity.Dangnhap_Dawngky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.soskdientu.R;
import com.example.soskdientu.activity.HomeActivity;
import com.example.soskdientu.model.Nguoidung;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    EditText User,Pass;
    Button btnlogin,btnsigin;
    List<Nguoidung> listnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        listnd = new ArrayList<>();
        anhxa();
        getlistuser();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             boolean check =   Checktknd(User.getText().toString(),Pass.getText().toString());
             if (check == true){
                 Toast.makeText(getApplicationContext(),"Đăng nhập thành công",Toast.LENGTH_SHORT).show();;
                 Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                 startActivity(intent);
             }else{
                 Toast.makeText(getApplicationContext(), "Đăng nhạp thất bại , vui lòng kiểm tra lại số điện thoại hoặc mật khẩu", Toast.LENGTH_SHORT).show();
             }
            }
        });
        btnsigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });
    }
    private void anhxa(){
        User = findViewById(R.id.Username);
        Pass = findViewById(R.id.Password);
        btnlogin = findViewById(R.id.btnlogin);
        btnsigin = findViewById(R.id.btnsigin);

    }

    private  boolean Checktknd(String user ,String pass){
                boolean check = false;
        for (Nguoidung x:listnd){
            if(user.equals(x.getUsername())){
                if (pass.equals(x.getPassword())){
                    check = true;
                }

            }
        }return check;
    }
    private void getlistuser(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myreb = database.getReference("user");
        myreb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Nguoidung nguoidung1 = dataSnapshot.getValue(Nguoidung.class);
                    listnd.add(nguoidung1);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "ko thể kết nối sv", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
