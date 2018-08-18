package net.modding.items.eisenlegierung;

import net.minecraft.item.Item;
import net.modding.main.modding;
import net.modding.registry.Benennung_Registry;

public class BasicItemEisen extends Item {
	
	public static Benennung_Registry registry = modding.registry;
	
	public BasicItemEisen(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(registry.chromTab);
	}	
}