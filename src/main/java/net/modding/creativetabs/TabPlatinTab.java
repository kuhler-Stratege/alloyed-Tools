package net.modding.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class TabPlatinTab extends CreativeTabs{

	public static Benennung_Registry registry = modding.registry;
	
	public TabPlatinTab() {
		super("goldTab");
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(registry.mix_block);
	}
}
