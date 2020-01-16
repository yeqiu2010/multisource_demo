package com.threestone.service.impl;

import com.threestone.dao.editor.RoadSurfaceDao;
import com.threestone.model.RoadSurface;
import com.threestone.service.RoadSurfaceService;
import com.threestone.utils.JtsUtils;
import com.threestone.utils.SqliteUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sqlite.SQLiteConfig;

import java.sql.*;
import java.util.List;

/**
 * Created by admin on 2019/12/18.
 */
@Service("roadSurfaceService")
public class RoadSurfaceServiceImpl implements RoadSurfaceService {

    @Autowired
    private RoadSurfaceDao roadSurfaceDao;

    @Override
    public List<RoadSurface> getAllRoadSurface() {
        return roadSurfaceDao.getAllRoadSurface();
    }

    @Override
    public List<RoadSurface> getRoadSurfacesByMesh(Integer mesh) {
        return roadSurfaceDao.getRoadSurfacesByMesh(mesh);
    }

    @Override
    public void exportSqlit(List<RoadSurface> roadSurfaces) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = null;
            String sql = "";
            SQLiteConfig config = new SQLiteConfig();
            config.enableLoadExtension(true);

            conn = DriverManager.getConnection("jdbc:sqlite:roadsurface.db", config.toProperties());
            Statement stmt = conn.createStatement();
            stmt.setQueryTimeout(30);

            stmt.execute("SELECT load_extension('mod_spatialite')");

            if (!SqliteUtils.isExistTable("spatial_ref_sys", stmt)) {
                sql = "SELECT InitSpatialMetadata(1)";
                stmt.execute(sql);
            }

            if (!SqliteUtils.isExistTable("roadsurface", stmt)) {
                sql = "CREATE TABLE roadsurface (";
                sql += "id INTEGER NOT NULL PRIMARY KEY,";
                sql += "mesh INTEGER)";
                stmt.execute(sql);
                sql = "SELECT AddGeometryColumn('roadsurface', ";
                sql += "'geom', 4326, 'POLYGON', 'XYZ')";
                stmt.execute(sql);
            }
            sql = "DELETE FROM roadsurface;";
            stmt.execute(sql);

            conn.setAutoCommit(false);
            for (int i = 0; i < roadSurfaces.size(); i++) {
                RoadSurface roadSurface = roadSurfaces.get(i);
                sql = "INSERT INTO roadsurface (id, mesh, geom) VALUES (";
                sql += roadSurface.getObjectID() + ",";
                sql += roadSurface.getMesh() + ",";
                sql += "GeomFromText('" + JtsUtils.toEwkt(roadSurface.getGeom()).replace("POLYGON", "POLYGON Z") + "', 4326));";
                stmt.executeUpdate(sql);
                if (i == 500){
                    conn.commit();
                    sql = "";
                }
            }
            conn.commit();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
