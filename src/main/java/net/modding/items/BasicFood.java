package net.modding.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.modding.main.modding;
import net.modding.registry.Benennung_Registry;

public class BasicFood extends ItemFood {
	
	public static Benennung_Registry registry = modding.registry;
	
	public BasicFood(String name, int amount, boolean isWolfFood) {
		super(amount, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.FOOD);
	}	
}