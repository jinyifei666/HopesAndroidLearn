package top.jinyifei.hopes.activitys;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * author: jinyifei
 * time:  Created on 2017/7/25 13:22
 * email：jyf@whu.edu.cn
 * function：Activity管理容器
 */
public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
