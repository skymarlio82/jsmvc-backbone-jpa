
package com.spa.demo.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name="EVENTS")
public class Event implements Serializable {

	private static final long serialVersionUID = 2572684341269567170L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id = 0;

	@NotNull
	@Size(min=1, max=40)
	@Column(name="TITLE")
	private String title = null;

	@NotNull
	@Size(min=1, max=400)
	@Column(name="DESCRIPTION")
	private String description = null;

	@NotNull
	@Size(min=1, max=20)
	@Column(name="START")
	private String start = null;

	@NotNull
	@Size(min=1, max=20)
	@Column(name="END")
	private String end = null;

	@NotNull
	@Size(min=1, max=20)
	@Column(name="OWNER")
	private String owner = null;

	@NotNull
	@Size(min=1, max=10)
	@Column(name="STATUS")
	private String status = null;

	@Transient
	private boolean formEditable = false;

	public Event() {
		
	}

	public Event(int id, String title, String description, String start, String end, String owner, String status, boolean formEditable) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.start = start;
		this.end = end;
		this.owner = owner;
		this.status = status;
		this.formEditable = formEditable;
	}

	public void copyFrom(Event event) {
		this.title = event.getTitle();
		this.description = event.getDescription();
		this.start = event.getStart();
		this.end = event.getEnd();
		this.owner = event.getOwner();
		this.status = event.getStatus();
		this.formEditable = event.isFormEditable();
	}
}