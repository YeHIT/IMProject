package cn.yesomething.utils;

import java.lang.reflect.Array;

//用于字符串处理
public class StringHelper {
    /**
     * 将数组使用分隔符变为字符串
     * @param array
     * @param separator 默认为","
     * @return
     */
    public static String join(Object[] array, String separator) {
        return join(array, 0, array.length, separator);
    }

    /**
     * 将数组的指定位置使用分隔符变为字符串
     * @param array
     * @param separator 默认为","
     * @return
     */
    private static String join(Object[] array, int startIndex, int endIndex, String separator) {
        if (separator == null) {
            separator = ",";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i < endIndex; i++) {
            //应从开始位置后一个位置添加分隔符
            if (i > startIndex) {
                sb.append(separator);
            }

            if (array[i] != null) {
                sb.append(array[i]);
            }
        }
        return sb.toString();

    }

}
