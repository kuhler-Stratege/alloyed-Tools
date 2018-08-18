package net.modding.items.goldlegierung;

import net.minecraft.item.Item;
import net.modding.main.modding;
import net.modding.registry.Benennung_Registry;

public class BasicItemGold extends Item {
	
	public static Benennung_Registry registry = modding.registry;
	
	public BasicItemGold(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(registry.platinTab);
	}	
}