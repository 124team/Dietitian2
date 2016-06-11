package edu.neusoft.a124team.dietitian.wangHan.fragmentAdapter;

import java.util.HashMap;

/**
 * Created by Hansen on 2016/6/10.
 * 格式适配器
 */
public class W_dataControl {
    public static HashMap<String,String> getFrgmentTxt(String title,String txt ,String img1,String img2,String img3){
        HashMap<String,String> map = new HashMap<>();
        map.put("Title",title);
        map.put("Txt",txt);
        map.put("Img1",img1);
        map.put("Img2",img2);
        map.put("Img3",img3);

        return map;
        
    }

}
