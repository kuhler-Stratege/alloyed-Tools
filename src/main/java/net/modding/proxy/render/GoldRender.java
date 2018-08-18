package net.modding.proxy.render;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.modding.main.modding;
import net.modding.proxy.ClientProxy;
import net.modding.registry.Goldlegierung;

public class GoldRender extends ClientProxy {

	private static Goldlegierung gold = new Goldlegierung();
	
	public static void renderGold() {
		
		//Items
		ItemModell(gold.gold_dust);
		ItemModell(gold.platin_dust);
		ItemModell(gold.platin_klumpen);
		ItemModell(gold.platin_ingot);
		ItemModell(gold.mix_klumpen);
		ItemModell(gold.mix_dust);
		ItemModell(gold.mix_ingot);
		
			//Tools
			ItemModell(gold.mix_axe);
			ItemModell(gold.mix_sword);
			ItemModell(gold.mix_shovel);
			ItemModell(gold.mix_pickaxe);
			ItemModell(gold.mix_hoe);
			
			//Armor
			ItemModell(gold.mix_helmet);
			ItemModell(gold.mix_chestplate);
			ItemModell(gold.mix_leggings);
			ItemModell(gold.mix_boots);
		
		//Blocks
		BlockModell(gold.platin_ore);
		BlockModell(gold.platin_block);
		BlockModell(gold.mix_block);
		
	}
	
	public static void GoldItemModel (Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(modding.MODID + ":gold/" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void GoldBlockModel (Block block) {
		GoldItemModel(Item.getItemFromBlock(block));
	}
}
