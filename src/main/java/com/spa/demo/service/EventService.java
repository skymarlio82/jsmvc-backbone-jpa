
package com.spa.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spa.demo.entity.Event;
import com.spa.demo.repository.EventDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("eventService")
public class EventService {

	@Autowired
	private EventDao eventDao = null;

	@Transactional(readOnly=true)
	@Cacheable(value="readAllEventsCache")
	public List<Event> readAllEvents() {
		List<Event> eventList = eventDao.findAll();
		log.debug("getAllEvents : size = " + eventList.size());
		return eventList;
	}

	@Transactional(readOnly=true)
	public List<Event> readEventsByCategory(String category) {
		List<Event> res = null;
		if (category.equals("all")) {
			res = eventDao.findAll();
		} else {
			res = eventDao.findByStatus(category);
		}
		log.debug("getEventsByCategory : category = " + category + ", size = " + res.size());
		return res;
	}

	@Transactional(readOnly=true)
	public Event readEventDetailByTitle(String title) {
		return eventDao.findByTitle(title);
	}

	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
	public Event updateEvent(Event event) {
		log.debug("Before updating Event record from web request : " + event);
		eventDao.saveAndFlush(event);
		log.debug("After being updated Event record into DB : " + event);
		return event;
	}

	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
	public Event createEvent(Event event) {
		log.debug("Before creating Event record from web request : " + event);
		event.setStatus("Opening");
		eventDao.save(event);
		log.debug("After being created Event record into DB : " + event);
		return event;
	}

	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
	public Event deleteEvent(int id) {
		Event event = eventDao.getOne(id);
		log.debug("Before deleting Event record in DB : " + event);
		eventDao.delete(event);
		log.debug("After being deleted Event record from DB : " + event);
		return event;
	}

	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
	public void initData() {
		log.info("start to initialize DB ...");
		eventDao.save(new Event(0, "UI Issue", "Checkbox not pop up", "01/01/2017", "01/02/2017", "Tom", "Opening", false));
		eventDao.save(new Event(0, "SQL Statement Error", "Select syntax wrong", "02/01/2017", "02/02/2017", "Jim", "Opening", false));
		eventDao.save(new Event(0, "Spring AOP No Dependency", "JAR lib missed", "04/01/2017", "04/02/2017", "Bob", "Opening", false));
		eventDao.save(new Event(0, "Java Null Point Error", "Java Object not found", "03/01/2017", "03/02/2017", "Joe", "Opening", false));
	}
}