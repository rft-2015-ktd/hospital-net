package hu.unideb.hospitalnet.core.entity;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class TimeTable extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "day_of_week")
	private int dayOfWeek;

	@Column(name = "from_time")
	private Time from;

	@Column(name = "to_time")
	private Time to;

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Time getFrom() {
		return from;
	}

	public void setFrom(Time from) {
		this.from = from;
	}

	public Time getTo() {
		return to;
	}

	public void setTo(Time to) {
		this.to = to;
	}

}
