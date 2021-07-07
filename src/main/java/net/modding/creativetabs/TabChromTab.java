package net.modding.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.modding.main.Benennung_Registry;

public class TabChromTab extends CreativeTabs{

	public static Benennung_Registry registry = new Benennung_Registry();
	
	public TabChromTab() {
		super("chromTab");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(registry.ferro_chestplate);
	}

}
