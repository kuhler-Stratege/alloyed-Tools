package net.modding.registry;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.modding.blocks.holzlackierung.BlockTeerFenceGate;
import net.modding.blocks.holzlackierung.BlockTeerKnopf;
import net.modding.blocks.holzlackierung.BlockTeerPressurePlate;
import net.modding.blocks.holzlackierung.BlockTeerTreppe;
import net.modding.blocks.holzlackierung.BlockTeerZaun;
import net.modding.blocks.holzlackierung.metadata.BlockTeerPlank;
import net.modding.blocks.holzlackierung.metadata.TeerTypes;
import net.modding.blocks.holzlackierung.metadata.teerSlabs.BlockTeerSlab;
import net.modding.blocks.holzlackierung.metadata.teerSlabs.BlockTeerSlabDouble;
import net.modding.blocks.holzlackierung.metadata.teerSlabs.BlockTeerSlabHalf;
import net.modding.fluids.holzlackierung.BlockFluidTeer;
import net.modding.fluids.holzlackierung.FluidTeer;
import net.modding.fluids.holzlackierung.ItemTeer_eimer;
import net.modding.items.basicArmor.BasicBoots;
import net.modding.items.basicArmor.BasicChestplate;
import net.modding.items.basicArmor.BasicHelmet;
import net.modding.items.basicArmor.BasicLeggings;
import net.modding.items.holzlackierung.BasicItemTeer;
import net.modding.items.holzlackierung.BasicTeerItem;
import net.modding.items.holzlackierung.ItemKohle_eimer;
import net.modding.items.holzlackierung.itemblocke.ItemBlockTeer;
import net.modding.items.holzlackierung.itemblocke.ItemBlockTeerFence_gate;
import net.modding.items.holzlackierung.itemblocke.ItemBlockTeerPlank;
import net.modding.items.holzlackierung.itemblocke.ItemBlockTeerSlab;
import net.modding.items.holzlackierung.itemblocke.ItemBlockTeerTreppe;
import net.modding.items.holzlackierung.itemblocke.ItemBlockTeerZaun;
import net.modding.items.holzlackierung.tools.ItemTeer_axe;
import net.modding.items.holzlackierung.tools.ItemTeer_hoe;
import net.modding.items.holzlackierung.tools.ItemTeer_pickaxe;
import net.modding.items.holzlackierung.tools.ItemTeer_shovel;
import net.modding.items.holzlackierung.tools.ItemTeer_sword;
import net.modding.proxy.ClientProxy;

public class Holzlackierung extends Benennung_Registry {
	
	//Items
	public static ItemTeer_eimer teer_eimer;
	public static ItemKohle_eimer kohle_eimer;
	public static BasicItemTeer sohlleder;
	public static ItemBlockTeerPlank itemblockTeerPlank;
	public static ItemBlockTeer itemblockTeerKnopf;
	public static ItemBlockTeerZaun itemblockTeerZaun;
	public static ItemBlockTeerSlab itemblockTeerHalfSlab;
	public static ItemBlockTeerFence_gate itemblockTeerFenceGate;
	public static ItemBlockTeerTreppe itemBlockTeerTreppe;
	public static ItemBlockTeer itemblockTeerPressurePlate;
	public static BasicTeerItem teer_stick;
	
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

	//Blocks
	public static BlockFluidTeer blockFluidTeer;
	public static FluidTeer fluidTeer;
	public static BlockTeerKnopf teer_knopf;
	public static BlockTeerPlank plank_teer;
	public static BlockTeerZaun teer_zaun;
	public static BlockTeerFenceGate teer_fence_gate;
	public static BlockTeerTreppe teer_treppe;
	public static BlockTeerPressurePlate teer_pressure_plate;
	public static BlockTeerSlab teerHalfSlab;
	public static BlockTeerSlab teerDoubleSlab;
	
	public void benenneHolz() {
	
	//Tool Material
	teerMaterial = EnumHelper.addToolMaterial("teerMaterial", 1, 90, 1.7F, 0.4F, (int) 4F);
	teerMaterial.setRepairItem(new ItemStack(plank_teer));
	
	//Armor Material
	teer_armor_material = EnumHelper.addArmorMaterial("TEER", "modding:teer", 8, new int[]{2, 3, 5, 2}, 2, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.1F);
	teer_armor_material.customCraftingMaterial = holz.sohlleder;
		
	//Items
	kohle_eimer = new ItemKohle_eimer();
	sohlleder = new BasicItemTeer("sohlleder");
	teer_stick = new BasicTeerItem("teer_stick");
	
	
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
	
	//Blocks
	teer_knopf = new BlockTeerKnopf();
	itemblockTeerKnopf = new ItemBlockTeer(teer_knopf);
	
	plank_teer = new BlockTeerPlank();
	itemblockTeerPlank = new ItemBlockTeerPlank(plank_teer);
	
	teer_zaun = new BlockTeerZaun();
	itemblockTeerZaun = new ItemBlockTeerZaun(teer_zaun);
	
	teer_fence_gate = new BlockTeerFenceGate();
	itemblockTeerFenceGate = new ItemBlockTeerFence_gate(teer_fence_gate);
	
	teer_treppe = new BlockTeerTreppe(plank_teer.getDefaultState());
	itemBlockTeerTreppe = new ItemBlockTeerTreppe(teer_treppe);
	
	teerHalfSlab = new BlockTeerSlabHalf();
	teerDoubleSlab = new BlockTeerSlabDouble();
	itemblockTeerHalfSlab = new ItemBlockTeerSlab(teerHalfSlab ,teerHalfSlab, teerDoubleSlab);
	
	teer_pressure_plate = new BlockTeerPressurePlate();
	itemblockTeerPressurePlate = new ItemBlockTeer(teer_pressure_plate);
	
	
	}
	
	public void registriereHolz() {
	
		//Items
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
			GameRegistry.register(teer_helmet);
			GameRegistry.register(teer_chestplate);
			GameRegistry.register(teer_leggings);
			GameRegistry.register(teer_boots);
		
		//Blocks
		registerItemUndBlock(plank_teer, itemblockTeerPlank);			
		registerItemUndBlock(teer_knopf, itemblockTeerKnopf);
		registerItemUndBlock(teer_zaun, itemblockTeerZaun);
		registerItemUndBlock(teerHalfSlab, itemblockTeerHalfSlab);
		registerItemUndBlock(teer_fence_gate, itemblockTeerFenceGate);
		registerItemUndBlock(teer_treppe, itemBlockTeerTreppe);
		registerItemUndBlock(teer_pressure_plate, itemblockTeerPressurePlate);
		
		GameRegistry.register(teerDoubleSlab);
		
		if(FMLCommonHandler.instance().getSide() == Side.CLIENT) {
		
		ClientProxy.ModelLoaderModel(teerHalfSlab);
		
		for (int i = 0; i < TeerTypes.length; i++) {
			registerRender(plank_teer, i, TeerTypes.values()[i].getName() + plank_teer.getUnlocalizedName().substring(5));
			registerRender(teerHalfSlab, i, TeerTypes.values()[i].getName() + teerHalfSlab.getUnlocalizedName().substring(5));
			registerRender(teerHalfSlab, i, TeerTypes.values()[i].getName() + teerHalfSlab.getUnlocalizedName().substring(5) + "_top");
			registerRender(teerHalfSlab, i, TeerTypes.values()[i].getName() + teerHalfSlab.getUnlocalizedName().substring(5) + "_bottom");
			}
		}
	}
	
}
