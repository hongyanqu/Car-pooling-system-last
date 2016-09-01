/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.mum.carpooling.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 *
 * @author Paulos Haylu <your.name at your.org>
 */
public class MyUtils {

    public static LocalDateTime dateConvert(java.sql.Timestamp timeStamp) {
       return timeStamp == null? null: timeStamp.toLocalDateTime();
    }

    public static java.sql.Timestamp localTimeToTimeStamp(LocalDateTime lt) {
        return lt == null ? null : new java.sql.Timestamp(lt.atZone(ZoneId.systemDefault()).toInstant()
                .toEpochMilli());
    }
}
