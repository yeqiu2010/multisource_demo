package com.threestone.service.impl;

import com.threestone.dao.xd.XdRoadLinkDao;
import com.threestone.model.RoadLink;
import com.threestone.model.XdRoadLink;
import com.threestone.service.XdRoadLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by admin on 2019/12/30.
 */
@Service("xdRoadLinkService")
public class XdRoadLinkServiceImpl implements XdRoadLinkService {

    @Autowired
    private XdRoadLinkDao xdRoadLinkDao;

    @Override
    public void transform2XdRoadLink(List<RoadLink> roadLinks) {
        List<XdRoadLink> xdRoadLinks = new ArrayList<>();
        for (RoadLink roadLink : roadLinks) {
            XdRoadLink xdRoadLink = new XdRoadLink();
            xdRoadLink.setRoadLinkID(Long.valueOf(roadLink.getObjectID()));
            xdRoadLink.setMesh(roadLink.getMesh());
            xdRoadLink.setGeom(roadLink.getGeom());
            xdRoadLinks.add(xdRoadLink);
        }
        xdRoadLinkDao.insertLinks(xdRoadLinks);
    }

}
