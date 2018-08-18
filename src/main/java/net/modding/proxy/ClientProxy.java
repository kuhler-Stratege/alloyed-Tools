package net.modding.proxy;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.modding.main.modding;
import net.modding.proxy.render.EisenRender;
import net.modding.proxy.render.GoldRender;
import net.modding.proxy.render.HolzRender;
import net.modding.registry.Benennung_Registry;
import net.modding.registry.Eisenlegierung;
import net.modding.registry.Goldlegierung;
import net.modding.registry.Holzlackierung;

public class ClientProxy extends ServerProxy {

	public Benennung_Registry reg = modding.registry;
	private Goldlegierung g = reg.gold;
	private Eisenlegierung e = reg.eisen;
	private Holzlackierung h = reg.holz;
	
	@Override
	public void RenderTextures(){
		
		//Item Registrierungen
			ItemModel(reg.horse_raw);
			ItemModel(reg.horse_cooked);
			
			//Alles andere
			GoldRender.renderGold();
			
			EisenRender.renderEisen();
			
			HolzRender.renderHolz();

	}
	@Override
	public void renderEimer() {
		HolzRender.EimerRendering();
	}
	
	@Override
	public void renderTeer(FMLInitializationEvent init) {
		if (init.getSide() == Side.CLIENT) {
		HolzRender.FluidRendering();
		}
	}
	
	@SubscribeEvent
	public void fluidTexturen (TextureStitchEvent.Pre event) {
		registerFluidTexture(event.getMap(), reg.holz.fluidTeer.getStill());
		registerFluidTexture(event.getMap(), reg.holz.fluidTeer.getFlowing());
	}
	
	public void ItemModel (Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	public static void ItemModell (Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	public void BlockModel (Block block) {
		ItemModel(Item.getItemFromBlock(block));
	}
	
	public static void BlockModell (Block block) {
		ItemModell(Item.getItemFromBlock(block));
	}
	
	public void BlockUndMetaModel (Block block, int meta, String datei) {
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(modding.MODID + ":" + datei, "inventory"));

	}
	
	public static void ModelLoaderModel (Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(modding.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
	}
	
	@SideOnly(Side.CLIENT)
	public static TextureAtlasSprite registerFluidTexture(TextureMap map, ResourceLocation path)
	{
		TextureAtlasSprite sprite = map.getTextureExtry(path.toString());
		if(sprite==null)
		{
			map.registerSprite(path);
			sprite = map.getTextureExtry(path.toString());
		}
		return sprite;
	}
	
}