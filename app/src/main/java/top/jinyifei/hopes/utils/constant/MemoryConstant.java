package top.jinyifei.hopes.utils.constant;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * author: jinyifei
 * time:  Created on 2017/7/25 16:32
 * email：jyf@whu.edu.cn
 * function：存储相关常量
 */
public class MemoryConstant {

    /**
     * Byte与Byte的倍数
     */
    public static final int BYTE = 1;
    /**
     * KB与Byte的倍数
     */
    public static final int KB = 1024;
    /**
     * MB与Byte的倍数
     */
    public static final int MB = 1048576;
    /**
     * GB与Byte的倍数
     */
    public static final int GB = 1073741824;

    @IntDef({BYTE, KB, MB, GB})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Unit {
    }
}
