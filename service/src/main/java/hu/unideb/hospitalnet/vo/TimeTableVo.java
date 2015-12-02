package hu.unideb.hospitalnet.vo;

import java.io.Serializable;
import java.sql.Time;

public class TimeTableVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Time from;

	private Time to;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
