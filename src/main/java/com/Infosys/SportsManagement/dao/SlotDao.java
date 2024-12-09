package com.Infosys.SportsManagement.dao;

import java.util.List;

import com.Infosys.SportsManagement.Entity.Slot;

public interface SlotDao {
    public void saveNewSlot(Slot slot);
    public List<Slot> displayAllSlots();
    public Slot findSlotById(Long id);
    public void updateSlot(Slot slot);
    public Long generateSlotId();
    
}
