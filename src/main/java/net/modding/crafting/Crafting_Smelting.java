package net.modding.crafting;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.modding.blocks.eisenlegierung.BasicBlockEisen;
import net.modding.blocks.goldlegierung.BasicBlockGold;
import net.modding.main.Benennung_Registry;

public class Crafting_Smelting extends Benennung_Registry{
		
	public void RegisterCrafting() {
		
	  //Crafting Rezepte
		//Goldlegierung
			BlockRecipe(mix_block, "ppp", "ppp", "ppp", 'p', mix_ingot);
			BlockRecipe(platin_block, "ppp", "ppp", "ppp", 'p', platin_ingot);
			ItemRecipe(mix_ingot, "mmm", "mmm", "mmm", 'm', mix_klumpen);
			ItemRecipe(platin_ingot, "ppp", "ppp", "ppp", 'p', platin_klumpen);
			MultipleShapedRecipe(mix_dust, "dg", 'd', platin_dust , 'g', gold_dust);
			ShapelessRecipe(mix_dust, mix_klumpen);
			ShapelessRecipe(platin_dust, platin_klumpen);
			ShapelessRecipe(gold_dust, Items.GOLD_NUGGET);
			ShapelessIntRecipe(mix_klumpen, 9, mix_ingot);
			ShapelessIntRecipe(platin_klumpen, 9, platin_ingot);
			
				//Tools
				MultipleItemRecipe(mix_pickaxe, "mmm", " s ", " s ", 'm', mix_ingot, 's', Items.STICK);
				MultipleShapedRecipe(mix_sword, "m", "m", "s", 'm', mix_ingot, 's', Items.STICK);
				MultipleShapedRecipe(mix_shovel, "m", "s", "s", 'm', mix_ingot, 's', Items.STICK);
				MultipleShapedRecipe(mix_axe, "mm", "ms", " s", 'm', mix_ingot, 's', Items.STICK);
				MultipleShapedRecipe(mix_hoe, "mm", " s", " s", 'm', mix_ingot, 's', Items.STICK);
				
				//Armor
				ShapedRecipe(mix_helmet, "mmm", "m m", 'm', mix_ingot);
				ItemRecipe(mix_chestplate, "m m", "mmm", "mmm", 'm', mix_ingot);
				ItemRecipe(mix_leggings, "mmm", "m m", "m m", 'm', mix_ingot);
				ShapedRecipe(mix_boots, "m m", "m m", 'm', mix_ingot);
			
			//Eisenlegierung
			ItemRecipe(Items.IRON_INGOT, "kkk", "kkk", "kkk", 'k', eisen_klumpen);
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
			ShapelessIntRecipe(sili_klumpen, 9, sili_ingot);
			ShapelessIntRecipe(chrom_klumpen, 9, chrom_ingot);
			ShapelessIntRecipe(eisen_klumpen, 9, Items.IRON_INGOT);
			ShapelessIntRecipe(ferro_klumpen, 9, ferro_ingot);
			
				//Tools
				MultipleShapedRecipe(ferro_sword, "m", "m", "s", 'm', ferro_ingot, 's', Items.STICK);
				MultipleShapedRecipe(ferro_shovel, "m", "s", "s", 'm', ferro_ingot, 's', Items.STICK);
				MultipleShapedRecipe(ferro_axe, "mm", "ms", " s", 'm', ferro_ingot, 's', Items.STICK);
				MultipleShapedRecipe(ferro_hoe, "mm", " s", " s", 'm', ferro_ingot, 's', Items.STICK);
				MultipleItemRecipe(ferro_pickaxe, "mmm", " s ", " s ", 'm', ferro_ingot, 's', Items.STICK);
				
				//Armor
				ShapedRecipe(ferro_helmet, "mmm", "m m", 'm', ferro_ingot);
				ItemRecipe(ferro_chestplate, "m m", "mmm", "mmm", 'm', ferro_ingot);
				ItemRecipe(ferro_leggings, "mmm", "m m", "m m", 'm', ferro_ingot);
				ShapedRecipe(ferro_boots, "m m", "m m", 'm', ferro_ingot);
				
			//Holzlackierung
				MultipleShapedRecipe(kohle_eimer, "k", "e", 'k', new ItemStack(Items.COAL, 1, 0), 'e', Items.BUCKET);
				MultipleShapedRecipe(kohle_eimer, "k", "e", 'k', new ItemStack(Items.COAL, 1, 1), 'e', Items.BUCKET);
				ShapedBlockRecipe(plank_teer, "t", "p", 'p', Blocks.PLANKS, 't', teer_eimer); 
				ShapedBlockRecipe(Blocks.PLANKS, "w", "p", 'p', plank_teer, 'w', Items.WATER_BUCKET);
				MultipleShapedRecipe(Items.STICK, "w", "p", 'p', teer_stick, 'w', Items.WATER_BUCKET);
				ShapedIntRecipe(teer_stick, 4, "p", "p", 'p', plank_teer);
				ShapedRecipe(teer_stick, "t", "s", 't', teer_eimer, 's', Items.STICK);
				ShapedBlockRecipe(teer_knopf, "t", "k", 't', teer_eimer, 'k', Blocks.WOODEN_BUTTON);
				ShapelessBlockRecipe(teer_knopf, plank_teer);
				ShapedBlockRecipe(Blocks.WOODEN_BUTTON, "w", "k", 'w', Items.WATER_BUCKET, 'k', teer_knopf);
				
				//Tools normal
				MultipleShapedRecipe(teer_shovel, "t", "h", "h", 't', plank_teer, 'h', Items.STICK);
				MultipleShapedRecipe(teer_sword, "t", "t", "h", 't', plank_teer, 'h', Items.STICK);
				MultipleItemRecipe(teer_pickaxe, "ttt", " h ", " h ", 't', plank_teer, 'h', Items.STICK);
				MultipleShapedRecipe(teer_hoe, "tt", " h", " h", 't', plank_teer, 'h', Items.STICK);
				MultipleShapedRecipe(teer_axe, "pp", "ps", " s", 'p', plank_teer, 's', Items.STICK);
				
				//Tools ubergieﬂen
				MultipleShapedRecipe(teer_axe, "t", "a", 't', teer_eimer, 'a', Items.WOODEN_AXE);
				MultipleShapedRecipe(teer_shovel, "t", "a", 't', teer_eimer, 'a', Items.WOODEN_SHOVEL);
				MultipleShapedRecipe(teer_sword, "t", "a", 't', teer_eimer, 'a', Items.WOODEN_SWORD);
				MultipleShapedRecipe(teer_pickaxe, "t", "a", 't', teer_eimer, 'a', Items.WOODEN_PICKAXE);
				MultipleShapedRecipe(teer_hoe, "t", "a", 't', teer_eimer, 'a', Items.WOODEN_HOE);
				
				//Armor
				ShapedRecipe(teer_helmet, "sss", "s s", 's', sohlleder);
				ItemRecipe(teer_chestplate, "s s", "sss", "sss", 's', sohlleder);
				ItemRecipe(teer_leggings, "sss", "s s", "s s", 's', sohlleder);
				ShapedRecipe(teer_boots, "s s", "s s", 's', sohlleder);
	}
	
