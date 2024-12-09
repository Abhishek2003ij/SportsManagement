package com.Infosys.SportsManagement.Entity;

public class Item  {

    private long itemId;
    private String itemName;
    private Integer totalSeat;
    private Integer seatVacant;
    public Item() {
    super();
    // TODO Auto-generated constructor stub
    }
    public Item(EventItem event) {
          this.itemId = event.getItemId();
          this.itemName = event.getItemName();
          this.totalSeat = event.getTotalSeat();
          this.seatVacant = 0;
      }
  public Item(long itemId, String itemName, Integer totalSeat, Integer seatVacant) {
      super();
      this.itemId = itemId;
      this.itemName = itemName;
      this.totalSeat = totalSeat;
      this.seatVacant = seatVacant;
  }
  @Override
  public String toString() {
      return "Item [itemId=" + itemId + ", itemName=" + itemName + ", totalSeat=" + totalSeat + ", seatVacant="
              + seatVacant + "]";
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
  public Integer getSeatVacant() {
      return seatVacant;
  }
  public void setSeatVacant(Integer seatVacant) {
      this.seatVacant = seatVacant;
  }
  }
