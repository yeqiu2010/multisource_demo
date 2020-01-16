package com.threestone.common.mybatisTypeHandler;

import com.vividsolutions.jts.geom.Polygon;
import org.apache.ibatis.type.MappedTypes;

/**
 * WKT转为Polygon
 * Created by Friday on 2019/6/20.
 */
@MappedTypes(Polygon.class)
public class PolygonTypeHandler extends AbstractGeometryTypeHandler<Polygon> {
}
