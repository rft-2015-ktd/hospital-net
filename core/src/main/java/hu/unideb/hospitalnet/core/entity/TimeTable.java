package hu.unideb.hospitalnet.core.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class TimeTable extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "day_of_week")
	private int dayOfWeek;

	@Column(name = "from_time")
	private Date from;

	@Column(name = "to_time")
	private Date to;

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

}
