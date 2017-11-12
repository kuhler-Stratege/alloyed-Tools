package net.modding.proxy;

import net.modding.fludis.holzlackierung.Teer.BlockTeer;
import net.modding.items.holzlackierung.ItemBlockTeer;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public class ClientProxy extends ServerProxy {

	public static Benennung_Registry reg = modding.registry;
	
	@Override
	public void RegisterClientStuff(){
		//Item Registrierungen
			//Goldlegierung
			ItemModel(reg.gold_dust);
			ItemModel(reg.platin_dust);
			ItemModel(reg.platin_klumpen);
			ItemModel(reg.platin_ingot);
			ItemModel(reg.horse_raw);
			ItemModel(reg.horse_cooked);
			ItemModel(reg.mix_klumpen);
			ItemModel(reg.mix_dust);
			ItemModel(reg.mix_ingot);
			
				//Tools
				ItemModel(reg.mix_axe);
				ItemModel(reg.mix_sword);
				ItemModel(reg.mix_shovel);
				ItemModel(reg.mix_pickaxe);
				ItemModel(reg.mix_hoe);
				
				//Armor
				ItemModel(reg.mix_helmet);
				ItemModel(reg.mix_chestplate);
				ItemModel(reg.mix_leggings);
				ItemModel(reg.mix_boots);
			
			//Eisenlegierung
			ItemModel(reg.eisen_klumpen);
			ItemModel(reg.eisen_dust);
			ItemModel(reg.chromit);
			ItemModel(reg.chrom_ingot);
			ItemModel(reg.chrom_klumpen);
			ItemModel(reg.chrom_dust);
			ItemModel(reg.sili_ingot);
			ItemModel(reg.sili_klumpen);
			ItemModel(reg.sili_dust);
			ItemModel(reg.ferro_ingot);
			ItemModel(reg.ferro_klumpen);
			ItemModel(reg.ferro_dust);
			
				//Tools
				ItemModel(reg.ferro_pickaxe);
				ItemModel(reg.ferro_shovel);
				ItemModel(reg.ferro_sword);
				ItemModel(reg.ferro_axe);
				ItemModel(reg.ferro_hoe);
				
				//Armor
				ItemModel(reg.ferro_helmet);
				ItemModel(reg.ferro_chestplate);
				ItemModel(reg.ferro_leggings);
				ItemModel(reg.ferro_boots);
				
			//Holzlackierung
			ItemModel(reg.kohle_eimer);
			ItemModel(reg.itemblockTeer);
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
			BlockModel(reg.platin_ore);
			BlockModel(reg.platin_block);
			BlockModel(reg.mix_block);
			
			//Eisenlegierung
			BlockModel(reg.chrom_ore);
			BlockModel(reg.chrom_block);
			BlockModel(reg.sili_block);
			BlockModel(reg.ferro_block);
			
			//Holzlackierung	
			BlockModel(reg.teer_knopf);
				//Teer Planks
				BlockModel(reg.plank_teer, 0);
				BlockModel(reg.plank_teer, 1);
				BlockModel(reg.plank_teer, 2);
				BlockModel(reg.plank_teer, 3);
				BlockModel(reg.plank_teer, 4);
				BlockModel(reg.plank_teer, 5);
				BlockModel(reg.plank_teer, 6);
			
	}
	@Override
	public void registerEimer() {
		ItemModel(reg.teer_eimer);
	}
	
	@Override
	public void registerTeer(FMLInitializationEvent init) {
		if (init.getSide() == Side.CLIENT) {
		BlockModel(BlockTeer.instance);
		}
	}
	public static void ItemModel (Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	public static void BlockModel (Block block) {
		ItemModel(Item.getItemFromBlock(block));
	}
	
	public static void ItemModel (Item item, int meta) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	public static void BlockModel (Block block, int meta) {
		ItemModel(Item.getItemFromBlock(block), meta);
	}
}