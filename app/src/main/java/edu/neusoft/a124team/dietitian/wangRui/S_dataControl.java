package edu.neusoft.a124team.dietitian.wangRui;

import java.util.HashMap;

/**
 * Created by wang5 on 2016/6/10.
 */
public class S_dataControl {
    public  static HashMap<String,String> getDataSource(
                                                        String id,
                                                        String txtTitle,
                                                        String txtContent){
        HashMap<String,String> map=new HashMap<>();

        map.put("Img",id);
        map.put("Title",txtTitle);
        map.put("Content",txtContent);
        return map;

    }
}