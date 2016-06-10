package edu.neusoft.a124team.dietitian.wangRui;

import java.util.HashMap;

/**
 * Created by wang5 on 2016/6/10.
 */
public class S_dataControl {
    public  static HashMap<String,String> getDataSource(
                                                        String id,

                                                        String txtContent){
        HashMap<String,String> map=new HashMap<>();

        map.put("Img",id);

        map.put("Content",txtContent);


        return map;

    }
    public  static HashMap<String,String> getDataSource1(
            String id,
            String txtTitle

    ){
        HashMap<String,String> map1=new HashMap<>();

        map1.put("Img",id);
        map1.put("Title",txtTitle);

        return map1;
    }
}