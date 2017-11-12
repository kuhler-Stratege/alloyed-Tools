package net.modding.items.goldlegierung.tools;

import net.minecraft.item.ItemPickaxe;
import net.modding.items.basictools.BasicItemAxe;
import net.modding.items.basictools.BasicItemPickaxe;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class ItemMix_pickaxe extends BasicItemPickaxe{
	
	public ItemMix_pickaxe() {
		super(registry.mixMaterial, "mix", registry.platinTab);
	}	
}