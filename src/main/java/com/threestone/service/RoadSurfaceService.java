package com.threestone.service;

import com.threestone.model.RoadSurface;

import java.util.List;

/**
 * Created by admin on 2019/12/18.
 */
public interface RoadSurfaceService {
    List<RoadSurface> getAllRoadSurface();

    void exportSqlit(List<RoadSurface> roadSurfaces);

    List<RoadSurface> getRoadSurfacesByMesh(Integer mesh);
}
