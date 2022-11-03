package com.indoor.woopy.global.utils.time;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {

    /**
     * TimeUtil with format
     *
     * @param format 2022-11-04
     * @author skmn3
     * @since 2022.11.04
     * @return String
     **/
    public static String now(String format) {
        return ZonedDateTime.now().format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * TimeUtil
     *
     * @return ZonedDateTime
     * @author skmn3
     * @since 2022.11.04
     **/
    public static ZonedDateTime now() {

        return ZonedDateTime.now();
    }
}
