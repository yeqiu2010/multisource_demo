package com.threestone.controller;

import com.threestone.model.JsonResp;
import com.threestone.model.RoadLink;
import com.threestone.service.RoadLinkService;
import com.threestone.service.XdRoadLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by admin on 2019/12/28.
 */
@RestController
@RequestMapping("/roadLink")
public class RoadLinkController {
    @Autowired
    private RoadLinkService roadLinkService;
    @Autowired
    private XdRoadLinkService xdRoadLinkService;

    @RequestMapping(method = RequestMethod.GET, value = "/getRoadLinksByMesh/{mesh}")
    public JsonResp<List> getRoadLinksByMesh(@PathVariable("mesh") Integer mesh) throws Exception {
        JsonResp<List> resp = new JsonResp<>(JsonResp.STATE_SUCCESS);
        List<RoadLink> roadLinks = roadLinkService.getRoadLinkListByMesh(mesh);
        resp.setData(roadLinks);
        return resp;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exportXd/{mesh}")
    public JsonResp exportXd(@PathVariable("mesh") Integer mesh) throws Exception {
        JsonResp resp = new JsonResp(JsonResp.STATE_SUCCESS);
        List<RoadLink> roadLinks = roadLinkService.getRoadLinkListByMesh(mesh);
        xdRoadLinkService.transform2XdRoadLink(roadLinks);
        return resp;
    }
}
