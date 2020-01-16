package com.threestone.model;

import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

/**
 * 道路面实体类
 * Created by admin on 2019/12/18.
 */
public class RoadSurface {
    private Integer objectID;
    private Integer mesh;
    private Polygon geom;

    public Integer getObjectID() {
        return objectID;
    }

    public void setObjectID(Integer objectID) {
        this.objectID = objectID;
    }

    public Integer getMesh() {
        return mesh;
    }

    public void setMesh(Integer mesh) {
        this.mesh = mesh;
    }

    public Polygon getGeom() {
        return geom;
    }

    public void setGeom(Polygon geom) {
        this.geom = geom;
    }
}
