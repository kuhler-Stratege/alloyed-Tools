package net.modding.proxy.render;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.modding.blocks.holzlackierung.metadata.BlockTeerPlank;
import net.modding.blocks.holzlackierung.metadata.teerSlabs.BlockTeerSlab;
import net.modding.main.modding;
import net.modding.proxy.ClientProxy;
import net.modding.registry.Holzlackierung;

public class HolzRender extends ClientProxy {

	private static Holzlackierung holz = modding.registry.holz;

	public static void renderHolz() {
		
		//Items
		ItemModell(holz.kohle_eimer);
		ItemModell(holz.sohlleder);
		ItemModell(holz.teer_stick);
			
			//Tools
			ItemModell(holz.teer_pickaxe);
			ItemModell(holz.teer_shovel);
			ItemModell(holz.teer_sword);
			ItemModell(holz.teer_axe);
			ItemModell(holz.teer_hoe);
			
			//Armor
			ItemModell(holz.teer_helmet);
			ItemModell(holz.teer_chestplate);
			ItemModell(holz.teer_leggings);
			ItemModell(holz.teer_boots);
		
		//Blocks	
		BlockModell(holz.teer_knopf);
		BlockModell(holz.teer_zaun);
		BlockModell(holz.teer_fence_gate);
		BlockModell(holz.teer_treppe);
		BlockModell(holz.teer_pressure_plate);
		ItemModell(holz.itemblockTeerHalfSlab);
		BlockTeerPlank.registerTeerPlanks();
		BlockTeerSlab.registerTeerSlabs();
	}
	
	public static void EimerRendering() {
		ItemModell(holz.teer_eimer);
	}
	
	public static void FluidRendering() {
		BlockModell(holz.blockFluidTeer);
	}
	
	@SubscribeEvent
	public void registerFluidTextures(TextureStitchEvent.Pre event) {
		TextureMap map = event.getMap();
		
		map.registerSprite(new ResourceLocation(modding.MODID, "blocks/" + "teer" + "_still"));
		map.registerSprite(new ResourceLocation(modding.MODID, "blocks/" + "teer" + "_flow"));
	}
	
	public static void HolzItemModel (Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(modding.MODID + ":holz/" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void HolzBlockModel (Block block) {
		HolzItemModel(Item.getItemFromBlock(block));
	}
}
