package com.Infosys.SportsManagement.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="event_item")
public class EventItem  {
  @Id
  private long itemId;
  private String itemName;
  private Integer totalSeat;
  public EventItem() {
  super();
  // TODO Auto-generated constructor stub
  }
  public EventItem(long itemId, String itemName, Integer totalSeat) {
  super();
  this.itemId = itemId;
  this.itemName = itemName;
  this.totalSeat = totalSeat;
  }
  public long getItemId() {
  return itemId;
  }
  public void setItemId(long itemId) {
  this.itemId = itemId;
  }
  public String getItemName() {
  return itemName;
  }
  public void setItemName(String itemName) {
  this.itemName = itemName;
  }
  public Integer getTotalSeat() {
  return totalSeat;
  }
  public void setTotalSeat(Integer totalSeat) {
  this.totalSeat = totalSeat;
  }
}
