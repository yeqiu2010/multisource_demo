package com.threestone.model;

import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;

/**
 * Created by admin on 2019/12/30.
 */
public class XdRoadLink {
    private Long roadLinkID;
    private Integer mesh;
    private Integer block;
    private Integer recordVersion;
    private Integer meshVersion;
    private Integer action;
    private Long timestamp;
    private Integer type;
    private Integer subType;
    private Long startNodeID;
    private Long endNodeID;
    private Integer startWidth;
    private Integer endWidth;
    private Integer startLaneNum;
    private Integer endLaneNum;
    private String tags;
    private Point gesture;
    private LineString geom;

    public Long getRoadLinkID() {
        return roadLinkID;
    }

    public void setRoadLinkID(Long roadLinkID) {
        this.roadLinkID = roadLinkID;
    }

    public Integer getMesh() {
        return mesh;
    }

    public void setMesh(Integer mesh) {
        this.mesh = mesh;
    }

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public Integer getRecordVersion() {
        return recordVersion;
    }

    public void setRecordVersion(Integer recordVersion) {
        this.recordVersion = recordVersion;
    }

    public Integer getMeshVersion() {
        return meshVersion;
    }

    public void setMeshVersion(Integer meshVersion) {
        this.meshVersion = meshVersion;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }

    public Long getStartNodeID() {
        return startNodeID;
    }

    public void setStartNodeID(Long startNodeID) {
        this.startNodeID = startNodeID;
    }

    public Long getEndNodeID() {
        return endNodeID;
    }

    public void setEndNodeID(Long endNodeID) {
        this.endNodeID = endNodeID;
    }

    public Integer getStartWidth() {
        return startWidth;
    }

    public void setStartWidth(Integer startWidth) {
        this.startWidth = startWidth;
    }

    public Integer getEndWidth() {
        return endWidth;
    }

    public void setEndWidth(Integer endWidth) {
        this.endWidth = endWidth;
    }

    public Integer getStartLaneNum() {
        return startLaneNum;
    }

    public void setStartLaneNum(Integer startLaneNum) {
        this.startLaneNum = startLaneNum;
    }

    public Integer getEndLaneNum() {
        return endLaneNum;
    }

    public void setEndLaneNum(Integer endLaneNum) {
        this.endLaneNum = endLaneNum;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Point getGesture() {
        return gesture;
    }

    public void setGesture(Point gesture) {
        this.gesture = gesture;
    }

    public LineString getGeom() {
        return geom;
    }

    public void setGeom(LineString geom) {
        this.geom = geom;
    }
}
