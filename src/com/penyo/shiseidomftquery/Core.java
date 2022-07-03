package com.penyo.shiseidomftquery;

import java.util.Calendar;

/**
 * 该类用于处理数据。
 * 
 * @author Penyo
 */
public class Core {
    /** 生产批号。 */
    private String code;

    /** 生产日期。 */
    private int MFT_YEAR, MFT_MONTH, MFT_DATE;

    /** 保质年限。 */
    private final int LIMIT = 5;

    public Core(String code) {
        this.code = code;
    }

    /**
     * 该方法用于计算生产日期。
     * 
     * @param code 批号。
     */
    private void getMFT() {
        // 年份计算
        Calendar date = Calendar.getInstance();
        int thisYear = date.get(Calendar.YEAR);
        for (int year = thisYear; year > thisYear - 10; year--)
            if (Integer.toString(year).charAt(3) == code.charAt(0)) {
                MFT_YEAR = year;
                break;
            }

        // 月份和月份日计算
        StringBuilder thisDay = new StringBuilder();
        thisDay.append(code.charAt(1)).append(code.charAt(2)).append(code.charAt(3));
        int day = Integer.valueOf(thisDay.toString());
        date.set(MFT_YEAR, 1, 1);
        date.set(Calendar.DAY_OF_YEAR, day);
        MFT_MONTH = date.get(Calendar.MONTH) + 1;
        MFT_DATE = date.get(Calendar.DATE);
    }

    @Override
    public String toString() {
        try {
            Integer.parseInt(code.substring(0, 4));
        } catch (Exception e) {
            return "您输入了错误的生产批号！";
        }
        getMFT();
        StringBuilder result = new StringBuilder("您的产品生产于："
                + MFT_YEAR + "年" + MFT_MONTH + "月" + MFT_DATE + "日。");
        Calendar now = Calendar.getInstance(), mft = Calendar.getInstance();
        mft.set(MFT_YEAR, MFT_MONTH, MFT_DATE);
        if ((now.get(Calendar.YEAR) - mft.get(Calendar.YEAR) + 1) * 365
                + Math.abs(now.get(Calendar.DAY_OF_YEAR)
                        - mft.get(Calendar.DAY_OF_YEAR)) < LIMIT * 365)
            result.append("产品保质期为" + LIMIT + "年，请尽快使用。");
        else
            result.append("产品已过期，请勿继续使用！");
        return result.toString();
    }
}