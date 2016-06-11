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
    private String cityid;
    private String temp1;
    private String temp2;
    private String weather;
    private String img1;
    private String img2;
    private String ptime;


    public W_weather(String city, String cityid, String temp1, String temp2, String weather, String img1, String img2, String ptime) {
        this.city = city;
        this.cityid = cityid;
        this.temp1 = temp1;
        this.temp2 = temp2;
        this.weather = weather;
        this.img1 = img1;
        this.img2 = img2;
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
