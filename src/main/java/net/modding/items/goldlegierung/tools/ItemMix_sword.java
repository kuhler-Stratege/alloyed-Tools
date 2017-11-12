package net.modding.items.goldlegierung.tools;

import net.minecraft.item.ItemSword;
import net.modding.items.basictools.BasicItemAxe;
import net.modding.items.basictools.BasicItemSword;
import net.modding.main.Benennung_Registry;

public class ItemMix_sword extends BasicItemSword{
	
	public ItemMix_sword() {
		super(registry.mixMaterial, "mix", registry.platinTab);
	}	
}