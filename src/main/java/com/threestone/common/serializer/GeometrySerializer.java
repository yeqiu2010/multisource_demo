package com.threestone.common.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.threestone.utils.JtsUtils;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by admin on 2019/12/28.
 */
public abstract class GeometrySerializer<T extends Geometry> implements ObjectSerializer, ObjectDeserializer {
    @Override
    public void write(JSONSerializer jsonSerializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        T geom = (T) object;
        String wkt = JtsUtils.toEwkt(geom);
        jsonSerializer.write(wkt);
    }

    @Override
    public T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        Object value = parser.parse();
        if (value == null) {
            return null;
        } else {
            String wkt = (String) value;
            WKTReader reader = new WKTReader();
            try {
                return (T) reader.read(wkt);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }
}
