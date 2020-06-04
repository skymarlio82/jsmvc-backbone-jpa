
package com.spa.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Event implements Serializable {

	private static final long serialVersionUID = 7178290707131623011L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id = 0;

	@NotNull
	@Size(min=1, max=40)
	private String title = null;

	@NotNull
	@Size(min=1, max=400)
	private String description = null;

	@NotNull
	@Size(min=1, max=20)
	private String start = null;

	@NotNull
	@Size(min=1, max=20)
	private String end = null;

	@NotNull
	@Size(min=1, max=20)
	private String owner = null;

	@NotNull
	@Size(min=1, max=10)
	private String status = null;

	@Transient
	private boolean formEditable = false;

	public Event() {
		
	}

	public Event(int id, String title, String description, String start, String end, String owner, String status,
		boolean formEditable) {
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