package basics.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DateUtils {
    public static void main(String[] args) {
        getDateOfWeek();
    }

    public static List<String> getDateOfWeek(){
        List<String> dateStr=new ArrayList<>();
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.clear(Calendar.MINUTE);
        calendar.clear(Calendar.SECOND);
        calendar.clear(Calendar.MILLISECOND);
        calendar.set(Calendar.DAY_OF_WEEK,calendar.getFirstDayOfWeek());
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        for(int i=0;i<7;i++){
            calendar.add(Calendar.DATE,1);
            dateStr.add(simpleDateFormat.format(calendar.getTime()));
        }
        return dateStr;
    }
}
