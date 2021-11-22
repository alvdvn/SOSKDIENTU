package com.example.soskdientu.activity.Dangnhap_Dawngky;

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
        anhxa();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Checktknd(User.getText().toString(),Pass.getText().toString());
            }
        });
        btnsigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
            }
        });
    }
    private void anhxa(){
        User = findViewById(R.id.Username);
        Pass = findViewById(R.id.Password);
        btnlogin = findViewById(R.id.btnlogin);
        btnsigin = findViewById(R.id.btnsigin);
        listnd = new ArrayList<>();
    }
    private  void Checktknd(String user ,String pass){

        for (int i = 0 ; i<(listnd.size()-1);i++){
            if(user.equalsIgnoreCase(listnd.get(i).getUsername())){
                if (pass.equalsIgnoreCase(listnd.get(i).getPassword())){
                    Toast.makeText(this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();;
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(this,"Mật khẩu không đúng, vui lòng kiểm tra lại ",Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this,"Người dùng không tồn tại",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
