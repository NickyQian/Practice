package com.practice.programingperls;

/**
 * 连续子向量的最大和
 * 
 * @author qianlei
 * 
 */
public class BiggestContinuousSubvector {
    /**
     * 扫描算法 线性 (Nice!)
     * 
     * @param source
     * @return
     */
    public float findBiggest(float[] source) {
        float maxHere = 0.0f;
        float maxSoFar = 0.0f;
        for (int i = 0; i < source.length; i++) {
            /**
             * 如果当前的数值太小，加上后小于0, 说明加上下面的值，只会降低，所以则将maxHere清零，重新算连续的子向量
             * 
             * 只要不是负数，就可能相加得到最大
             */
            if (maxHere + source[i] < 0) {
                maxHere = 0;
            } else {
                maxHere += source[i];
            }
            /**
             * 最后比较是否maxHere比当前的sum大，如果大则有了新的最大连续子向量
             */
            if (maxSoFar < maxHere) {
                maxSoFar = maxHere;
            }
        }
        return maxSoFar;
    }

    /**
     * 分治算法 左边最大 右边最大 中间最大的比较
     * 
     * @param source
     * @return
     */
    public float findBiggestMergeAuth(float[] source, int first, int last) {
        if (first > last) {
            return 0;
        }
        if (first == last) {
            return max(0, source[first]);
        }
        int m = (first + last) / 2;
        float lmax = 0;
        float sum = 0;
        // 找到中点向左连续的最大值
        for (int i = m; i >= first; i--) {
            sum += source[i];
            lmax = max(lmax, sum);
        }
        float rmax = sum = 0;
        // 找到中点向右连续的最大值
        for (int i = m + 1; i < last; i++) {
            sum += source[i];
            rmax = max(rmax, sum);
        }

        return max(rmax + lmax, findBiggestMergeAuth(source, first, m),
                findBiggestMergeAuth(source, m + 1, last));
    }

    /**
     * 平方算法
     * 
     * @param source
     * @return
     */
    public float findBiggestAgain(float[] source) {
        float maxSoFar = 0;

        for (int i = 0; i < source.length; i++) {
            float sum = 0;
            for (int j = i; j < source.length; j++) {
                sum += source[j];
                maxSoFar = max(maxSoFar, sum);
            }
        }
        return maxSoFar;
    }

    private float max(float... values) {
        float maxValue = Float.NEGATIVE_INFINITY;
        for (float value : values) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        float[] source = { 1, 2, 4, 5, -9, 1 };
//        float[] source1 = new float[] { 1, 5, 4, -2, 3 };
        float[] source1 = new float[] { -1, -5, -4, -2, -3 };
        BiggestContinuousSubvector testDriver = new BiggestContinuousSubvector();
        System.out.println(testDriver.findBiggest(source));
        System.out.println(testDriver.findBiggestMergeAuth(source, 0,
                source.length - 1));
        System.out.println(testDriver.findBiggestAgain(source));
        System.out.println(testDriver.findBiggest(source1));
        System.out.println(testDriver.findBiggestAgain(source1));
    }

}
