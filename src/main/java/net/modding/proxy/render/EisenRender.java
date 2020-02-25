package net.modding.proxy.render;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.modding.main.modding;
import net.modding.proxy.ClientProxy;
import net.modding.registry.Eisenlegierung;

public class EisenRender extends ClientProxy {
	
	private static Eisenlegierung eisen = modding.registry.eisen;

	public static void renderEisen() {
		
		//Eisenlegierung
			ItemModell(eisen.eisen_klumpen);
			ItemModell(eisen.eisen_dust);
			ItemModell(eisen.chromit);
			ItemModell(eisen.chrom_ingot);
			ItemModell(eisen.chrom_klumpen);
			ItemModell(eisen.chrom_dust);
			ItemModell(eisen.sili_ingot);
			ItemModell(eisen.sili_klumpen);
			ItemModell(eisen.sili_dust);
			ItemModell(eisen.ferro_ingot);
			ItemModell(eisen.ferro_klumpen);
			ItemModell(eisen.ferro_dust);
		
			//Tools
			ItemModell(eisen.ferro_pickaxe);
			ItemModell(eisen.ferro_shovel);
			ItemModell(eisen.ferro_sword);
			ItemModell(eisen.ferro_axe);
			ItemModell(eisen.ferro_hoe);
			
			//Armor
			ItemModell(eisen.ferro_helmet);
			ItemModell(eisen.ferro_chestplate);
			ItemModell(eisen.ferro_leggings);
			ItemModell(eisen.ferro_boots);
			
		//Blocks
		BlockModell(eisen.chrom_ore);
		BlockModell(eisen.chrom_block);
		BlockModell(eisen.sili_block);
		BlockModell(eisen.ferro_block);
	}
	
	public static void HolzItemModel (Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(modding.MODID + ":eisen/" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void HolzBlockModel (Block block) {
		HolzItemModel(Item.getItemFromBlock(block));
	}
}
