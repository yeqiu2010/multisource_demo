package com.threestone.dao.editor;

import com.threestone.model.RoadSurface;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by admin on 2019/12/18.
 */
@Mapper
public interface RoadSurfaceDao {
    List<RoadSurface> getAllRoadSurface();

    int insertRoadSurfaceLinkList(@Param("list") List<RoadSurface> list);

    List<RoadSurface> getRoadSurfacesByMesh(@Param("mesh") Integer mesh);
}
