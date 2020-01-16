package com.threestone.common.mybatisTypeHandler;

import com.threestone.utils.JtsUtils;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.WKTReader;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 字符串转为JTS对应的几何类型
 * Created by Friday on 2019/6/19.
 */
@MappedJdbcTypes({JdbcType.OTHER})
public abstract class AbstractGeometryTypeHandler<T extends Geometry> extends BaseTypeHandler<T> {
    /**
     * 把Java类型参数转换为对应的数据库类型
     *
     * @param ps        当前的PreparedStatement对象
     * @param i         当前参数位置
     * @param parameter 当前参数的Java对象
     * @param jdbcType  当前参数的数据库类型
     * @throws SQLException
     */
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
        String wkt = JtsUtils.toEwkt(parameter);
        ps.setObject(i, wkt);
    }

    /**
     * 获取数据结果集时把数据库类型转换为对应的Java类型
     *
     * @param rs         当前的结果集
     * @param columnName 当前的字段名称
     * @return 转换后的Java对象
     * @throws SQLException
     */
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String wkt = (String) rs.getObject(columnName);
        return (T) getGeometryFromWkt(wkt);
    }

    /**
     * 通过字段位置获取字段数据时把数据库类型转换为对应的Java类型
     *
     * @param rs          当前的结果集
     * @param columnIndex 当前字段的位置
     * @return 转换后的Java对象
     * @throws SQLException
     */
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String wkt = (String) rs.getObject(columnIndex);
        return (T) getGeometryFromWkt(wkt);
    }

    /**
     * 调用存储过程后把数据库类型的数据转换为对应的Java类型
     *
     * @param cs          当前的CallableStatement执行后的CallableStatement
     * @param columnIndex 当前输出参数的位置
     * @return
     * @throws SQLException
     */
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String wkt = (String) cs.getObject(columnIndex);
        return (T) getGeometryFromWkt(wkt);
    }

    // 从WKT中获取几何
    private Geometry getGeometryFromWkt(String wkt) {
        WKTReader reader = new WKTReader();
        Geometry geometry = null;
        try {
            geometry = reader.read(wkt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (geometry == null) {
            return null;
        }
        return geometry;
    }
}
