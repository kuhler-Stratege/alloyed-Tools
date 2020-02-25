package net.modding.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.modding.main.modding;
import net.modding.registry.Benennung_Registry;

public class TabTeerTab extends CreativeTabs{

	public static Benennung_Registry registry = modding.registry;
	
	public TabTeerTab() {
		super("teerTab");
	}

	@Override
	public Item getTabIconItem() {
		return registry.holz.teer_eimer;
	}
}
