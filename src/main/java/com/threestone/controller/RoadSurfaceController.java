package com.threestone.controller;

import com.threestone.model.JsonResp;
import com.threestone.model.RoadSurface;
import com.threestone.service.RoadSurfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by admin on 2019/12/18.
 */
@RestController
@RequestMapping("/roadSurface")
public class RoadSurfaceController {
    @Autowired
    private RoadSurfaceService roadSurfaceService;

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public JsonResp<List> getAllRoadSurfaces() throws Exception {
        JsonResp<List> resp = new JsonResp<>(JsonResp.STATE_SUCCESS);
        List<RoadSurface> roadSurfaces = roadSurfaceService.getAllRoadSurface();
        resp.setData(roadSurfaces);
        return resp;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exportSqlit/{mesh}")
    public JsonResp exportSqlit(@PathVariable("mesh") Integer mesh) throws Exception {
        JsonResp resp = new JsonResp<>(JsonResp.STATE_SUCCESS);
        List<RoadSurface> roadSurfaces = roadSurfaceService.getRoadSurfacesByMesh(mesh);
        roadSurfaceService.exportSqlit(roadSurfaces);
        return resp;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exportSqlit/all")
    public JsonResp<List> exportSqlitAll() throws Exception {
        JsonResp<List> resp = new JsonResp<>(JsonResp.STATE_SUCCESS);
        List<RoadSurface> roadSurfaces = roadSurfaceService.getAllRoadSurface();
        roadSurfaceService.exportSqlit(roadSurfaces);
        return resp;
    }
}
