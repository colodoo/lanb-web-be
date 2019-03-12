package ${packageName}.model;

import java.io.Serializable;
import java.util.Date;

/**
* @author colodoo
* @date ${.now?date} ${.now?time}
* @description 
*/
public class ${tableName?cap_first}VO extends ${tableName?cap_first} implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Date dateFrom;
    private Date dateTo;

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
}