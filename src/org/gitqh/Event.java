package org.gitqh;

import java.util.Date;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-20-23:04
 */
public class Event {

    private Date date;
    private String event;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
