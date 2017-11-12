package net.modding.items;

import net.modding.main.Benennung_Registry;
import net.modding.main.modding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class BasicFood extends ItemFood {
	
	public static Benennung_Registry registry = new Benennung_Registry();
	
	public BasicFood(String name, int amount, boolean isWolfFood) {
		super(amount, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.FOOD);
	}	
}