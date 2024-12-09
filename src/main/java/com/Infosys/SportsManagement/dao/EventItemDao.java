package com.Infosys.SportsManagement.dao;

import java.util.List;

import com.Infosys.SportsManagement.Entity.EventItem;

public interface EventItemDao {
    public void saveNewItem(EventItem eventItem);
    public List<EventItem> displayAllItems();
    public EventItem findItemById(Long id);
    public Long generateItemId();
    public void updateItem(EventItem eventItem);
    public Integer findTotalSeatById(Long id);
}
