package com.Infosys.SportsManagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Infosys.SportsManagement.Entity.EventItem;

@Repository
@Service
public class EventItemDaoImpl implements EventItemDao {

    @Autowired
    private EventItemRepository repository;

    @Override
    public void saveNewItem(EventItem eventItem) {
        repository.save(eventItem);    
    }

    @Override
    public List<EventItem> displayAllItems() {
        return repository.findAll();
    }

    @Override
    public EventItem findItemById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Long generateItemId() {
        Long val = repository.findLastItemId();
        if(val == null)
            val = 1L;
        else
            val = val + 1;
        return val;
    }
    
    @Override
	public Integer findTotalSeatById(Long id) {
		return repository.findTotalSeatById(id);
	}

    @Override
    public void updateItem(EventItem eventItem) {
        if (repository.existsById(eventItem.getItemId())) {
            repository.save(eventItem); 
        } else {
            throw new IllegalArgumentException("Item with ID " + eventItem.getItemId() + " not found");
        }
    }

}
