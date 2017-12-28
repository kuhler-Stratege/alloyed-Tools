package net.modding.main;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.BlockModelRenderer.EnumNeighborInfo;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.modding.blocks.eisenlegierung.BasicBlockEisen;
import net.modding.blocks.eisenlegierung.BlockChrom_Block;
import net.modding.blocks.goldlegierung.BasicBlockGold;
import net.modding.blocks.eisenlegierung.BlockChrom_Ore;
import net.modding.blocks.eisenlegierung.BlockFerro_Block;
import net.modding.blocks.eisenlegierung.BlockSilicium_Block;
import net.modding.blocks.goldlegierung.BlockMixBlock;
import net.modding.blocks.goldlegierung.BlockPlatinBlock;
import net.modding.blocks.goldlegierung.BlockPlatinOre;
import net.modding.blocks.holzlackierung.BlockTeerKnopf;
import net.modding.blocks.holzlackierung.BlockTeerPlank;
import net.modding.creativetabs.TabChromTab;
import net.modding.creativetabs.TabPlatinTab;
import net.modding.creativetabs.TabTeerTab;
import net.modding.fludis.BucketHandler;
import net.modding.fludis.holzlackierung.Teer;
import net.modding.fludis.holzlackierung.Teer.BlockTeer;
import net.modding.fludis.holzlackierung.Teer.FluidTeer;
import net.modding.items.basicTools.BasicItemAxe;
import net.modding.items.basicTools.BasicItemHoe;
import net.modding.items.basicTools.BasicItemPickaxe;
import net.modding.items.basicTools.BasicItemShovel;
import net.modding.items.basicTools.BasicItemSword;
import net.modding.items.ItemHorse_cooked;
import net.modding.items.ItemHorse_raw;
import net.modding.items.basicArmor.BasicBoots;
import net.modding.items.basicArmor.BasicChestplate;
import net.modding.items.basicArmor.BasicHelmet;
import net.modding.items.basicArmor.BasicLeggings;
import net.modding.items.eisenlegierung.BasicItemEisen;
import net.modding.items.goldlegierung.BasicItemGold;
import net.modding.items.goldlegierung.ItemBlockGold;
import net.modding.items.holzlackierung.BasicItemTeer;
import net.modding.items.holzlackierung.ItemBlockTeer;
import net.modding.items.holzlackierung.ItemKohle_eimer;
import net.modding.items.holzlackierung.ItemTeer_eimer;
import net.modding.items.holzlackierung.ItemTeer_stick;
import net.modding.items.holzlackierung.tools.ItemTeer_axe;
import net.modding.items.holzlackierung.tools.ItemTeer_hoe;
import net.modding.items.holzlackierung.tools.ItemTeer_pickaxe;
import net.modding.items.holzlackierung.tools.ItemTeer_shovel;
import net.modding.items.holzlackierung.tools.ItemTeer_sword;
import net.modding.util.McMod_info;
import net.modding.util.UpdateChecker;

public class Benennung_Registry extends modding {
	
	//sonstiges
		//Creative Tabs
		public static TabPlatinTab platinTab;
		public static TabChromTab chromTab;
		public static TabTeerTab teerTab;
		
		//Materialien
			//Tool
			public static ToolMaterial mixMaterial;
			public static ToolMaterial ferroMaterial;
			public static ToolMaterial teerMaterial;
			
			//Armor
			public static ArmorMaterial mix_armor_material;
			public static ArmorMaterial ferro_armor_material;
			public static ArmorMaterial teer_armor_material;
		
	//Item Benennungen
		public static ItemHorse_raw horse_raw;
		public static ItemHorse_cooked horse_cooked;
			
			//Goldlegierung
			public static BasicItemGold gold_dust;
			public static BasicItemGold platin_ingot;
			public static BasicItemGold platin_klumpen;
			public static BasicItemGold platin_dust;
			public static BasicItemGold mix_ingot;
			public static BasicItemGold mix_klumpen;
			public static BasicItemGold mix_dust;
			public static ItemBlockGold itemblockPlatinBlock;
			public static ItemBlockGold itemblockPlatinOre;
			
				//Tools
				public static BasicItemPickaxe mix_pickaxe;
				public static BasicItemShovel mix_shovel;
				public static BasicItemSword mix_sword;
				public static BasicItemAxe mix_axe;
				public static BasicItemHoe mix_hoe;
			
