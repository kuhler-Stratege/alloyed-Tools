package net.modding.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.modding.main.Benennung_Registry;

public class TabPlatinTab extends CreativeTabs{

	public static Benennung_Registry registry = new Benennung_Registry();
	
	public TabPlatinTab() {
		super("goldTab");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(registry.mix_block);
	}

}
