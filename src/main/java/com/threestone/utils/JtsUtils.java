package com.threestone.utils;

import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.linearref.LengthIndexedLine;

import java.text.DecimalFormat;

/**
 * Created by admin on 2019/12/19.
 */
public class JtsUtils {
    private static final double EARTH_RADIUS = 6378137;
    public static GeometryFactory factory = new GeometryFactory(new PrecisionModel(100000000000d));
    private static DecimalFormat df = new DecimalFormat("0.00000000000");
    private static DecimalFormat format = new DecimalFormat("0.0000");

    public static String toEwkt(Geometry geom) {
        if (geom == null) {
            return null;
        }
        String type = geom.getGeometryType().toUpperCase();
        switch (type) {
            case "POINT": {
                Coordinate coor = geom.getCoordinate();
                return "POINT(" + formatCoordinate(coor) + ")";
            }
            case "MULTIPOINT": {
                return coordinateToEwkt("MULTIPOINT(", geom.getCoordinates(), ")");
            }
            case "LINESTRING": {
                return coordinateToEwkt("LINESTRING(", geom.getCoordinates(), ")");
            }
            case "POLYGON": {
                return coordinateToEwkt("POLYGON((", geom.getCoordinates(), "))");
            }
            case "MULTILINESTRING": {
                StringBuffer sb = new StringBuffer();
                sb.append("MULTILINESTRING(");
                sb.append(multiGeometryFormat(geom));
                sb.append(")");
                return sb.toString();
            }
            case "MULTIPOLYGON": {
                StringBuffer sb = new StringBuffer();
                sb.append("MULTIPOLYGON(");
                sb.append(multiGeometryFormat(geom));
                sb.append(")");
                return sb.toString();
            }
            case "GEOMETRYCOLLECTION": {
                StringBuffer sb = new StringBuffer();
                int num = geom.getNumGeometries();
                sb.append("GEOMETRYCOLLECTION(");
                for (int j = 0; j < num; j++) {
                    Geometry element = geom.getGeometryN(j);
                    String subType = element.getGeometryType().toUpperCase();
                    if ("POINT".equals(subType)) {
                        sb.append("POINT(" + formatCoordinate(element.getCoordinate()) + ")");
                    } else if ("LINESTRING".equals(subType)) {
                        sb.append(coordinateToEwkt("LINESTRING(", element.getCoordinates(), ")"));
                    } else if ("POLYGON".equals(subType)) {
                        sb.append(coordinateToEwkt("POLYGON((", element.getCoordinates(), "))"));
                    }
                    if (j < num - 1) {
                        sb.append(",");
                    }
                }
                sb.append(")");
                return sb.toString();
            }
        }
        return null;
    }

    private static String formatCoordinate(Coordinate coordinate) {
        if (Double.isNaN(coordinate.z)) {
            coordinate.z = 0;
        }
        return df.format(coordinate.x) + " " + df.format(coordinate.y) + " " + (coordinate.z != 0 ? df.format(coordinate.z) : "0");
    }

    public static String coordinateToEwkt(String prefix, Coordinate[] coordinates, String suffix) {
        StringBuffer sb = new StringBuffer();
        sb.append(prefix);
        boolean append = false;
        for (Coordinate coordinate : coordinates) {
            if (append) {
                sb.append(",");
            }
            sb.append(formatCoordinate(coordinate));
            append = true;
        }
        sb.append(suffix);
        return sb.toString();
    }

    public static String multiGeometryFormat(Geometry geom) {
        StringBuffer sb = new StringBuffer();
        int num = geom.getNumGeometries();
        for (int i = 0; i < num; i++) {
            Geometry g = geom.getGeometryN(i);
            sb.append(coordinateToEwkt("((", g.getCoordinates(), "))"));
            if (i < num - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /**
     * 获取两组成的线的几何中心
     *
     * @param s
     *            起始点
     * @param e
     *            结束点
     * @return
     */
    public static Coordinate getCentroid(Coordinate s, Coordinate e) {// 获取两点组成的线的图心
        if (s.x == e.x && s.y == e.y) {
            return s;
        }
        LineString ls = factory.createLineString(new Coordinate[] { s, e });
        Point cp = ls.getCentroid();
        return cp.getCoordinate();
    }

    /**
     * 获取多个离散几何点的几何中心
     *
     * @param coors
     * @return
     */
    public static Coordinate getCentroid(Coordinate[] coors) {// 获取多个离散点的图心
        MultiPoint mp = factory.createMultiPoint(coors);
        return mp.getCentroid().getCoordinate();
    }

    public static Polygon createPolygon(Coordinate[] coors) {
        return factory.createPolygon(coors);
    }

    public static LineString createLineString(Coordinate[] coors) {
        return factory.createLineString(coors);
    }

    public static Coordinate getCenter(LineString line) {
        LengthIndexedLine indexedLine = new LengthIndexedLine(line);
        double[] index = indexedLine.indicesOf(line);
        Coordinate mid = indexedLine.extractPoint((index[0] + index[1]) / 2);
        return mid;
    }
}
