package net.modding.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.modding.main.modding;
import net.modding.registry.Eisenlegierung;

public class Eisenrezepte_Smelting extends Eisenlegierung {

	private static Crafting_Smelting c = modding.rezepte;
	
	public void EisenCrafting() {
		
	//Items
	c.ItemRecipe(Items.IRON_INGOT, "kkk", "kkk", "kkk", 'k', eisen_klumpen);
	c.ItemRecipe(ferro_ingot, "fff","fff","fff", 'f', ferro_klumpen);
	c.ItemRecipe(sili_ingot, "sss", "sss", "sss", 's', sili_klumpen);
	c.ItemRecipe(chrom_ingot, "ccc", "ccc", "ccc", 'c', chrom_klumpen);
	c.BlockRecipe(sili_block, "sss", "sss", "sss", 's', sili_ingot);
	c.BlockRecipe(ferro_block, "fff","fff","fff", 'f', ferro_ingot);
	c.BlockRecipe(chrom_block, "ccc", "ccc", "ccc", 'c', chrom_ingot);
	c.MultipleItemRecipe(ferro_dust, "eee", "ece", "ese", 'e', eisen_dust, 'c', chrom_dust, 's', sili_dust);
	c.MultipleItemRecipe(ferro_dust, "ece", "ece", "ese", 'e', eisen_dust, 'c', chrom_dust, 's', sili_dust);
	c.ShapedRecipe(chrom_ingot, "cc", 'c', chromit);
	c.ShapelessRecipe(sili_dust, sili_klumpen);
	c.ShapelessRecipe(eisen_dust, eisen_klumpen);
	c.ShapelessRecipe(chrom_dust, chrom_klumpen);
	c.ShapelessRecipe(ferro_dust, ferro_klumpen);
	c.ShapelessIntRecipe(sili_klumpen, 9, sili_ingot);
	c.ShapelessIntRecipe(chrom_klumpen, 9, chrom_ingot);
	c.ShapelessIntRecipe(eisen_klumpen, 9, Items.IRON_INGOT);
	c.ShapelessIntRecipe(ferro_klumpen, 9, ferro_ingot);
	
		//Tools
		c.ToolRezepte(ferro_ingot, ferro_shovel, ferro_sword, ferro_pickaxe, ferro_axe, ferro_hoe);
		
		//Armor
		c.ArmorRezepte(ferro_ingot, ferro_chestplate, ferro_leggings, ferro_boots, ferro_helmet);
	}
	
	public void EisenSmelting() {
		c.ItemSmelting(eisen_dust, eisen_klumpen, 1);
		c.BlockSmelting(chrom_ore, chromit, 6);
		c.ItemSmelting(chrom_dust, chrom_klumpen, 1);
		c.ItemSmelting(sili_dust, sili_klumpen, 1);
		c.ItemSmelting(ferro_dust, ferro_klumpen, 2);
		c.BlockSmelting(Blocks.STONE, 1, 1, sili_ingot, 5);
	}
}
