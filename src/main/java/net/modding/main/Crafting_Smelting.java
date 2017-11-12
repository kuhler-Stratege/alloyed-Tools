package net.modding.main;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.modding.blocks.eisenlegierung.BasicBlockEisen;
import net.modding.blocks.goldlegierung.BasicBlockGold;

public class Crafting_Smelting extends Benennung_Registry{
	
	public void RegisterCrafting() {
		
	  //Crafing Rezepte
		//Goldlegierung
			BlockRecipe(mix_block, "ppp", "ppp", "ppp", 'p', mix_ingot);
			BlockRecipe(platin_block, "ppp", "ppp", "ppp", 'p', platin_ingot);
			ItemRecipe(mix_ingot, "mmm", "mmm", "mmm", 'm', mix_klumpen);
			ItemRecipe(platin_ingot, "ppp", "ppp", "ppp", 'p', platin_klumpen);
			MultipleShapedRecipe(mix_dust, "dg", 'd', platin_dust , 'g', gold_dust);
			ShapelessRecipe(mix_dust, mix_klumpen);
			ShapelessRecipe(platin_dust, platin_klumpen);
			ShapelessRecipe(gold_dust, Items.gold_nugget);
			ShapelessIntRecipe(mix_klumpen, 9, mix_ingot);
			ShapelessIntRecipe(platin_klumpen, 9, platin_ingot);
			
				//Tools
				MultipleItemRecipe(mix_pickaxe, "mmm", " s ", " s ", 'm', mix_ingot, 's', Items.stick);
				MultipleShapedRecipe(mix_sword, "m", "m", "s", 'm', mix_ingot, 's', Items.stick);
				MultipleShapedRecipe(mix_shovel, "m", "s", "s", 'm', mix_ingot, 's', Items.stick);
				MultipleShapedRecipe(mix_axe, "mm", "ms", " s", 'm', mix_ingot, 's', Items.stick);
				MultipleShapedRecipe(mix_hoe, "mm", " s", " s", 'm', mix_ingot, 's', Items.stick);
				
				//Armor
				ShapedRecipe(mix_helmet, "mmm", "m m", 'm', mix_ingot);
				ItemRecipe(mix_chestplate, "m m", "mmm", "mmm", 'm', mix_ingot);
				ItemRecipe(mix_leggins, "mmm", "m m", "m m", 'm', mix_ingot);
				ShapedRecipe(mix_boots, "m m", "m m", 'm', mix_ingot);
			
			//Eisenlegierung
			ItemRecipe(ferro_ingot, "fff","fff","fff", 'f', ferro_klumpen);
			ItemRecipe(sili_ingot, "sss", "sss", "sss", 's', sili_klumpen);
			ItemRecipe(chrom_ingot, "ccc", "ccc", "ccc", 'c', chrom_klumpen);
			BlockRecipe(sili_block, "sss", "sss", "sss", 's', sili_ingot);
			BlockRecipe(ferro_block, "fff","fff","fff", 'f', ferro_ingot);
			BlockRecipe(chrom_block, "ccc", "ccc", "ccc", 'c', chrom_ingot);
			MultipleItemRecipe(ferro_dust, "eee", "ece", "ese", 'e', eisen_dust, 'c', chrom_dust, 's', sili_dust);
			MultipleItemRecipe(ferro_dust, "ece", "ece", "ese", 'e', eisen_dust, 'c', chrom_dust, 's', sili_dust);
			ShapedRecipe(chrom_ingot, "cc", 'c', chromit);
			ShapelessRecipe(sili_dust, sili_klumpen);
			ShapelessRecipe(eisen_dust, eisen_klumpen);
			ShapelessRecipe(chrom_dust, chrom_klumpen);
			ShapelessRecipe(ferro_dust, ferro_klumpen);
			ShapelessIntRecipe(ferro_klumpen, 9, ferro_ingot);
			ShapelessIntRecipe(sili_klumpen, 9, sili_ingot);
			ShapelessIntRecipe(chrom_klumpen, 9, chrom_ingot);
			ShapelessIntRecipe(eisen_klumpen, 9, Items.iron_ingot);
			
				//Tools
				MultipleShapedRecipe(ferro_sword, "m", "m", "s", 'm', ferro_ingot, 's', Items.stick);
				MultipleShapedRecipe(ferro_shovel, "m", "s", "s", 'm', ferro_ingot, 's', Items.stick);
				MultipleShapedRecipe(ferro_axe, "mm", "ms", " s", 'm', ferro_ingot, 's', Items.stick);
				MultipleShapedRecipe(ferro_hoe, "mm", " s", " s", 'm', ferro_ingot, 's', Items.stick);
				MultipleItemRecipe(ferro_pickaxe, "mmm", " s ", " s ", 'm', ferro_ingot, 's', Items.stick);
				
				//Armor
				ShapedRecipe(ferro_helmet, "mmm", "m m", 'm', ferro_ingot);
				ItemRecipe(ferro_chestplate, "m m", "mmm", "mmm", 'm', ferro_ingot);
				ItemRecipe(ferro_leggins, "mmm", "m m", "m m", 'm', ferro_ingot);
				ShapedRecipe(ferro_boots, "m m", "m m", 'm', ferro_ingot);
	}
	