	public void RegisterSmelting() {
		
	  //Ofenrezepte
		ItemSmelting(horse_raw, horse_cooked, 3);
		
		//Goldlegierung
			BlockSmelting(platin_ore, platin_ingot, 5);
			ItemSmelting(mix_dust, mix_klumpen, 1);
			ItemSmelting(gold_dust, Items.GOLD_NUGGET, 1);
			ItemSmelting(platin_dust, platin_klumpen, 2);
			
	    //Eisenlegierung
			ItemSmelting(eisen_dust, eisen_klumpen, 1);
			BlockSmelting(chrom_ore, chromit, 6);
			ItemSmelting(chrom_dust, chrom_klumpen, 1);
			ItemSmelting(sili_dust, sili_klumpen, 1);
			ItemSmelting(ferro_dust, ferro_klumpen, 2);
			BlockSmelting(Blocks.STONE, 1, 1, sili_ingot, 5);
			
		//Holzlackierung
			ItemSmelting(kohle_eimer, teer_eimer, 5);
	}
	
	public static void ItemRecipe(Item out, String r1, String r2, String r3, char buchstabe, Item in) {
		GameRegistry.addRecipe(new ItemStack(out), r1, r2, r3, buchstabe, in);
	}
	
	public static void MultipleItemRecipe(Item out, Object... rezept) {
		GameRegistry.addRecipe(new ItemStack(out), rezept);
	}

	public static void BlockRecipe(Block out, Object... rezept) {
		GameRegistry.addRecipe(new ItemStack(out), rezept);
	}
	
	public static void MultipleBlockRecipe(Block out, Object... rezept) {
		GameRegistry.addRecipe(new ItemStack(out), rezept);
	}
	
	public static void MultipleShapedRecipe(Item out, Object... rezept) {
		GameRegistry.addShapedRecipe(new ItemStack(out), rezept);
	}
	
	public static void ShapedRecipe(Item out, Object... rezept) {
		GameRegistry.addShapedRecipe(new ItemStack(out), rezept);
	}
	
	public static void ShapedIntRecipe (Item out, int menge, Object... rezept) {
		GameRegistry.addRecipe(new ItemStack(out, menge), rezept);
	}
	
	public static void ShapedBlockRecipe(Block out, Object... rezept) {
		GameRegistry.addShapedRecipe(new ItemStack(out), rezept);
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
	
	public static void ShapelessBlockRecipe(Block out, Block in) {
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
