package hcmute.edu.vn.adminservice.api.v1.dto;

import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Getter
public class Statistics_Dto {

    private Date dateStart;
    private Date dateEnd;

    public void setDateStart(Date dateStart) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateStart);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0,0,0);
        this.dateStart = cal.getTime();
    }

    public void setDateEnd(Date dateEnd) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(dateEnd);
        cal1.set(cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH), cal1.get(Calendar.DAY_OF_MONTH), 23,59,59);
        this.dateEnd = cal1.getTime();
    }

}
