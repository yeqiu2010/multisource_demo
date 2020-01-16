package com.threestone.common.mybatisTypeHandler;

import com.vividsolutions.jts.geom.LineString;
import org.apache.ibatis.type.MappedTypes;

/**
 * WKT转为LineString
 * Created by Friday on 2019/6/19.
 */
@MappedTypes(LineString.class)
public class LineStringTypeHandler extends AbstractGeometryTypeHandler<LineString>{
}