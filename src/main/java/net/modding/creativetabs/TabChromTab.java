package net.modding.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.modding.main.modding;
import net.modding.registry.Benennung_Registry;

public class TabChromTab extends CreativeTabs{

	public static Benennung_Registry registry = modding.registry;
	
	public TabChromTab() {
		super("chromTab");
	}

	@Override
	public Item getTabIconItem() {
		return registry.eisen.ferro_chestplate;
	}
	
}
