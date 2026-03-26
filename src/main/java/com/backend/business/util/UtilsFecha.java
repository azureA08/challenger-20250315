package com.backend.business.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/***
 * Utiles para formatear fechas
 */

public class UtilsFecha {

    public static Calendar convertIntToCalendar(int dateInt) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        String dateString = String.valueOf(dateInt);
        Date date = inputFormat.parse(dateString);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar;
    }

    //
    public static int convertCalenderToInt(LocalDate localDate) {
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        return year * 10000 + month * 100 + day;
    }

    /***
     * @return Fecha actul como int ,formato yyyyMMDD
     */
    public Integer getFechaActual() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String fechaStr = dateFormat.format(currentDate);
        return Integer.parseInt(fechaStr);
    }

    //Ejemplo formatoFecha= "dd/MM/yyyy"
    public String formatDate(Calendar calendar, String formatoFecha) {
        SimpleDateFormat outputFormat = new SimpleDateFormat(formatoFecha, Locale.getDefault());
        return outputFormat.format(calendar.getTime());
    }
}
