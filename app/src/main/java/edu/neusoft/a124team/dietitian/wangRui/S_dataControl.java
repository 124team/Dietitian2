package edu.neusoft.a124team.dietitian.wangRui;

import java.util.HashMap;

/**
 * Created by wang5 on 2016/6/10.
 */
public class S_dataControl {
    public  static HashMap<String,String> getDataSource(
                                                        String id,

                                                        String txtContent,
                                                        String txtTime){
        HashMap<String,String> map=new HashMap<>();

        map.put("Img",id);
        map.put("Content",txtContent);
        map.put("Time",txtTime);

        return map;

    }
    public  static HashMap<String,String> getDataSource1(
                                                        String id,
                                                        String txtTitle,
                                                        String id1){
        HashMap<String,String> map1=new HashMap<>();

        map1.put("Img",id);
        map1.put("Title",txtTitle);
        map1.put("Img1",id1);

        return map1;
    }
}