package net.modding.items.goldlegierung.tools;

import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.modding.items.basictools.BasicItemAxe;
import net.modding.items.basictools.BasicItemShovel;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class ItemMix_shovel extends BasicItemShovel{
	
	public ItemMix_shovel() {
		super(registry.mixMaterial, "mix", registry.platinTab);
	}	
}