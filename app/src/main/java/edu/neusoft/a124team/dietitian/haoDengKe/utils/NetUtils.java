package edu.neusoft.a124team.dietitian.haoDengKe.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by hao on 2016/9/6.
 */
public class NetUtils {
    public static boolean check(Context context){
        try{
            ConnectivityManager connectivityManager=(ConnectivityManager)context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager!=null){
                //获取网络连接管理对象
                NetworkInfo info=connectivityManager.getActiveNetworkInfo();
                if (info!=null&&info.isConnected()){
                    if
                            (info.getState() == NetworkInfo.State.CONNECTED){
                        return true;
                    }
                }


            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