				//Armor
				public static BasicHelmet mix_helmet;
				public static BasicChestplate mix_chestplate;
				public static BasicBoots mix_boots;
				public static BasicLeggings mix_leggings;
			
			//Eisenlegierung
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
				public static BasicHelmet ferro_helmet;
				public static BasicChestplate ferro_chestplate;
				public static BasicLeggings ferro_leggings;
				public static BasicBoots ferro_boots;
			
			//Holzlackierung
			public static ItemTeer_eimer teer_eimer;
			public static ItemKohle_eimer kohle_eimer;
			public static BasicItemTeer sohlleder;
			public static ItemBlockTeer itemblockPlankTeer;
			public static ItemBlockTeer itemblockTeerKnopf;
			public static ItemTeer_stick teer_stick;
		
				//Tools
				public static ItemTeer_pickaxe teer_pickaxe;
				public static ItemTeer_shovel teer_shovel;
				public static ItemTeer_sword teer_sword;
				public static ItemTeer_axe teer_axe;
				public static ItemTeer_hoe teer_hoe;
			
				//Armor
				public static BasicHelmet teer_helmet;
				public static BasicChestplate teer_chestplate;
				public static BasicBoots teer_boots;
				public static BasicLeggings teer_leggings;	
				
			
	//Block Benennungen
		//Goldlegierung
		public static BlockPlatinOre platin_ore;
		public static BlockPlatinBlock platin_block;
		public static BlockMixBlock mix_block;
				
		//Eisenlegierung
		public static BlockChrom_Ore chrom_ore;
		public static BlockChrom_Block chrom_block;
		public static BlockSilicium_Block sili_block;
		public static BlockFerro_Block ferro_block;
		
