package edu.neusoft.a124team.dietitian.wangHan.jsonWeather;

/**
 * Created by Hansen on 2016/6/11.
 */
public class W_weather {

    /**
     * 天气实体类
     *
     * @author jph
     * Date:2014.09.26
     *
     * @修改：hansen
     * Date:2016/6/2
     */

    private String city;
    private String temp1;
    private String temp2;
    private String weather;
    private String ptime;


    public W_weather(String city,  String temp1, String temp2, String weather, String ptime) {
        this.city = city;
        this.temp1 = temp1;
        this.temp2 = temp2;
        this.weather = weather;
        this.ptime = ptime;
    }

    public String getCity() {return city; }

    public String getPtime() {
        return ptime;
    }

    public String getTemp1() {
        return temp1;
    }

    public String getTemp2() {
        return temp2;
    }

    public String getWeather() {
        return weather;
    }
}
