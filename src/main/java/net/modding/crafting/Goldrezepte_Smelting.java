package net.modding.crafting;

import net.minecraft.init.Items;
import net.modding.registry.Goldlegierung;

public class Goldrezepte_Smelting extends Goldlegierung {

	private Crafting_Smelting c;
	
	public void GoldCrafting() {
	
	c = new Crafting_Smelting();
		
	//Items
	c.BlockRecipe(mix_block, "ppp", "ppp", "ppp", 'p', mix_ingot);
	c.BlockRecipe(platin_block, "ppp", "ppp", "ppp", 'p', platin_ingot);
	c.ItemRecipe(mix_ingot, "mmm", "mmm", "mmm", 'm', mix_klumpen);
	c.ItemRecipe(platin_ingot, "ppp", "ppp", "ppp", 'p', platin_klumpen);
	c.ShapedRecipe(mix_dust, "dg", 'd', platin_dust , 'g', gold_dust);
	c.ShapelessRecipe(mix_dust, mix_klumpen);
	c.ShapelessRecipe(platin_dust, platin_klumpen);
	c.ShapelessRecipe(gold_dust, Items.GOLD_NUGGET);
	c.ShapelessIntRecipe(mix_klumpen, 9, mix_ingot);
	c.ShapelessIntRecipe(platin_klumpen, 9, platin_ingot);
	
		//Tools
		c.ToolRezepte(mix_ingot, mix_shovel, mix_sword, mix_pickaxe, mix_axe, mix_hoe);
		
		//Armor
		c.ArmorRezepte(mix_ingot, mix_chestplate, mix_leggings, mix_boots, mix_helmet);
	
	}
	
	public void GoldSmelting() {
		c.BlockSmelting(platin_ore, platin_ingot, 5);
		c.ItemSmelting(mix_dust, mix_klumpen, 1);
		c.ItemSmelting(gold_dust, Items.GOLD_NUGGET, 1);
		c.ItemSmelting(platin_dust, platin_klumpen, 2);
	}
}
