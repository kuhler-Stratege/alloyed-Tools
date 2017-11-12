package net.modding.items.eisenlegierung;

import net.modding.main.Benennung_Registry;
import net.modding.main.modding;
import net.minecraft.item.Item;

public class BasicItemEisen extends Item {
	
	public static Benennung_Registry registry = new Benennung_Registry();
	
	public BasicItemEisen(String name) {
		setUnlocalizedName(name);
		setCreativeTab(registry.chromTab);
	}	
}