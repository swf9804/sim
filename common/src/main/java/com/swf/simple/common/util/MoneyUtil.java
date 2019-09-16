package com.swf.simple.common.util;

import java.math.BigDecimal;

/**
 * @author SWF
 * @date 2019/6/25 10:34
 **/
public class MoneyUtil {

    public static final BigDecimal ONE_YUAN = new BigDecimal("100");

    public static Short moneyYuanToFen(BigDecimal yuan){
        return yuan.multiply(ONE_YUAN).shortValue();
    }

    public static BigDecimal moneyFenToYuan(Short fen){
        return new BigDecimal(fen.toString()).divide(ONE_YUAN,2,BigDecimal.ROUND_DOWN);
    }
}
