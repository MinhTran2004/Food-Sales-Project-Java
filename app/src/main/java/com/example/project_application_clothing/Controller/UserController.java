package com.example.project_application_clothing.Controller;

import android.content.Context;

import com.example.project_application_clothing.DataBase.UserApi;
import com.example.project_application_clothing.Model.UserModel;

public class UserController {
    private Context context;
    public UserController(Context context){
        this.context = context;
    }
    public boolean addUser(UserModel model){
        UserApi userApi = new UserApi(context);
        return userApi.addUser(model);
    }
    public boolean deleteUser(UserModel model){
        UserApi userApi = new UserApi(context);
        return userApi.deleteUser(model);
    }
    public boolean updateUser(UserModel model){
        UserApi userApi = new UserApi(context);
        return userApi.updateUser(model);
    }
    public boolean checkUser(UserModel userModel, String screen){
        UserApi userApi = new UserApi(context);
        return userApi.checkUser(userModel, screen);
    }
    public UserModel checkLogin(UserModel userModel){
        UserApi userApi = new UserApi(context);
        return userApi.checkLogin(userModel);
    }

}
