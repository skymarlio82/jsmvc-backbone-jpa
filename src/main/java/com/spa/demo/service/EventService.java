package com.spa.demo.service;

import com.spa.demo.entity.Event;
import com.spa.demo.repository.EventRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventService {
    private final Logger logger = LoggerFactory.getLogger(EventService.class);

    private final EventRepo eventRepo;

    public EventService(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Transactional(readOnly = true)
//	@Cacheable(value="readAllEventsCache")
    public List<Event> readAllEvents() {
        List<Event> eventList = eventRepo.findAll();
        logger.debug("getAllEvents : size = {}", eventList.size());
        return eventList;
    }

    @Transactional(readOnly = true)
    public List<Event> readEventsByCategory(String category) {
        List<Event> res = null;
        if (category.equals("all")) {
            res = eventRepo.findAll();
        } else {
            res = eventRepo.findByStatus(category);
        }
        logger.debug("getEventsByCategory : category = {}, size = {}", category, res.size());
        return res;
    }

    @Transactional(readOnly = true)
    public Event readEventDetailByTitle(String title) {
        return eventRepo.findByTitle(title);
    }

    @Transactional
    public Event updateEvent(Event event) {
        logger.debug("Before updating Event record from web request : {}", event);
        eventRepo.saveAndFlush(event);
        logger.debug("After being updated Event record into DB : {}", event);
        return event;
    }

    @Transactional
    public Event createEvent(Event event) {
        logger.debug("Before creating Event record from web request : {}", event);
        event.setStatus("Opening");
        eventRepo.save(event);
        logger.debug("After being created Event record into DB : {}", event);
        return event;
    }

    @Transactional
    public Event deleteEvent(int id) {
        Event event = eventRepo.getOne(id);
        logger.debug("Before deleting Event record in DB : {}", event);
        eventRepo.delete(event);
        logger.debug("After being deleted Event record from DB : {}", event);
        return event;
    }
}