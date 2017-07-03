package com.ideal.jalen.utils;

import com.ideal.jalen.R;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class IconsHelperUtil {

    public static List<Integer> BEE_ICONS =
            Arrays.asList(R.mipmap.bee_01, R.mipmap.bee_02, R.mipmap.bee_03, R.mipmap.bee_04, R.mipmap.bee_05,
                    R.mipmap.bee_06, R.mipmap.bee_07, R.mipmap.bee_08, R.mipmap.bee_09, R.mipmap.bee_10,
                    R.mipmap.bee_11, R.mipmap.bee_12, R.mipmap.bee_13, R.mipmap.bee_14, R.mipmap.bee_13,
                    R.mipmap.bee_16, R.mipmap.bee_17, R.mipmap.bee_18, R.mipmap.bee_19);

    public static Integer getRandomBeeIcon() {
        return BEE_ICONS.get(new Random().nextInt(BEE_ICONS.size()));
    }

    public static int[] colors = new int[]{
            android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_orange_light,
            android.R.color.holo_red_light
    };
}
