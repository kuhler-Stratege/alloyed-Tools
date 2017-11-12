package net.modding.crafting;

import com.google.gson.JsonObject;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.crafting.JsonContext;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.modding.blocks.eisenlegierung.BasicBlockEisen;
import net.modding.blocks.goldlegierung.BasicBlockGold;
import net.modding.main.Benennung_Registry;

public class Crafting_Smelting extends Benennung_Registry{
		
	public void RegisterCrafting() {
		
	  //Crafing Rezepte
		//Goldlegierung
			addRecipe(mix_block);
			addRecipe(platin_block);
			addRecipe(mix_ingot);
			addRecipe(platin_ingot);
			addRecipe(mix_dust);
			addRecipe(mix_dust);
			addRecipe(platin_dust);
			addRecipe(gold_dust);
			addRecipe(mix_klumpen);
			addRecipe(platin_klumpen);
			
				//Tools
				addRecipe(mix_pickaxe);
				addRecipe(mix_sword);
				addRecipe(mix_shovel);
				addRecipe(mix_axe);
				addRecipe(mix_hoe);
				
				//Armor
				addRecipe(mix_helmet);
				addRecipe(mix_chestplate);
				addRecipe(mix_leggings);
				addRecipe(mix_boots);
			
			//Eisenlegierung
			addRecipe(ferro_ingot);
			addRecipe(sili_ingot);
			addRecipe(chrom_ingot);
			addRecipe(sili_block);
			addRecipe(ferro_block);
			addRecipe(chrom_block);
			addRecipe(ferro_dust);
			addRecipe(ferro_dust);
			addRecipe(chrom_ingot);
			addRecipe(sili_dust);
			addRecipe(eisen_dust);
			addRecipe(chrom_dust);
			addRecipe(sili_klumpen);
			addRecipe(chrom_klumpen);
			
				//Tools
				addRecipe(ferro_sword);
				addRecipe(ferro_shovel);
				addRecipe(ferro_axe);
				addRecipe(ferro_hoe);
				addRecipe(ferro_pickaxe);
				
				//Armor
				addRecipe(ferro_helmet);
				addRecipe(ferro_chestplate);
				addRecipe(ferro_leggings);
				addRecipe(ferro_boots);
				
			//Holzlackierung
				addRecipe(kohle_eimer);
				addRecipe(plank_teer); 
				//Metadaten des Stacks von Planks speichern uber NBTTagInt.
				addRecipe("plank_teer ruck");
				addRecipe("teer_stick ruck");
				addRecipe(teer_stick);
				addRecipe("teer_stick ubergieﬂen");
				addRecipe(teer_knopf);
				addRecipe("teer_knopf ubergieﬂen");
				addRecipe("teer_knopf ruck");
				
				//Tools normal
				addRecipe("teer_shovel");
				addRecipe("teer_sword");
				addRecipe("teer_pickaxe");
				addRecipe(teer_hoe);
				addRecipe(teer_axe);
				
				//Tools ubergieﬂen
				addRecipe("teer_axe ubergieﬂen");
				addRecipe("teer_shovel ubergieﬂen");
				addRecipe("teer_sword ubergieﬂen");
				addRecipe("teer_pickaxe ubergieﬂen");
				addRecipe("teer_hoe ubergieﬂen");
				
				//Armor
				addRecipe(teer_helmet);
				addRecipe(teer_chestplate);
				addRecipe(teer_leggings);
				addRecipe(teer_boots);
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
			ItemSmelting(eisen_dust, Items.IRON_NUGGET, 1);
			BlockSmelting(chrom_ore, chromit, 6);
			ItemSmelting(chrom_dust, chrom_klumpen, 1);
			ItemSmelting(sili_dust, sili_klumpen, 1);
			ItemSmelting(ferro_dust, ferro_klumpen, 2);
			BlockSmelting(Blocks.STONE, 1, 1, sili_ingot, 5);
			
		//Holzlackierung
			ItemSmelting(kohle_eimer, teer_eimer, 5);
	}
	
	public static void addRecipe (String fileName) {
		CraftingHelper.register(new ResourceLocation(MODID + ":" + fileName + ".json"), new IRecipeFactory() {
			
			@Override
			public IRecipe parse(JsonContext context, JsonObject json) {
				return CraftingHelper.getRecipe(json, context);
			}
		});
	}
	
	public static void addRecipe (Item result) {
		ResourceLocation fileName = new ResourceLocation(result.getRegistryName() + ".json");
		CraftingHelper.register(fileName, new IRecipeFactory() {
			
			@Override
			public IRecipe parse(JsonContext context, JsonObject json) {
				return CraftingHelper.getRecipe(json, context);
			}
		});
	}
	
	public static void addRecipe (Block result) {
		ResourceLocation fileName = new ResourceLocation(result.getRegistryName() + ".json");
		CraftingHelper.register(fileName, new IRecipeFactory() {
			
			@Override
			public IRecipe parse(JsonContext context, JsonObject json) {
				return CraftingHelper.getRecipe(json, context);
			}
		});
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
