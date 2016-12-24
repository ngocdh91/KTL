package kl.tool.ngoc.ktl;

import java.text.DecimalFormat;

/**
 * Created by Ngocdh on 29,November,2016
 */

public class Util {
    private static DecimalFormat dfNumber = new DecimalFormat("###.####################################");

    public static String formatNumberDecimal(double d) {
        return dfNumber.format(d);
    }
}
