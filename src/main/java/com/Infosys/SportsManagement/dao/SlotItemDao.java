package com.Infosys.SportsManagement.dao;

import java.util.List;
import java.util.Set;

import com.Infosys.SportsManagement.Entity.SlotItem;
import com.Infosys.SportsManagement.Entity.SlotItemEmbed;

public interface SlotItemDao {
	public void save(SlotItem slotItem);
	public Integer findSeatBookedById(SlotItemEmbed id);
	public Set<SlotItemEmbed> findAllEmbeds();
	public SlotItem findById(SlotItemEmbed embed);
	public List<SlotItem> displayEmptySlots();
	public List<SlotItem> displayBookedSlots();
}
