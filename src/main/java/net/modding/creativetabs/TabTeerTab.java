package net.modding.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class TabTeerTab extends CreativeTabs{

	public static Benennung_Registry registry = modding.registry;
	
	public TabTeerTab() {
		super("teerTab");
	}

	@Override
	public Item getTabIconItem() {
		return registry.teer_eimer;
	}
}
