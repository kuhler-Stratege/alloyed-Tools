package net.modding.items.holzlackierung;

import net.minecraft.item.Item;
import net.modding.main.modding;
import net.modding.registry.Holzlackierung;

public class BasicItemTeer extends Item {
	
	protected Holzlackierung registry = modding.registry.holz;
	
	public BasicItemTeer(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(registry.teerTab);
	}	
}