package com.swf.simple.common.util;

import java.text.DecimalFormat;

/**
 * 地图工具
 *
 * @author SWF
 * @date 2019/6/19 13:49
 **/
public class MapUtil {

    // 地球半径，平均值，单位：米
    public static final double EARTH_RADIUS = 6378137.0;


//    public static void main(String[] args){
//        String distance = computeDistanceByGeocode(120.215729,30.186420,120.168663,30.175650);
//        System.err.println(distance);
//    }

    /**
     * 根据经纬度计算距离，单位为m
     * @param lon1
     * @param lat1
     * @param lon2
     * @param lat2
     * @return
     */
    public static String computeDistanceByGeocode(double lon1, double lat1, double lon2, double lat2)
    {
        //用haversine公式计算球面两点间的距离。
        //经纬度转换成弧度
        lat1 = convertDegreesToRadians(lat1);
        lon1 = convertDegreesToRadians(lon1);
        lat2 = convertDegreesToRadians(lat2);
        lon2 = convertDegreesToRadians(lon2);

        //差值
        double vLon = Math.abs(lon1 - lon2);
        double vLat = Math.abs(lat1 - lat2);

        //h is the great circle distance in radians, great circle就是一个球体上的切面，它的圆心即是球心的一个周长最大的圆。
        double h = haverSin(vLat) + Math.cos(lat1) * Math.cos(lat2) * haverSin(vLon);
        // 弧长*地球半径
        double distance = 2 * Math.asin(Math.sqrt(h)) * EARTH_RADIUS;
        //精确距离的数值
        distance = Math.round(distance * 10000d) / 10000d;
        //四舍五入
        DecimalFormat df = new DecimalFormat("#");
        return df.format(distance);
    }

    public static double haverSin(double theta) {
        double v = Math.sin(theta / 2);
        return v * v;
    }

    /**
     * 将角度转换为弧度
     * @param degrees 角度
     * @return 弧度
     */
    public static double convertDegreesToRadians(double degrees)
    {
        return degrees * Math.PI / 180;
    }

    /**
     * 将弧度转换为角度
     * @param radian 弧度
     * @return 角度
     */
    public static double convertRadiansToDegrees(double radian)
    {
        return radian * 180.0 / Math.PI;
    }


}
