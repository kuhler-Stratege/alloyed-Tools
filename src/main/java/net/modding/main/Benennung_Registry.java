package net.modding.main;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor.EnumHingePosition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.modding.blocks.eisenlegierung.BasicBlockEisen;
import net.modding.blocks.eisenlegierung.BlockChrom_Block;
import net.modding.blocks.eisenlegierung.BlockChrom_Ore;
import net.modding.blocks.eisenlegierung.BlockFerro_Block;
import net.modding.blocks.eisenlegierung.BlockSilicium_Block;
import net.modding.blocks.goldlegierung.BasicBlockGold;
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
import net.modding.items.ItemHorse_cooked;
import net.modding.items.ItemHorse_raw;
import net.modding.items.eisenlegierung.BasicItemEisen;
import net.modding.items.eisenlegierung.tools.ItemFerro_axe;
import net.modding.items.eisenlegierung.tools.ItemFerro_hoe;
import net.modding.items.eisenlegierung.tools.ItemFerro_pickaxe;
import net.modding.items.eisenlegierung.tools.ItemFerro_shovel;
import net.modding.items.eisenlegierung.tools.ItemFerro_sword;
import net.modding.items.goldlegierung.BasicItemGold;
import net.modding.items.goldlegierung.tools.ItemMix_axe;
import net.modding.items.goldlegierung.tools.ItemMix_hoe;
import net.modding.items.goldlegierung.tools.ItemMix_pickaxe;
import net.modding.items.goldlegierung.tools.ItemMix_shovel;
import net.modding.items.goldlegierung.tools.ItemMix_sword;
import net.modding.items.holzlackierung.BasicItemTeer;
import net.modding.items.holzlackierung.ItemBlockTeer;
import net.modding.items.holzlackierung.ItemBlockTeer2;
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
		
		//Creative Tabs
		public static TabPlatinTab platinTab;
		public static TabChromTab chromTab;
		public static TabTeerTab teerTab;
		
		//Materialien
			//Tool Materialien
			public static ToolMaterial mixMaterial;
			public static ToolMaterial ferroMaterial;
			public static ToolMaterial teerMaterial;
			
			//Armor Materialien
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
			
				//Tools
				public static ItemMix_pickaxe mix_pickaxe;
				public static ItemMix_shovel mix_shovel;
				public static ItemMix_sword mix_sword;
				public static ItemMix_axe mix_axe;
				public static ItemMix_hoe mix_hoe;
				
				//Armor
				public static Item mix_helmet;
				public static Item mix_chestplate;
				public static Item mix_boots;
				public static Item mix_leggings;
				
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
				public static ItemFerro_pickaxe ferro_pickaxe;
				public static ItemFerro_shovel ferro_shovel;
				public static ItemFerro_sword ferro_sword;
				public static ItemFerro_axe ferro_axe;
				public static ItemFerro_hoe ferro_hoe;
				
				//Armor
				public static Item ferro_helmet;
				public static Item ferro_chestplate;
				public static Item ferro_boots;
				public static Item ferro_leggings;
				
			//Holzlackierung
			public static ItemTeer_eimer teer_eimer;
			public static ItemKohle_eimer kohle_eimer;
			public static BasicItemTeer sohlleder;
			public static ItemBlockTeer itemblockTeer;
			public static ItemBlockTeer2 itemblockTeer2;
			public static ItemTeer_stick teer_stick;
			
				//Tools
				public static ItemTeer_pickaxe teer_pickaxe;
				public static ItemTeer_shovel teer_shovel;
				public static ItemTeer_sword teer_sword;
				public static ItemTeer_axe teer_axe;
				public static ItemTeer_hoe teer_hoe;
				
				//Armor
				public static Item teer_helmet;
				public static Item teer_chestplate;
				public static Item teer_boots;
				public static Item teer_leggings;
				
			
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
			teerMaterial.setRepairItem(new ItemStack(Blocks.PLANKS));
			
			//ToolMaterialen in Item.class ganz unten.
			
			//Armor Materialien
			mix_armor_material = EnumHelper.addArmorMaterial("MIX", "modding:mix", 16, new int[]{2, 4, 6, 2}, 16, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.1F);
			mix_armor_material.repairMaterial = new ItemStack(mix_ingot);
			
			ferro_armor_material = EnumHelper.addArmorMaterial("FERRO", "modding:ferro", 25, new int[]{3, 4, 7, 3}, 5, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.6F);
			ferro_armor_material.repairMaterial = new ItemStack(ferro_ingot);
			
			teer_armor_material = EnumHelper.addArmorMaterial("TEER", "modding:teer", 8, new int[]{2, 3, 5, 2}, 2, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.1F);
			teer_armor_material.repairMaterial = new ItemStack(sohlleder);
			
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
					mix_sword = new ItemMix_sword();
					mix_axe = new ItemMix_axe();
					mix_shovel = new ItemMix_shovel();
					mix_pickaxe = new ItemMix_pickaxe();
					mix_hoe = new ItemMix_hoe();
				
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
					ferro_sword = new ItemFerro_sword();
					ferro_shovel = new ItemFerro_shovel();
					ferro_pickaxe = new ItemFerro_pickaxe();
					ferro_hoe = new ItemFerro_hoe();
					ferro_axe = new ItemFerro_axe();
					
				//Holzlackierung
					kohle_eimer = new ItemKohle_eimer();
					sohlleder = new BasicItemTeer("sohlleder");
					teer_stick = new ItemTeer_stick();
					
					teer_eimer = new ItemTeer_eimer();	
					GameRegistry.register(teer_eimer);
				
					//Tools
					teer_axe = new ItemTeer_axe();
					teer_pickaxe = new ItemTeer_pickaxe();
					teer_sword = new ItemTeer_sword();
					teer_shovel = new ItemTeer_shovel();
					teer_hoe = new ItemTeer_hoe();
				
			//Block Benennung
				//Goldlegierung
				platin_ore = new BlockPlatinOre();
				platin_block = new BlockPlatinBlock();
				mix_block = new BlockMixBlock();
				
				//Eisenlegierung
				chrom_ore = new BlockChrom_Ore();
				chrom_block = new BlockChrom_Block();
				sili_block = new BlockSilicium_Block();
				ferro_block = new BlockFerro_Block();
				
				//Holzlackierung
				plank_teer = new BlockTeerPlank();
				itemblockTeer = new ItemBlockTeer(plank_teer);
				teer_knopf = new BlockTeerKnopf();
				itemblockTeer2 = new ItemBlockTeer2(teer_knopf);
		}
		
	public void ClientOnly(FMLPreInitializationEvent preInit) {
	 if (preInit.getSide() == Side.CLIENT) {
		UpdateChecker.checkForUpdates();
		Teer.registerFluid();
		modInfo = new McMod_info();
		modInfo.ModData(preInit);
		BucketHandler.INSTANCE.buckets.put(BlockTeer.instance, teer_eimer);
	  }
	}
	
	public void Registry() {
			
		//Item Registrierungen
		  GameRegistry.register(horse_raw);
		  GameRegistry.register(horse_cooked);
			
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
				mix_helmet = registerItem(new ItemArmor(mix_armor_material, 0, EntityEquipmentSlot.HEAD), "mix_helmet", platinTab);
				mix_chestplate = registerItem(new ItemArmor(mix_armor_material, 0, EntityEquipmentSlot.CHEST), "mix_chestplate", platinTab);
				mix_leggings = registerItem(new ItemArmor(mix_armor_material, 0, EntityEquipmentSlot.LEGS), "mix_leggings", platinTab);
				mix_boots = registerItem(new ItemArmor(mix_armor_material, 0, EntityEquipmentSlot.FEET), "mix_boots", platinTab);
			
			//Eisenlegierung
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
				ferro_helmet = registerItem(new ItemArmor(ferro_armor_material, 0, EntityEquipmentSlot.HEAD), "ferro_helmet", chromTab);
				ferro_chestplate = registerItem(new ItemArmor(ferro_armor_material, 0, EntityEquipmentSlot.CHEST), "ferro_chestplate", chromTab);
				ferro_leggings = registerItem(new ItemArmor(ferro_armor_material, 0, EntityEquipmentSlot.LEGS), "ferro_leggings", chromTab);
				ferro_boots = registerItem(new ItemArmor(ferro_armor_material, 0, EntityEquipmentSlot.FEET), "ferro_boots", chromTab);
				
			//Holzlackierung
			GameRegistry.register(kohle_eimer);
			GameRegistry.register(sohlleder);
			GameRegistry.register(teer_stick);
			
				//Tools
				GameRegistry.register(teer_pickaxe);
				GameRegistry.register(teer_shovel);
				GameRegistry.register(teer_sword);
				GameRegistry.register(teer_axe);
				GameRegistry.register(teer_hoe);
				
				//Armor
				teer_helmet = registerItem(new ItemArmor(teer_armor_material, 0, EntityEquipmentSlot.HEAD), "teer_helmet", teerTab);
				teer_chestplate = registerItem(new ItemArmor(teer_armor_material, 0, EntityEquipmentSlot.CHEST), "teer_chestplate", teerTab);
				teer_leggings = registerItem(new ItemArmor(teer_armor_material, 0, EntityEquipmentSlot.LEGS), "teer_leggings", teerTab);
				teer_boots = registerItem(new ItemArmor(teer_armor_material, 0, EntityEquipmentSlot.FEET), "teer_boots", teerTab);
			
		//Block Registrierungen
			//Goldlegierung
			registerGoldBlock(platin_ore);
			registerGoldBlock(platin_block);
			registerGoldBlock(mix_block);
			
			//Eisenlegierung
			registerEisenBlock(chrom_ore);
			registerEisenBlock(chrom_block);
			registerEisenBlock(sili_block);
			registerEisenBlock(ferro_block);
			
			//Holzlackierung
			registerTeerBlock(plank_teer, itemblockTeer);
			registerTeerBlock(teer_knopf, itemblockTeer2);

		}
		
	public static void registerGoldBlock(BasicBlockGold block) {
			GameRegistry.register(block);
			GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		}
		
	public static void registerEisenBlock(BasicBlockEisen block) {
			GameRegistry.register(block);
			GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		}
	
	public static void registerTeerBlock(Block block, ItemBlock itemBlock) {
		GameRegistry.register(block);
		GameRegistry.register(itemBlock);
	}
	
	public static void registerFluidBlock(Block block) {
			GameRegistry.registerWithItem(block);
	}
	
	
	//Following method written by Glitchfiend, Adubbz and Forstride.
	public static Item registerItem(Item item, String name, CreativeTabs tab)
    {    
        item.setUnlocalizedName(name);
        if (tab != null)
        {
            item.setCreativeTab(tab);
        }
        GameRegistry.register(item, new ResourceLocation(modding.MODID, name));
        //TANCommand.itemCount++;
        
        // register sub types if there are any
        if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
        {
            if (item.getHasSubtypes())
            {
                NonNullList<ItemStack> subItems = NonNullList.create();
                item.getSubItems(item, tab, subItems);
                for (ItemStack subItem : subItems)
                {
                    String subItemName = item.getUnlocalizedName(subItem);
                    subItemName =  subItemName.substring(subItemName.indexOf(".") + 1); // remove 'item.' from the front

                    ModelBakery.registerItemVariants(item, new ResourceLocation(modding.MODID, subItemName));
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
	
	/*public static void FluidModel()
    {
        Item fluid = Item.getItemFromBlock(teer_fluid);

        ModelBakery.registerItemVariants(fluid);
        ModelLoader.setCustomMeshDefinition(fluid, new ItemMeshDefinition()
        {
            public ModelResourceLocation getModelLocation(ItemStack stack)
            {
                return new ModelResourceLocation(teer_fluid.getRegistryName(), "fluid");
            }
        });
        ModelLoader.setCustomStateMapper(teer_fluid, new StateMapperBase()
        {
            protected ModelResourceLocation getModelResourceLocation(IBlockState state)
            {
                return new ModelResourceLocation(teer_fluid.getRegistryName(), "fluid");
            }
        });
    }*/
	
}
