package com.wjc.demo.common.utils;

import java.util.Random;

/**
 * @ProjectName: demo
 * @Package: com.wjc.demo.common.utils
 * @ClassName: DingTalkUtils
 * @Description: java类作用描述
 * @Author: wangjc
 * @CreateDate: 2020/1/9 0009 14:10
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/9 0009 14:10
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
public class DingTalkUtils {
    /**
     *
     * @return
     */
    public static String getRandomStr(int count) {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
