package com.threestone.dao.xd;

import com.threestone.model.XdRoadLink;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by admin on 2019/12/30.
 */
@Mapper
public interface XdRoadLinkDao {
    List<XdRoadLink> getXdRoadLinksByMesh(@Param("mesh") Integer mesh);

    int insertLinks(@Param("list") List<XdRoadLink> xdRoadLinks);
}
