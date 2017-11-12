package net.modding.items.goldlegierung;

import net.modding.main.Benennung_Registry;
import net.modding.main.modding;
import net.minecraft.item.Item;

public class BasicItemGold extends Item {
	
	public static Benennung_Registry registry = modding.registry;
	
	public BasicItemGold(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(registry.platinTab);
	}	
}