package net.modding.items.holzlackierung;

import net.modding.main.Benennung_Registry;
import net.modding.main.modding;
import net.minecraft.item.Item;

public class BasicItemTeer extends Item {
	
	public static Benennung_Registry registry = modding.registry;
	
	public BasicItemTeer(String name) {
		setUnlocalizedName(name);
		setCreativeTab(registry.teerTab);
	}	
}