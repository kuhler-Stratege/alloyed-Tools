package net.modding.registry;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.modding.blocks.eisenlegierung.BasicBlockEisen;
import net.modding.blocks.goldlegierung.BasicBlockGold;
import net.modding.creativetabs.TabChromTab;
import net.modding.creativetabs.TabPlatinTab;
import net.modding.creativetabs.TabTeerTab;
import net.modding.fluids.holzlackierung.MaterialTeer;
import net.modding.fluids.holzlackierung.Teer;
import net.modding.items.ItemHorse_cooked;
import net.modding.items.ItemHorse_raw;
import net.modding.main.modding;
import net.modding.util.McMod_info;
import net.modding.util.UpdateChecker;


public class Benennung_Registry extends modding {
		
		//Links
		public static Goldlegierung gold;
		public static Eisenlegierung eisen;
		public static Holzlackierung holz;
		public Teer teerRegistry;
	
		//Creative Tabs
		public static TabPlatinTab platinTab;
		public static TabChromTab chromTab;
		public static TabTeerTab teerTab;
		
		//Materialien
		public MaterialTeer materialFluidTeer;
			//Tool Materialien
			public ToolMaterial mixMaterial;
			public static ToolMaterial ferroMaterial;
			public static ToolMaterial teerMaterial;
			
			//Armor Materialien
			public static ArmorMaterial mix_armor_material;
			public static ArmorMaterial ferro_armor_material;
			public static ArmorMaterial teer_armor_material;
		
	//Item Benennungen
		public static ItemHorse_raw horse_raw;
		public static ItemHorse_cooked horse_cooked;
		
	public void Benennung() {
		
		logger.debug("erstelle Links zu Unterklassen");
		//Links
		gold = new Goldlegierung();
		eisen = new Eisenlegierung();
		holz = new Holzlackierung();
		
		logger.debug("erstelle Creative Tabs");
		//Creative Tabs
		platinTab = new TabPlatinTab();
		chromTab = new TabChromTab();	
		teerTab = new TabTeerTab();
		
		logger.debug("erstelle Tool Materialien");
		//Tool Materialien
		mixMaterial = EnumHelper.addToolMaterial("mixMaterial", 2, 271, 9.2F, 0.5F, (int) 15F);
		mixMaterial.setRepairItem(new ItemStack(gold.mix_ingot));
		
		ferroMaterial = EnumHelper.addToolMaterial("ferroMaterial", 3, 451, 5.0F, 1.6F, (int) 6.5F);
		ferroMaterial.setRepairItem(new ItemStack(eisen.ferro_ingot));
	
		teerMaterial = EnumHelper.addToolMaterial("teerMaterial", 1, 90, 1.7F, 0.4F, (int) 4F);
		teerMaterial.setRepairItem(new ItemStack(Blocks.PLANKS));
		
		//ToolMaterialen in Item.class ganz unten
		
		logger.debug("erstelle Armor Materialien");
		//Armor Material
		mix_armor_material = EnumHelper.addArmorMaterial("MIX", "modding:mix", 16, new int[]{2, 4, 6, 2}, 16, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.1F);
		mix_armor_material.customCraftingMaterial = gold.mix_ingot;
		
		ferro_armor_material = EnumHelper.addArmorMaterial("FERRO", "modding:ferro", 25, new int[]{3, 4, 7, 3}, 5, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.6F);
		ferro_armor_material.customCraftingMaterial = eisen.ferro_ingot;	
		
		teer_armor_material = EnumHelper.addArmorMaterial("TEER", "modding:teer", 8, new int[]{2, 3, 5, 2}, 2, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.1F);
		teer_armor_material.customCraftingMaterial = holz.sohlleder;
		
		logger.debug("bennene Items");
	//Item Bennenungen 
		horse_raw = new ItemHorse_raw("horse_raw", 3, true);
		horse_cooked = new ItemHorse_cooked("horse_cooked", 5, false);
		
		gold.benenneGold();
		eisen.benenneEisen();
		holz.benenneHolz();
		}
		
	public void ClientOnly(FMLPreInitializationEvent preInit) {
	 if (preInit.getSide() == Side.CLIENT) {
		registry.teerRegistry = new Teer();
		teerRegistry.registerFluid();
		UpdateChecker.checkForUpdates();
		modInfo = new McMod_info();
		modInfo.ModData(preInit);
	 	}
	}
	 
	public void Registry() {
		
		  GameRegistry.register(horse_raw);
		  GameRegistry.register(horse_cooked);
		  
		  gold.registriereGold();
		  eisen.registriereEisen();
		  holz.registriereHolz();
	}

		
	public static void registerGoldBlock(BasicBlockGold block) {
			GameRegistry.register(block);
			GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		}
		
	public static void registerEisenBlock(BasicBlockEisen block) {
			GameRegistry.register(block);
			GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		}
	
	public static void registerItemUndBlock(Block block, Item itemblock) {
		GameRegistry.register(block);
		GameRegistry.register(itemblock);
	}
	
	public static void registerFluidBlock(Block block) {
			GameRegistry.registerBlock(block);
	}
	
	public static void registerFluidBucket(Fluid fluid, Item fullBucket) {
			FluidContainerRegistry.registerFluidContainer(new FluidStack(fluid, FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(fullBucket), new ItemStack(Items.BUCKET));		
	}
	
	public static void registerRender(Block block, int meta, String datei) {
		Item item = Item.getItemFromBlock(block);
		/*Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(modding.MODID + ":" + datei, "inventory"));*/
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(MODID + ":" + datei, "inventory"));
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