	public void RegisterSmelting() {
		
	  //Ofenrezepte
		ItemSmelting(horse_raw, horse_cooked, 3);
		
		//Goldlegierung
			BlockSmelting(platin_ore, platin_ingot, 5);
			ItemSmelting(mix_dust, mix_klumpen, 1);
			ItemSmelting(gold_dust, Items.gold_nugget, 1);
			ItemSmelting(platin_dust, platin_klumpen, 2);
			
	    //Eisenlegierung
			ItemSmelting(eisen_dust, eisen_klumpen, 1);
			BlockSmelting(chrom_ore, chromit, 6);
			ItemSmelting(chrom_dust, chrom_klumpen, 1);
			ItemSmelting(sili_dust, sili_klumpen, 1);
			ItemSmelting(ferro_dust, ferro_klumpen, 2);
			BlockSmelting(Blocks.stone, 1, 1, sili_ingot, 5);
	}
	
	public static void ItemRecipe(Item out, String r1, String r2, String r3, char buchstabe, Item in) {
		GameRegistry.addRecipe(new ItemStack(out), r1, r2, r3, buchstabe, in);
	}
	
	public static void MultipleItemRecipe(Item out, String r1, String r2, String r3, char buchstabe1, Item in1, char buchstabe2, Item in2) {
		GameRegistry.addRecipe(new ItemStack(out), r1, r2, r3, buchstabe1, in1, buchstabe2, in2);
	}
	
	public static void MultipleItemRecipe(Item out, String r1, String r2, String r3, char buchstabe1, Item in1, char buchstabe2, Item in2, char buchstabe3, Item in3) {
		GameRegistry.addRecipe(new ItemStack(out), r1, r2, r3, buchstabe1, in1, buchstabe2, in2, buchstabe3, in3);
	}
	
	public static void BlockRecipe(Block out, String r1, String r2, String r3, char buchstabe, Item in) {
		GameRegistry.addRecipe(new ItemStack(out), r1, r2, r3, buchstabe, in);
	}
	
	public static void MultipleBlockRecipe(Block out, String r1, String r2, String r3, char buchstabe1, Item in1, char buchstabe2, Item in2) {
		GameRegistry.addRecipe(new ItemStack(out), r1, r2, r3, buchstabe1, in1, buchstabe2, in2);
	}
	
	public static void MultipleShapedRecipe(Item out, String r1, String r2, String r3, char buchstabe1, Item in1, char buchstabe2, Item in2) {
		GameRegistry.addShapedRecipe(new ItemStack(out), r1, r2, r3, buchstabe1, in1, buchstabe2, in2);
	}
	
	public static void MultipleShapedRecipe(Item out, String r1, String r2, String r3, char buchstabe1, Item in1, char buchstabe2, Item in2, char buchstabe3, Item in3) {
		GameRegistry.addShapedRecipe(new ItemStack(out), r1, r2, r3, buchstabe1, in1, buchstabe2, in2, buchstabe3, in3);
	}
	
	public static void MultipleShapedRecipe(Item out, String r1, char buchstabe1, Item in1, char buchstabe2, Item in2) {
		GameRegistry.addShapedRecipe(new ItemStack(out), r1, buchstabe1, in1, buchstabe2, in2);
	}

	public static void MultipleShapedRecipe(Item out, String r1, String r2, char buchstabe1, Item in1, char buchstabe2, Item in2) {
		GameRegistry.addShapedRecipe(new ItemStack(out), r1, r2, buchstabe1, in1, buchstabe2, in2);
	}
	
	public static void ShapedRecipe(Item out, String r1, String r2, String r3, char buchstabe, Item in) {
		GameRegistry.addShapedRecipe(new ItemStack(out), r1, r2, r3, buchstabe, in);
	}
	
	public static void ShapedRecipe(Item out, String r1, char buchstabe, Item in) {
		GameRegistry.addShapedRecipe(new ItemStack(out), r1, buchstabe, in);
	}
	
	public static void ShapedIntRecipe(Item out, int menge, String r1, char buchstabe, Item in) {
		GameRegistry.addShapedRecipe(new ItemStack(out, menge), r1, buchstabe, in);
	}
	
	public static void ShapedRecipe(Item out, String r1, String r2, char buchstabe, Item in) {
		GameRegistry.addShapedRecipe(new ItemStack(out), r1, r2, buchstabe, in);
	}
	
	public static void ShapedBlockRecipe(Block out, Object params) {
		GameRegistry.addShapedRecipe(new ItemStack(out), params);
	}
	
	public static void ShapelessRecipe(Item out, Item in) {
		GameRegistry.addShapelessRecipe(new ItemStack(out), in);
	}
	
	public static void ShapelessIntRecipe(Item out, int menge, Item in) {
		GameRegistry.addShapelessRecipe(new ItemStack(out, menge), in);
	}
	
	public static void ShapelessBlockRecipe(Block out, Item in) {
		GameRegistry.addShapelessRecipe(new ItemStack(out), in);
	}
	
	public static void ShapelessIntBlockRecipe(Block out, Item in, int menge) {
		GameRegistry.addShapelessRecipe(new ItemStack(out, menge), in);
	}
	
	public static void BlockSmelting(Block in, Item out, float xp) {
		GameRegistry.addSmelting(in, new ItemStack(out), xp);
	}
	
	public static void BlockSmelting(Block in, int menge, int meta, Item out, float xp) {
		GameRegistry.addSmelting(new ItemStack(in, menge, meta), new ItemStack(out), xp);
	}
	
	public static void ItemSmelting(Item in, Item out, float xp) {
		GameRegistry.addSmelting(in, new ItemStack(out), xp);
	}
	
	
}
