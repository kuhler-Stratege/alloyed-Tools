package net.modding.registry;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.modding.blocks.eisenlegierung.BlockChrom_Block;
import net.modding.blocks.eisenlegierung.BlockChrom_Ore;
import net.modding.blocks.eisenlegierung.BlockFerro_Block;
import net.modding.blocks.eisenlegierung.BlockSilicium_Block;
import net.modding.items.basicArmor.BasicBoots;
import net.modding.items.basicArmor.BasicChestplate;
import net.modding.items.basicArmor.BasicHelmet;
import net.modding.items.basicArmor.BasicLeggings;
import net.modding.items.basictools.BasicItemAxe;
import net.modding.items.basictools.BasicItemHoe;
import net.modding.items.basictools.BasicItemPickaxe;
import net.modding.items.basictools.BasicItemShovel;
import net.modding.items.basictools.BasicItemSword;
import net.modding.items.eisenlegierung.BasicItemEisen;

public class Eisenlegierung extends Benennung_Registry {

	//Items
	public static BasicItemEisen eisen_klumpen;
	public static BasicItemEisen eisen_dust;
	public static BasicItemEisen chromit;
	public static BasicItemEisen chrom_ingot;
	public static BasicItemEisen chrom_klumpen;
	public static BasicItemEisen chrom_dust;
	public static BasicItemEisen sili_ingot;
	public static BasicItemEisen sili_klumpen;
	public static BasicItemEisen sili_dust;
	public static BasicItemEisen ferro_ingot;  
	public static BasicItemEisen ferro_klumpen;
	public static BasicItemEisen ferro_dust;
	
		//Tools
		public static BasicItemPickaxe ferro_pickaxe;
		public static BasicItemShovel ferro_shovel;
		public static BasicItemSword ferro_sword;
		public static BasicItemAxe ferro_axe;
		public static BasicItemHoe ferro_hoe;
		
		//Armor
		public static Item ferro_helmet;
		public static Item ferro_chestplate;
		public static Item ferro_boots;
		public static Item ferro_leggings;
	
	//Blocks
	public static BlockChrom_Ore chrom_ore;
	public static BlockChrom_Block chrom_block;
	public static BlockSilicium_Block sili_block;
	public static BlockFerro_Block ferro_block;	
		
	public void benenneEisen() {
		
		//ToolMaterial
		ferroMaterial = EnumHelper.addToolMaterial("ferroMaterial", 3, 451, 5.0F, 1.6F, (int) 6.5F);
		ferroMaterial.setRepairItem(new ItemStack(ferro_ingot));
		
		//Armor Material
		ferro_armor_material = EnumHelper.addArmorMaterial("FERRO", "modding:ferro", 25, new int[]{3, 4, 7, 3}, 5, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.6F);
		ferro_armor_material.customCraftingMaterial = eisen.ferro_ingot;
		
		//Items
		eisen_dust = new BasicItemEisen("eisen_dust");
		eisen_klumpen = new BasicItemEisen("eisen_klumpen");
		chrom_ingot = new BasicItemEisen("chrom_ingot");
		chrom_dust = new BasicItemEisen("chrom_dust");
		chrom_klumpen = new BasicItemEisen("chrom_klumpen");
		chromit = new BasicItemEisen("chromit");
		sili_ingot = new BasicItemEisen("sili_ingot");
		sili_klumpen = new BasicItemEisen("sili_klumpen");
		sili_dust = new BasicItemEisen("sili_dust");
		ferro_dust = new BasicItemEisen("ferro_dust");
		ferro_klumpen = new BasicItemEisen("ferro_klumpen");
		ferro_ingot = new BasicItemEisen("ferro_ingot");
		
			//Tools
			ferro_sword = new BasicItemSword(ferroMaterial, "ferro", chromTab, 0.15F);
			ferro_axe = new BasicItemAxe(ferroMaterial, "ferro", chromTab, 0.6F);
			ferro_shovel = new BasicItemShovel(ferroMaterial, "ferro", chromTab);
			ferro_pickaxe = new BasicItemPickaxe(ferroMaterial, "ferro", chromTab);
			ferro_hoe = new BasicItemHoe(ferroMaterial, "ferro", chromTab);
			
			//Armor
			ferro_helmet = new BasicHelmet(ferro_armor_material, "ferro", chromTab);
			ferro_chestplate = new BasicChestplate(ferro_armor_material, "ferro", chromTab);
			ferro_leggings = new BasicLeggings(ferro_armor_material, "ferro", chromTab);
			ferro_boots = new BasicBoots(ferro_armor_material, "ferro", chromTab);
			
		//Blocks
		chrom_ore = new BlockChrom_Ore();
		chrom_block = new BlockChrom_Block();
		sili_block = new BlockSilicium_Block();
		ferro_block = new BlockFerro_Block();	
	}
	
	public void registriereEisen() {
		
		//Items
		GameRegistry.register(eisen_klumpen);
		GameRegistry.register(eisen_dust);
		GameRegistry.register(chromit);
		GameRegistry.register(chrom_ingot);
		GameRegistry.register(chrom_klumpen);
		GameRegistry.register(chrom_dust);
		GameRegistry.register(sili_ingot);
		GameRegistry.register(sili_klumpen);
		GameRegistry.register(sili_dust);
		GameRegistry.register(ferro_ingot);
		GameRegistry.register(ferro_klumpen);
		GameRegistry.register(ferro_dust);
								
			//Tools
			GameRegistry.register(ferro_pickaxe);
			GameRegistry.register(ferro_shovel);
			GameRegistry.register(ferro_sword);
			GameRegistry.register(ferro_axe);
			GameRegistry.register(ferro_hoe);
			
			//Armor
			GameRegistry.register(ferro_helmet);
			GameRegistry.register(ferro_chestplate);
			GameRegistry.register(ferro_leggings);
			GameRegistry.register(ferro_boots);
			
			
		//Blocks
		registerEisenBlock(chrom_ore);
		registerEisenBlock(chrom_block);
		registerEisenBlock(sili_block);
		registerEisenBlock(ferro_block);
	}
	
}
