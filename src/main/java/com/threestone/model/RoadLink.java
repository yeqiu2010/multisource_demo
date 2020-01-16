package com.threestone.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.threestone.common.serializer.LineStringSerializer;
import com.vividsolutions.jts.geom.LineString;

/**
 * Created by admin on 2019/12/28.
 */
public class RoadLink{
    private Integer objectID;
    private Integer mesh;

    @JSONField(serializeUsing = LineStringSerializer.class, deserializeUsing = LineStringSerializer.class)
    private LineString geom;

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

    public LineString getGeom() {
        return geom;
    }

    public void setGeom(LineString geom) {
        this.geom = geom;
    }
}
