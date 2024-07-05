package com.example.project_application_clothing.View;

import android.content.Intent;
import android.os.Bundle;
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

public class Register extends AppCompatActivity {

    EditText edt_Register_Ten, edt_Register_Taikhoan, edt_Register_Matkhau;
    TextView txtError_Register_Ten, txtError_Register_Taikhoan, txtError_Register_Matkhau;
    Button btn_Return, btn_Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edt_Register_Ten = findViewById(R.id.edt_Register_Ten);
        edt_Register_Taikhoan = findViewById(R.id.edt_Register_Taikhoan);
        edt_Register_Matkhau = findViewById(R.id.edt_Register_Matkhau);
        txtError_Register_Ten = findViewById(R.id.txtError_Register_Ten);
        txtError_Register_Taikhoan = findViewById(R.id.txtError_Register_Taikhoan);
        txtError_Register_Matkhau = findViewById(R.id.txtError_Register_Matkhau);
        btn_Return = findViewById(R.id.btn_Quaylai);
        btn_Register = findViewById(R.id.btn_Register);

        btn_Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this, Login.class));
            }
        });

        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkNull(edt_Register_Ten, edt_Register_Taikhoan, edt_Register_Matkhau, txtError_Register_Ten, txtError_Register_Taikhoan, txtError_Register_Matkhau)){
                    UserController userController = new UserController();
                    UserModel userModel = new UserModel();
                    userModel.setTen(edt_Register_Ten.getText().toString());
                    userModel.setTaikhoan(edt_Register_Taikhoan.getText().toString());
                    userModel.setMatkhau(edt_Register_Matkhau.getText().toString());

                    if (userController.checkUser(userModel, Register.this, "register")){
                        txtError_Register_Taikhoan.setText("Tài khoản đã tồn tại");
                    }else{
                        if (userController.addUser(userModel, Register.this)){
                            startActivity(new Intent(Register.this, Login.class));
                        }
                    }

                }
            }
        });
    }
    private boolean checkNull(EditText edt_Register_Ten, EditText edt_Register_Taikhoan, EditText edt_Register_Matkhau, TextView txtError_Register_Ten, TextView txtError_Register_Taikhoan, TextView txtError_Register_Matkhau){
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(edt_Register_Taikhoan.getText());

        Boolean check = true;
        if (edt_Register_Ten.getText().length() == 0){
            txtError_Register_Ten.setText("Không để trống ô nhập");
            check = false;
        }else{
            txtError_Register_Ten.setText("");
        }

        if (edt_Register_Taikhoan.getText().length() == 0){
            txtError_Register_Taikhoan.setText("Không để trống ô nhập");
            check = false;
        }else if(!matcher.matches()){
            txtError_Register_Taikhoan.setText("Không đúng định dạng Email");
            check = false;
        }else{
            txtError_Register_Taikhoan.setText("");
        }

        if (edt_Register_Matkhau.getText().length() == 0){
            txtError_Register_Matkhau.setText("Không để trống ô nhập");
            check = false;
        }else{
            txtError_Register_Matkhau.setText("");
        }
        return check;
    }
}