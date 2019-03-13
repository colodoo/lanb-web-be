package com.colodoo.manager.batch.model;

import java.io.Serializable;
import java.util.Date;

/**
* @author colodoo
* @date 2019-3-13 21:15:30
* @description 
*/
public class BatchVO extends Batch implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Date dateFrom;
    private Date dateTo;

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
    
    public Date getDateFrom(Date dateFrom) {
        return this.dateFrom;
    }

    public Date getDateTo(Date dateTo) {
        return this.dateTo;
    }
}
