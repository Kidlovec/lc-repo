package io.kidlovec.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * todo  description
 *
 * @author Fan Wenjie
 * @since 2021/8/20
 */
public class DateUtil {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDateTime formattedDate = LocalDateTime.parse("2021-05-10 23:16:45", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(now);
        System.out.println(formattedDate);
    }
}
