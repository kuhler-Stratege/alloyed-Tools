package net.modding.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.modding.main.modding;
import net.modding.registry.Benennung_Registry;

public class TabPlatinTab extends CreativeTabs{

	public static Benennung_Registry registry = modding.registry;
	
	public TabPlatinTab() {
		super("goldTab");
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(registry.gold.mix_block);
	}
}
