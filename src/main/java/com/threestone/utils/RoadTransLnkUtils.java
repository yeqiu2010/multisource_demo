package com.threestone.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by admin on 2019/12/30.
 */
public class RoadTransLnkUtils {
    public static int getDir(int dir) {
        if (dir == 2) {
            dir = 3;
        }
        return dir;
    }

    public static int getSubType(String roadForm) {
        int subType = 0;
        if (StringUtils.isEmpty(roadForm) || "0".equals(roadForm)) {
            return subType;
        }
        char[] rf = roadForm.toCharArray();
        for (int i = rf.length - 1; i >= 0; i--) {
            int temp = Integer.parseInt(String.valueOf(rf[i]));
            if (temp == 1) {
                subType = getBit(temp, i, subType);
            }
        }
        return subType;
    }

    public static int getBit(int b, int pos, int subType) {
        return b << pos | subType;
    }
}
