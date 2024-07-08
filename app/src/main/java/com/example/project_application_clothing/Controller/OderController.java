package com.example.project_application_clothing.Controller;

import android.content.Context;

import com.example.project_application_clothing.DataBase.OderApi;
import com.example.project_application_clothing.Model.OderModel;

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
    public boolean updateOder(OderModel oderModel){
        OderApi oderApi = new OderApi(context);
        return oderApi.updateOder(oderModel);
    }
    public List<OderModel> getAllOderActive (){
        OderApi oderApi = new OderApi(context);
        return oderApi.getAllOderActive();
    }
    public List<OderModel> getAllOderCompleted (){
        OderApi oderApi = new OderApi(context);
        return oderApi.getAllOderCompleted();
    }
    public List<OderModel> getAllOderCancel (){
        OderApi oderApi = new OderApi(context);
        return oderApi.getAllOderCancel();
    }
}
