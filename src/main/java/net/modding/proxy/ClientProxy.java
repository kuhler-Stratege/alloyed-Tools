package net.modding.proxy;

import net.modding.fludis.holzlackierung.Teer.BlockTeer;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public class ClientProxy extends ServerProxy {

	
	public static Benennung_Registry reg = new Benennung_Registry();
	
	@Override
	public void RegisterClientStuff(){
	//Item Registrierungen
		//Goldlegierung
		ItemModel(reg.gold_dust, "gold_dust");
		ItemModel(reg.platin_dust, "platin_dust");
		ItemModel(reg.platin_klumpen, "platin_klumpen");
		ItemModel(reg.platin_ingot, "platin_ingot");
		ItemModel(reg.horse_raw, "horse_raw");
		ItemModel(reg.horse_cooked, "horse_cooked");
		ItemModel(reg.mix_klumpen, "mix_klumpen");
		ItemModel(reg.mix_dust, "mix_dust");
		ItemModel(reg.mix_ingot, "mix_ingot");
		
			//Tools
			ItemModel(reg.mix_axe, "mix_axe");
			ItemModel(reg.mix_sword, "mix_sword");
			ItemModel(reg.mix_shovel, "mix_shovel");
			ItemModel(reg.mix_pickaxe, "mix_pickaxe");
			ItemModel(reg.mix_hoe, "mix_hoe");
			
			//Armor
			ItemModel(reg.mix_helmet, "mix_helmet");
			ItemModel(reg.mix_chestplate, "mix_chestplate");
			ItemModel(reg.mix_leggings, "mix_leggins");
			ItemModel(reg.mix_boots, "mix_boots");
		
		//Eisenlegierung
		ItemModel(reg.eisen_klumpen, "eisen_klumpen");
		ItemModel(reg.eisen_dust, "eisen_dust");
		ItemModel(reg.chromit, "chromit");
		ItemModel(reg.chrom_ingot, "chrom_ingot");
		ItemModel(reg.chrom_klumpen, "chrom_klumpen");
		ItemModel(reg.chrom_dust, "chrom_dust");
		ItemModel(reg.sili_ingot, "sili_ingot");
		ItemModel(reg.sili_klumpen, "sili_klumpen");
		ItemModel(reg.sili_dust, "sili_dust");
		ItemModel(reg.ferro_ingot, "ferro_ingot");
		ItemModel(reg.ferro_klumpen, "ferro_klumpen");
		ItemModel(reg.ferro_dust, "ferro_dust");
		
			//Tools
			ItemModel(reg.ferro_pickaxe, "ferro_pickaxe");
			ItemModel(reg.ferro_shovel, "ferro_shovel");
			ItemModel(reg.ferro_sword, "ferro_sword");
			ItemModel(reg.ferro_axe, "ferro_axe");
			ItemModel(reg.ferro_hoe, "ferro_hoe");
			
			//Armor
			ItemModel(reg.ferro_helmet, "ferro_helmet");
			ItemModel(reg.ferro_chestplate, "ferro_chestplate");
			ItemModel(reg.ferro_leggings, "ferro_leggins");
			ItemModel(reg.ferro_boots, "ferro_boots");
			
		//Holzlackierung
		ItemModel(reg.kohle_eimer);
		ItemModel(reg.itemblockPlankTeer);
		ItemModel(reg.itemblockTeerKnopf);
		ItemModel(reg.sohlleder);
		ItemModel(reg.teer_stick);
			
			//Tools
			ItemModel(reg.teer_pickaxe);
			ItemModel(reg.teer_shovel);
			ItemModel(reg.teer_sword);
			ItemModel(reg.teer_axe);
			ItemModel(reg.teer_hoe);
			
			//Armor
			ItemModel(reg.teer_helmet);
			ItemModel(reg.teer_chestplate);
			ItemModel(reg.teer_leggings);
			ItemModel(reg.teer_boots);
		
	//Block Registrierungen
		//Goldlegierung
		BlockModel(reg.platin_ore, "platin_ore");
		BlockModel(reg.platin_block, "platin_block");
		BlockModel(reg.mix_block, "mix_block");
		
		//Eisenlegierung
		BlockModel(reg.chrom_ore, "chrom_ore");
		BlockModel(reg.chrom_block, "chrom_block");
		BlockModel(reg.sili_block, "sili_block");
		BlockModel(reg.ferro_block, "ferro_block");
								
		//Holzlackierung
		BlockModel(reg.plank_teer);
		BlockModel(reg.teer_knopf);			
	}	
	@Override
	public void RegisterEimer() {
		ItemModel(reg.teer_eimer);
	}
	
	@Override
	public void RegisterTeer(FMLInitializationEvent init) {
		if (init.getSide() == Side.CLIENT) {
			BlockModel(BlockTeer.instance);
		}
	}
	
	public static void ItemModel (Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(modding.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void ItemModel (Item item, String name) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(modding.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void BlockModel (Block block, String name) {
		ItemModel(Item.getItemFromBlock(block));
	}
	
	public static void BlockModel (Block block) {
		ItemModel(Item.getItemFromBlock(block));
	}
}