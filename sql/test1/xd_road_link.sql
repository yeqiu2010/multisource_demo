/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : PostgreSQL
 Source Server Version : 90607
 Source Host           : localhost:5432
 Source Catalog        : test1
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90607
 File Encoding         : 65001

 Date: 16/01/2020 15:24:23
*/


-- ----------------------------
-- Table structure for xd_road_link
-- ----------------------------
DROP TABLE IF EXISTS "public"."xd_road_link";
CREATE TABLE "public"."xd_road_link" (
  "ROAD_LINK_ID" int4 NOT NULL,
  "MESH" int4,
  "TIMESTAMP" int8,
  "GEOM" "public"."geometry"
)
;
