package net.modding.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.world.BlockEvent.NeighborNotifyEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.modding.blocks.holzlackierung.BlockTeerFenceGate;
import net.modding.blocks.holzlackierung.BlockTeerTreppe;
import net.modding.blocks.holzlackierung.BlockTeerZaun;
import net.modding.fluids.holzlackierung.BlockFluidTeer;
import net.modding.main.modding;
import net.modding.registry.Benennung_Registry;
import net.modding.registry.Holzlackierung;

public class Events {

	private boolean hasShownUp = false;
	public static Minecraft getter;
	public Benennung_Registry registry = modding.registry;
	
	@SubscribeEvent
	public void onClientTick(ClientTickEvent event) {
		if (UpdateChecker.isNewVersionAvailable() && !hasShownUp) {
		getter = Minecraft.getMinecraft();
		if (getter.currentScreen == null) {
			getter.thePlayer.addChatComponentMessage(new TextComponentString(TextFormatting.GOLD + "" + TextFormatting.BOLD + I18n.translateToLocal("text.UpdateChecker.text") + modding.modInfo.UPDATE_URL + "."));
			hasShownUp = true;
			}
		}
	}
	
	@SubscribeEvent
	public void registerFluidTextures(TextureStitchEvent.Pre event) {
		TextureMap map = event.getMap();
		
		map.registerSprite(new ResourceLocation(modding.MODID, "blocks/" + "teer" + "_still"));
		map.registerSprite(new ResourceLocation(modding.MODID, "blocks/" + "teer" + "_flow"));
	}
	
	public void addEffekts(World world, BlockPos pos, IBlockState state) {
		getter = Minecraft.getMinecraft();
		if (getter.currentScreen == null) {
		
		}
	}
	
	@SubscribeEvent
	public void onEntityUpdate (LivingUpdateEvent event) {
		
	}
	
	@SubscribeEvent
	public void NeighborChanged (NeighborNotifyEvent event) {
		Holzlackierung holz = registry.holz;
		BlockFluidTeer blockTeer = holz.blockFluidTeer;
		World world = event.getWorld();
		BlockPos pos = event.getPos();
		if (event.getState().getBlock() == Blocks.WATER || event.getState().getBlock() == Blocks.FLOWING_WATER) {
			blockTeer.ersetzen(world, pos, holz.plank_teer, Blocks.PLANKS);
			blockTeer.ersetzen(world, pos, holz.teerHalfSlab, Blocks.WOODEN_SLAB);
			blockTeer.ersetzen(world, pos, holz.teerDoubleSlab, Blocks.DOUBLE_WOODEN_SLAB);
			blockTeer.ersetzen(world, pos, holz.teer_knopf, Blocks.WOODEN_BUTTON);
			blockTeer.ersetzen(world, pos, holz.teer_pressure_plate, Blocks.WOODEN_PRESSURE_PLATE);
			
			if (BlockTeerZaun.getZaunArray().length > 0 && BlockTeerFenceGate.getFenceGateArray().length > 0 && BlockTeerTreppe.getTreppenArray().length > 0) {
				try {
					for (int i=0; i<BlockTeerZaun.getZaunArray().length; i++) {
						blockTeer.ersetzen(world, pos, holz.teer_zaun, BlockTeerZaun.getZaunArray()[i]);
					}
					for (int i=0; i<BlockTeerFenceGate.getFenceGateArray().length; i++) {
						blockTeer.ersetzen(world, pos, holz.teer_fence_gate, BlockTeerFenceGate.getFenceGateArray()[i]);
					}
					for (int i=0; i<BlockTeerTreppe.getTreppenArray().length; i++) {
						blockTeer.ersetzen(world, pos, holz.teer_treppe, BlockTeerTreppe.getTreppenArray()[i]);
						}
					}
			catch (NullPointerException e) {
				e.printStackTrace();
				}
			} 
		}
	}
}