		//Holzlackierung
		public static BlockTeerPlank plank_teer;
		public static BlockTeerKnopf teer_knopf;
		
		
	public void Benennung() {
		
		//sonstiges
			//Creative Tabs
			platinTab = new TabPlatinTab();
			chromTab = new TabChromTab();
			teerTab = new TabTeerTab();
			
			//Tool Materialien
			mixMaterial = EnumHelper.addToolMaterial("mixMaterial", 2, 271, 9.2F, 0.5F, (int) 15F);
			mixMaterial.setRepairItem(new ItemStack(mix_ingot));
			
			ferroMaterial = EnumHelper.addToolMaterial("ferroMaterial", 3, 451, 5.0F, 1.6F, (int) 6.5F);
			ferroMaterial.setRepairItem(new ItemStack(ferro_ingot));
			
			teerMaterial = EnumHelper.addToolMaterial("teerMaterial", 1, 90, 1.7F, 0.4F, (int) 4F);
			teerMaterial.setRepairItem(new ItemStack(plank_teer));
			
			//ToolMaterialen in Item.class ganz unten.
			
			//Armor Materialien
			mix_armor_material = EnumHelper.addArmorMaterial("MIX", "modding:mix", 16, new int[]{2, 4, 6, 2}, 16);
			mix_armor_material.customCraftingMaterial = mix_ingot;
			
			ferro_armor_material = EnumHelper.addArmorMaterial("FERRO", "modding:ferro", 25, new int[]{3, 4, 7, 3}, 5);
			ferro_armor_material.customCraftingMaterial = ferro_ingot;
			
			teer_armor_material = EnumHelper.addArmorMaterial("TEER", "modding:teer", 8, new int[]{2, 3, 5, 2}, 2);
			teer_armor_material.customCraftingMaterial = sohlleder;
			
		//Item Bennenungen 
			horse_raw = new ItemHorse_raw("horse_raw", 3, true);
			horse_cooked = new ItemHorse_cooked("horse_cooked", 5, false);
				
				//Goldlegierung
				platin_ingot = new BasicItemGold("platin_ingot");
				mix_ingot = new BasicItemGold("mix_ingot");
				platin_dust = new BasicItemGold("platin_dust");
				gold_dust = new BasicItemGold("gold_dust");
				mix_dust = new BasicItemGold("mix_dust");
				platin_klumpen = new BasicItemGold("platin_klumpen");
				mix_klumpen = new BasicItemGold("mix_klumpen");
			
					//Tools
					mix_sword = new BasicItemSword(mixMaterial, "mix", platinTab);
					mix_axe = new BasicItemAxe(mixMaterial, "mix", platinTab);
					mix_shovel = new BasicItemShovel(mixMaterial, "mix", platinTab);
					mix_pickaxe = new BasicItemPickaxe(mixMaterial, "mix", platinTab);
					mix_hoe = new BasicItemHoe(mixMaterial, "mix", platinTab);
				
					//Armor
					mix_helmet = new BasicHelmet(mix_armor_material, "mix", platinTab);
					mix_chestplate = new BasicChestplate(mix_armor_material, "mix", platinTab);
					mix_leggings = new BasicLeggings(mix_armor_material, "mix", platinTab);
					mix_boots = new BasicBoots(mix_armor_material, "mix", platinTab);
			
				//Eisenlegierung
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
					ferro_sword = new BasicItemSword(ferroMaterial, "ferro", chromTab);
					ferro_shovel = new BasicItemShovel(ferroMaterial, "ferro", chromTab);
					ferro_pickaxe = new BasicItemPickaxe(ferroMaterial, "ferro", chromTab);
					ferro_hoe = new BasicItemHoe(ferroMaterial, "ferro", chromTab);
					ferro_axe = new BasicItemAxe(ferroMaterial, "ferro", chromTab);
				
				//Armor
				ferro_helmet = new BasicHelmet(ferro_armor_material, "ferro", chromTab);
				ferro_chestplate = new BasicChestplate(ferro_armor_material, "ferro", chromTab);
				ferro_leggings = new BasicLeggings(ferro_armor_material, "ferro", chromTab);
				ferro_boots = new BasicBoots(ferro_armor_material, "ferro", chromTab);
				
			//Holzlackierung
			kohle_eimer = new ItemKohle_eimer();
			sohlleder = new BasicItemTeer("sohlleder");
			teer_stick = new ItemTeer_stick();
			teer_eimer = new ItemTeer_eimer();	
			register(teer_eimer);
				
					//Tools
					teer_axe = new ItemTeer_axe();
					teer_pickaxe = new ItemTeer_pickaxe();
					teer_sword = new ItemTeer_sword();
					teer_shovel = new ItemTeer_shovel();
					teer_hoe = new ItemTeer_hoe();
					
					//Armor
					teer_helmet = new BasicHelmet(teer_armor_material, "teer", teerTab);
					teer_chestplate = new BasicChestplate(teer_armor_material, "teer", teerTab);
					teer_leggings = new BasicLeggings(teer_armor_material, "teer", teerTab);
					teer_boots = new BasicBoots(teer_armor_material, "teer", teerTab);
				
			//Block Benennung
				//Goldlegierung
				platin_ore = new BlockPlatinOre();
				platin_block = new BlockPlatinBlock();
				mix_block = new BlockMixBlock();
				itemblockPlatinBlock = new ItemBlockGold(platin_block);
				itemblockPlatinOre = new ItemBlockGold(platin_ore);
				
				//Eisenlegierung
				chrom_ore = new BlockChrom_Ore();
				chrom_block = new BlockChrom_Block();
				sili_block = new BlockSilicium_Block();
				ferro_block = new BlockFerro_Block();
				
				//Holzlackierung
				plank_teer = new BlockTeerPlank();
				itemblockPlankTeer = new ItemBlockTeer(plank_teer);
				teer_knopf = new BlockTeerKnopf();
				itemblockTeerKnopf = new ItemBlockTeer(teer_knopf);
		}
		
	public void ClientOnly(FMLPreInitializationEvent preInit) {
		if (preInit.getSide() == Side.CLIENT) {
			UpdateChecker.checkForUpdates();
			modInfo = new McMod_info();
			modInfo.ModData(preInit);
		}
	}	
	
