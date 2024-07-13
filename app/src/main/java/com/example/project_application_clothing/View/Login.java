package com.example.project_application_clothing.View;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project_application_clothing.Controller.UserController;
import com.example.project_application_clothing.Model.UserModel;
import com.example.project_application_clothing.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity{
    EditText edt_Login_Taikhoan, edt_Login_Matkhau;
    TextView txtError_Login_Taikhoan, txtError_Login_Matkhau, txt_Register;
    Button btn_Login;
    UserModel userModel;
    UserController userController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_Login_Taikhoan = findViewById(R.id.edt_Login_Taikhoan);
        edt_Login_Matkhau = findViewById(R.id.edt_Login_Matkhau);
        txtError_Login_Taikhoan = findViewById(R.id.txtError_Login_Taikhoan);
        txtError_Login_Matkhau = findViewById(R.id.txtError_Login_Matkhau);
        btn_Login = findViewById(R.id.btn_Login);
        txt_Register = findViewById(R.id.txt_Register);

        userController = new UserController(Login.this);

        txt_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_Login_Taikhoan.getText().toString().equals("admin") && edt_Login_Matkhau.getText().toString().equals("123")){
                    userModel = new UserModel();
                    userModel.setTaikhoan(edt_Login_Taikhoan.getText().toString());
                    userModel.setMatkhau(edt_Login_Matkhau.getText().toString());
                    if (userController.checkUser(userModel, "login")){
                        userModel = userController.checkLogin(userModel);
                        SharedPreferences sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("id", String.valueOf(userModel.getId()));
                        editor.putString("ten", String.valueOf(userModel.getTen()));
                        editor.putString("taikhoan", String.valueOf(userModel.getTaikhoan()));
                        editor.putString("matkhau", String.valueOf(userModel.getMatkhau()));
                        editor.apply();
                        startActivity(new Intent(Login.this, Main.class));
                    }else {
                        txtError_Login_Matkhau.setText("Sai mật khẩu");
                    }
                }else if(checkNull(edt_Login_Taikhoan, edt_Login_Matkhau, txtError_Login_Taikhoan, txtError_Login_Matkhau)){
                    userModel = new UserModel();
                    userModel.setTaikhoan(edt_Login_Taikhoan.getText().toString());
                    userModel.setMatkhau(edt_Login_Matkhau.getText().toString());
                    if (userController.checkUser(userModel, "login")){
                        userModel = userController.checkLogin(userModel);
                        SharedPreferences sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("id", String.valueOf(userModel.getId()));
                        editor.putString("ten", String.valueOf(userModel.getTen()));
                        editor.putString("taikhoan", String.valueOf(userModel.getTaikhoan()));
                        editor.putString("matkhau", String.valueOf(userModel.getMatkhau()));
                        editor.apply();
                        startActivity(new Intent(Login.this, Main.class));
                    }else {
                        txtError_Login_Matkhau.setText("Sai mật khẩu");
                    }
                }
            }
        });
    }

    private boolean checkNull(EditText edt_Login_Taikhoan, EditText edt_Login_Matkhau, TextView txtError_Login_Taikhoan, TextView txtError_Login_Matkhau){
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(edt_Login_Taikhoan.getText().toString().trim());

        Boolean check = true;

        if (edt_Login_Taikhoan.getText().length() == 0){
            txtError_Login_Taikhoan.setText("Không để trống ô nhập");
            check = false;
        }else if(!matcher.matches()){
            txtError_Login_Taikhoan.setText("Không đúng định dạng Email");
            check = false;
        }else{
            txtError_Login_Taikhoan.setText("");
        }

        if (edt_Login_Matkhau.getText().length() == 0){
            txtError_Login_Matkhau.setText("Không để trông ô nhập");
            check = false;
        }else{
            txtError_Login_Matkhau.setText("");
        }
        return check;
    }

}