package com.Infosys.SportsManagement.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Infosys.SportsManagement.Entity.EventItem;
import com.Infosys.SportsManagement.Entity.Item;
import com.Infosys.SportsManagement.Entity.SlotItem;
import com.Infosys.SportsManagement.Entity.SlotItemEmbed;
import com.Infosys.SportsManagement.dao.EventItemDao;
import com.Infosys.SportsManagement.dao.SlotItemDao;

@Service
public class EventItemService {
  
  @Autowired
  private EventItemDao eventItemDao;
  @Autowired
  private SlotItemDao slotItemDao;
  
  public List<Item> getItemList(Long slotId){
    List<Item> itemList=new ArrayList<>();
    List<EventItem> eventList=eventItemDao.displayAllItems();
    for(EventItem event:eventList) {
      Item item=new Item(event);
      SlotItemEmbed embed=new SlotItemEmbed(slotId, event.getItemId());
      Integer seatBooked=slotItemDao.findSeatBookedById(embed);
      if(seatBooked==null)
        seatBooked=0;
      int seatVacant=event.getTotalSeat()-seatBooked.intValue();
      item.setSeatVacant(seatVacant);
      itemList.add(item);
    }
    return itemList;
  }
  
  public void addNewItemToSlots(Long itemId)
  {
    Set<SlotItemEmbed> embedSet=slotItemDao.findAllEmbeds();
    Set<Long> itemSet=new HashSet<>();
    Set<Long> slotSet=new HashSet<>();
    for(SlotItemEmbed embed:embedSet) {
      itemSet.add(embed.getItemId());
      slotSet.add(embed.getSlotId());
    }
    if(itemSet.contains(itemId)==false) {
      for(Long slotId:slotSet) {
        SlotItemEmbed embed=new SlotItemEmbed(slotId, itemId);
        SlotItem slotItem=new SlotItem(embed);
        slotItemDao.save(slotItem);
      } //end of for
    } //end of if
  } //end of function
  
}
