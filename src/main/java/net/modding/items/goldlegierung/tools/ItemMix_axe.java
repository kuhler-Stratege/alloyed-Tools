package net.modding.items.goldlegierung.tools;

import net.minecraft.item.ItemAxe;
import net.modding.items.basictools.BasicItemAxe;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class ItemMix_axe extends BasicItemAxe{
	
	public ItemMix_axe() {
		super(registry.mixMaterial, "mix", registry.platinTab);
	}	
}