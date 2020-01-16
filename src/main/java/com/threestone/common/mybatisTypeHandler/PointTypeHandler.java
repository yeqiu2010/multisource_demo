package com.threestone.common.mybatisTypeHandler;

import com.vividsolutions.jts.geom.Point;
import org.apache.ibatis.type.MappedTypes;

/**
 * WKT转为Point
 * Created by Friday on 2019/6/19.
 */
@MappedTypes(Point.class)
public class PointTypeHandler extends AbstractGeometryTypeHandler<Point> {
}