	public void Registry() {
			
		//Item Registrierungen
		  register(horse_raw, "horse_raw");
		  register(horse_cooked, "horse_cooked");
			
			//Goldlegierung
			register(gold_dust, "gold_dust");
			register(platin_ingot, "platin_ingot");
			register(platin_klumpen, "platin_klumpen");
			register(platin_dust, "platin_dust");
			register(mix_ingot, "mix_ingot");
			register(mix_klumpen, "mix_klumpen");
			register(mix_dust, "mix_dust");
			
				//Tools
				register(mix_pickaxe, "mix_pickaxe");
				register(mix_shovel, "mix_shovel");
				register(mix_sword, "mix_sword");
				register(mix_hoe, "mix_hoe");
				register(mix_axe, "mix_axe");
				
				//Armor
				register(mix_helmet);
				register(mix_chestplate);
				register(mix_leggings);
				register(mix_boots);
			
			//Eisenlegierung
			register(eisen_klumpen, "eisen_klumpen");
			register(eisen_dust, "eisen_dust");
			register(chromit, "chromit");
			register(chrom_ingot, "chrom_ingot");
			register(chrom_klumpen, "chrom_klumpen");
			register(chrom_dust, "chrom_dust");
			register(sili_ingot, "sili_ingot");
			register(sili_klumpen, "sili_klumpen");
			register(sili_dust, "sili_dust");
			register(ferro_ingot, "ferro_ingot");
			register(ferro_klumpen, "ferro_klumpen");
			register(ferro_dust, "ferro_dust");
									
				//Tools
				register(ferro_pickaxe, "ferro_pickaxe");
				register(ferro_shovel, "ferro_shovel");
				register(ferro_sword, "ferro_sword");
				register(ferro_axe, "ferro_axe");
				register(ferro_hoe, "ferro_hoe");
				
				//Armor
				register(ferro_helmet);
				register(ferro_chestplate);
				register(ferro_leggings);
				register(ferro_boots);
				
			//Holzlackierung
			register(kohle_eimer);
			register(sohlleder);
			register(teer_stick);
			
				//Tools
				register(teer_pickaxe);
				register(teer_shovel);
				register(teer_sword);
				register(teer_axe);
				register(teer_hoe);
				
				//Armor
				register(teer_helmet);
				register(teer_chestplate);
				register(teer_leggings);
				register(teer_boots);
			
		//Block Registrierungen
			//Goldlegierung
			registerBlockMitItem(platin_ore, itemblockPlatinOre.getClass());
			registerBlockMitItem(platin_block, itemblockPlatinBlock.getClass());
			registerGoldBlock(mix_block, "mix_block");
			
			//Eisenlegierung
			registerEisenBlock(chrom_ore, "chrom_ore");
			registerEisenBlock(chrom_block, "chrom_block");
			registerEisenBlock(sili_block, "sili_block");
			registerEisenBlock(ferro_block, "ferro_block");
			
			//Holzlackierung
			registerBlockMitItem(plank_teer, itemblockPlankTeer.getClass());
			registerBlockMitItem(teer_knopf, itemblockTeerKnopf.getClass());
		}
	
	public static void registerGoldBlock(BasicBlockGold block, String name) {
		GameRegistry.registerBlock(block, name);
	}
	
	public static void registerEisenBlock(BasicBlockEisen block, String name) {
		GameRegistry.registerBlock(block, name);
	}
	
	public static void register(Item item, String name) {
		GameRegistry.registerItem(item, name, modding.MODID);
		}
	
	public static void register(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5), modding.MODID);
		}
	
	public static void registerBlockMitItem(Block block, Class<? extends ItemBlock> itemBlock) {
		GameRegistry.registerBlock(block, itemBlock, block.getUnlocalizedName().substring(5));
	}
	
	public static void registerFluidBlock(Block block) {
			GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}
	
	public static void registerFluidBucket(Fluid fluid, Item fullBucket) {
			FluidContainerRegistry.registerFluidContainer(new FluidStack(fluid, FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(fullBucket), new ItemStack(Items.bucket));		
	}
	
	//Following method written by Glitchfiend, Adubbz and Forstride.
	public static Item registerItem(Item item, String name, CreativeTabs tab)
    {    
        item.setUnlocalizedName(name);
        if (tab != null)
        {
            item.setCreativeTab(tab);
        }
        GameRegistry.registerItem(item, name);
        
        // register sub types if there are any
        if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
        {
            if (item.getHasSubtypes())
            {
                List<ItemStack> subItems = new ArrayList<ItemStack>();
                item.getSubItems(item, tab, subItems);
                for (ItemStack subItem : subItems)
                {
                    String subItemName = item.getUnlocalizedName(subItem);
                    subItemName =  subItemName.substring(subItemName.indexOf(".") + 1); // remove 'item.' from the front

                    ModelBakery.addVariantName(item, modding.MODID + ":" + subItemName);
                    ModelLoader.setCustomModelResourceLocation(item, subItem.getMetadata(), new ModelResourceLocation(modding.MODID + ":" + subItemName, "inventory"));
                }
            }
            else
            {
                ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(modding.MODID + ":" + name, "inventory"));
            }
        }
        
        return item;   
    }
}
