package net.modding.registry;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.modding.blocks.goldlegierung.BlockMixBlock;
import net.modding.blocks.goldlegierung.BlockPlatinBlock;
import net.modding.blocks.goldlegierung.BlockPlatinOre;
import net.modding.items.basicArmor.BasicBoots;
import net.modding.items.basicArmor.BasicChestplate;
import net.modding.items.basicArmor.BasicHelmet;
import net.modding.items.basicArmor.BasicLeggings;
import net.modding.items.basictools.BasicItemAxe;
import net.modding.items.basictools.BasicItemHoe;
import net.modding.items.basictools.BasicItemPickaxe;
import net.modding.items.basictools.BasicItemShovel;
import net.modding.items.basictools.BasicItemSword;
import net.modding.items.goldlegierung.BasicItemGold;
import net.modding.main.modding;

public class Goldlegierung extends Benennung_Registry{

	private boolean aufgerufen;
	
	//Items
	public static BasicItemGold gold_dust;
	public static BasicItemGold platin_ingot;
	public static BasicItemGold platin_klumpen;
	public static BasicItemGold platin_dust;
	public static BasicItemGold mix_ingot;
	public static BasicItemGold mix_klumpen;
	public static BasicItemGold mix_dust;
	
		//Tools
		public static BasicItemPickaxe mix_pickaxe;
		public static BasicItemShovel mix_shovel;
		public static BasicItemSword mix_sword;
		public static BasicItemAxe mix_axe;
		public static BasicItemHoe mix_hoe;
		
		//Armor
		public static Item mix_helmet;
		public static Item mix_chestplate;
		public static Item mix_boots;
		public static Item mix_leggings;
	
	//Blocks
	public static BlockPlatinOre platin_ore;
	public static BlockPlatinBlock platin_block;
	public static BlockMixBlock mix_block;
	
	
	public void aufgerufenGold() {
		aufgerufen = false;
	}
	
	public void benenneGold() {
		
		logger.debug("bennene Gold Sachen");
		
		//Tool Material
		mixMaterial = EnumHelper.addToolMaterial("mixMaterial", 2, 271, 9.2F, 0.5F, (int) 15F);
		mixMaterial.setRepairItem(new ItemStack(mix_ingot));
		
		//Armor Material
		mix_armor_material = EnumHelper.addArmorMaterial("MIX", "modding:mix", 16, new int[]{2, 4, 6, 2}, 16, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.1F);
		mix_armor_material.customCraftingMaterial = gold.mix_ingot;
		
		//Items
		platin_ingot = new BasicItemGold("platin_ingot");
		mix_ingot = new BasicItemGold("mix_ingot");
		platin_dust = new BasicItemGold("platin_dust");
		gold_dust = new BasicItemGold("gold_dust");
		mix_dust = new BasicItemGold("mix_dust");
		platin_klumpen = new BasicItemGold("platin_klumpen");
		mix_klumpen = new BasicItemGold("mix_klumpen");
		
			//Tools
			mix_sword = new BasicItemSword(mixMaterial, "mix", platinTab, 0.1F);
			mix_axe = new BasicItemAxe(mixMaterial, "mix", platinTab, 0.8F);
			mix_shovel = new BasicItemShovel(mixMaterial, "mix", platinTab);
			mix_pickaxe = new BasicItemPickaxe(mixMaterial, "mix", platinTab);
			mix_hoe = new BasicItemHoe(mixMaterial, "mix", platinTab);
			
			//Armor
			mix_helmet = new BasicHelmet(mix_armor_material, "mix", platinTab);
			mix_chestplate = new BasicChestplate(mix_armor_material, "mix", platinTab);
			mix_leggings = new BasicLeggings(mix_armor_material, "mix", platinTab);
			mix_boots = new BasicBoots(mix_armor_material, "mix", platinTab);
		
		logger.debug("benenne Goldblocke.");
		//Blocks
		platin_ore = new BlockPlatinOre();
		platin_block = new BlockPlatinBlock();
		mix_block = new BlockMixBlock();
	}
	
	public void registriereGold() {
		
		//Goldlegierung
		GameRegistry.register(gold_dust);
		GameRegistry.register(platin_ingot);
		GameRegistry.register(platin_klumpen);
		GameRegistry.register(platin_dust);
		GameRegistry.register(mix_ingot);
		GameRegistry.register(mix_klumpen);
		GameRegistry.register(mix_dust);
		
			//Tools
			GameRegistry.register(mix_pickaxe);
			GameRegistry.register(mix_shovel);
			GameRegistry.register(mix_sword);
			GameRegistry.register(mix_hoe);
			GameRegistry.register(mix_axe);
			
			//Armor
			GameRegistry.register(mix_helmet);
			GameRegistry.register(mix_chestplate);
			GameRegistry.register(mix_leggings);
			GameRegistry.register(mix_boots);
		
		modding.instance.logger.debug("registriere Gold Blocke");
			
		//Blocks
		registerGoldBlock(platin_ore);
		registerGoldBlock(platin_block);
		registerGoldBlock(mix_block);
	}
	
}
