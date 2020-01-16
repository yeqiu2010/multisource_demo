/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : PostgreSQL
 Source Server Version : 90607
 Source Host           : localhost:5432
 Source Catalog        : test
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90607
 File Encoding         : 65001

 Date: 16/01/2020 15:24:03
*/


-- ----------------------------
-- Table structure for roadlinkshape
-- ----------------------------
DROP TABLE IF EXISTS "public"."roadlinkshape";
CREATE TABLE "public"."roadlinkshape" (
  "objectID" int4 NOT NULL,
  "mesh" int4,
  "geom" "public"."geometry"
)
;

-- ----------------------------
-- Primary Key structure for table roadlinkshape
-- ----------------------------
ALTER TABLE "public"."roadlinkshape" ADD CONSTRAINT "marklinkshape_pkey" PRIMARY KEY ("objectID");
