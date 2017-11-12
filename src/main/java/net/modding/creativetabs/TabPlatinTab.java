package net.modding.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class TabPlatinTab extends CreativeTabs{

	public static Benennung_Registry registry = modding.registry;
	
	public TabPlatinTab() {
		super("goldTab");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(registry.mix_block);
	}
}
