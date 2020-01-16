package com.threestone.service.impl;

import com.threestone.dao.editor.RoadLinkDao;
import com.threestone.model.RoadLink;
import com.threestone.service.RoadLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2019/12/28.
 */
@Service("roadLinkService")
public class RoadLinkServiceImpl implements RoadLinkService {

    @Autowired
    private RoadLinkDao roadLinkDao;

    @Override
    public List<RoadLink> getRoadLinkListByMesh(Integer mesh) {
        return roadLinkDao.getRoadLinkListByMesh(mesh);
    }

    @Override
    public void deleteByMesh(Integer mesh) {
        roadLinkDao.deleteByMesh(mesh);
    }
}
