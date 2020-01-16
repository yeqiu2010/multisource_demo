package com.threestone.dao.editor;

import com.threestone.model.RoadLink;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by admin on 2019/12/28.
 */
@Mapper
public interface RoadLinkDao {
    List<RoadLink> getRoadLinkListByMesh(@Param("mesh") Integer mesh);

    void deleteByMesh(@Param("mesh") Integer mesh);
}
