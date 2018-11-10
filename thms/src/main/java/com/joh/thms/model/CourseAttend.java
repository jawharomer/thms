package com.joh.thms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "COURSE_ATTENDS")
public class CourseAttend {

	@Column(name = "I_COURSE_ATTEND")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "ATTEND_TIME", insertable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp()
	@ColumnDefault("CURRENT_TIMESTAMP")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date time;

	@Column(name = "NOTE")
	private String note;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "CourseAttend [id=" + id + ", time=" + time + ", note=" + note + "]";
	}

}
