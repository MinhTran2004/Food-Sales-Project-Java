package com.example.project_application_clothing.Controller;

import android.content.Context;

import com.example.project_application_clothing.DataBase.UserApi;
import com.example.project_application_clothing.Model.UserModel;

public class UserController {
    public boolean addUser(UserModel model, Context context){
        UserApi userApi = new UserApi(context);
        return userApi.addUser(model);
    }
    public boolean deleteUser(UserModel model, Context context){
        UserApi userApi = new UserApi(context);
        return userApi.deleteUser(model);
    }
    public boolean updateUser(UserModel model, Context context){
        UserApi userApi = new UserApi(context);
        return userApi.updateUser(model);
    }
    public boolean checkUser(UserModel userModel, Context context, String screen){
        UserApi userApi = new UserApi(context);
        return userApi.checkuser(userModel, screen);
    }
}
