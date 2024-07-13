package com.example.project_application_clothing.Controller;

import android.content.Context;

import com.example.project_application_clothing.DataBase.OderApi;
import com.example.project_application_clothing.Model.OderModel;
import com.example.project_application_clothing.Model.UserModel;

import java.util.List;

public class OderController {
    Context context;
    public OderController(Context context){
        this.context = context;
    }
    public boolean insertOder(OderModel oderModel){
        OderApi oderApi = new OderApi(context);
        return oderApi.insertOder(oderModel);
    }
    public boolean deleteOder(OderModel oderModel){
        OderApi oderApi = new OderApi(context);
        return oderApi.deleteOder(oderModel);
    }
    public boolean updateOder(OderModel oderModel, String trangthai){
        OderApi oderApi = new OderApi(context);
        return oderApi.updateOder(oderModel, trangthai);
    }
    public List<OderModel> getAllOderActive (String id, String chucvu){
        OderApi oderApi = new OderApi(context);
        return oderApi.getAllOderActive(id, chucvu);
    }
    public List<OderModel> getAllOderCompleted (String id, String chucvu){
        OderApi oderApi = new OderApi(context);
        return oderApi.getAllOderCompleted(id, chucvu);
    }
    public List<OderModel> getAllOderCancel (String id, String chucvu){
        OderApi oderApi = new OderApi(context);
        return oderApi.getAllOderCancel(id,chucvu);
    }
}
