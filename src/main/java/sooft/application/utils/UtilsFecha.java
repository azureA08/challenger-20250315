package sooft.application.utils;

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
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        Instant instant = zonedDateTime.toInstant();
        Date date = Date.from(instant);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return (calendar.get(Calendar.YEAR) + calendar.get(Calendar.MONTH) + calendar.get(Calendar.DAY_OF_MONTH));
    }

    /***
     * @return Fecha actul como int ,formato yyyyMMDD
     */
    public Integer getFechaActual() {
        long ts = System.currentTimeMillis() / 1000;
        Date currentDate = new Date(ts);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String fechaStr = dateFormat.format(currentDate);
        return Integer.getInteger(fechaStr.replace("-", ""));
    }

    //Ejemplo formatoFecha= "dd/MM/yyyy"
    public String formatDate(Calendar calendar, String formatoFecha) {
        SimpleDateFormat outputFormat = new SimpleDateFormat(formatoFecha, Locale.getDefault());
        return outputFormat.format(calendar.getTime());
    }
}
