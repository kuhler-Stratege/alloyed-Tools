package net.modding.items.goldlegierung.tools;

import net.minecraft.item.ItemHoe;
import net.minecraft.item.Item.ToolMaterial;
import net.modding.items.basictools.BasicItemAxe;
import net.modding.items.basictools.BasicItemHoe;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class ItemMix_hoe extends BasicItemHoe{
	
	public ItemMix_hoe() {
		super(registry.mixMaterial, "mix", registry.platinTab);
	}	
}