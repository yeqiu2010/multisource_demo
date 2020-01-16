package com.threestone.service;

import com.threestone.model.RoadLink;

import java.util.List;

/**
 * Created by admin on 2019/12/28.
 */
public interface RoadLinkService {
    List<RoadLink> getRoadLinkListByMesh(Integer mesh);

    void deleteByMesh(Integer mesh);
}
