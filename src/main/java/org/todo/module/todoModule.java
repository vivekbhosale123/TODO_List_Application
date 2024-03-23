package org.todo.module;

import java.sql.Date;
import java.sql.Time;

public class todoModule {
	private int id;
	private String title;
	private String description;
	private Date tdate;
	private int status;
	private String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time1) {
		this.time = time1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTdate() {
		return tdate;
	}

	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "todoModule [id=" + id + ", title=" + title + ", description=" + description + ", tdate=" + tdate
				+ ", status=" + status + "]";
	}
}
