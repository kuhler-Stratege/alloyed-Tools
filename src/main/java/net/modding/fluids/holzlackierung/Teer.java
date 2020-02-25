package net.modding.fluids.holzlackierung;

import net.minecraft.block.state.IBlockState;
//import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelFluid;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.modding.fluids.BucketHandler;
import net.modding.main.modding;
import net.modding.registry.Benennung_Registry;
import net.modding.registry.Holzlackierung;

public class Teer {
	
	private static ModelResourceLocation location = new ModelResourceLocation(modding.MODID + ":" + "fluid_teer", "fluid");
	protected static Holzlackierung registry = Benennung_Registry.holz;
	
	public static void registerFluid() {
		MaterialTeer material;
		material = new MaterialTeer();
		registry.materialFluidTeer = material;

		BlockFluidTeer fluidblockTeer = null;
		FluidTeer teerFluid = null;
		teerFluid = new FluidTeer(fluidblockTeer); 
		FluidRegistry.registerFluid(teerFluid);
		new ModelFluid(teerFluid);
		registry.fluidTeer = teerFluid;

		fluidblockTeer = new BlockFluidTeer(teerFluid);
		registry.blockFluidTeer = fluidblockTeer;
		fluidblockTeer.preInit();
		teerFluid.setBlock(fluidblockTeer);

		ItemTeer_eimer eimer;
		eimer = new ItemTeer_eimer(fluidblockTeer);	
		GameRegistry.register(eimer);
		registry.registerFluidBucket(registry.fluidTeer, eimer);
		BucketHandler.INSTANCE.buckets.put(registry.blockFluidTeer.getDefaultState().withProperty(BlockFluidClassic.LEVEL, 0), eimer);
		registry.teer_eimer = eimer;

		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			modding.sayStaticln(FMLCommonHandler.instance().getSide().toString());
		Item teerItem = Item.getItemFromBlock(fluidblockTeer);
		ModelLoader.setCustomMeshDefinition(teerItem, new net.minecraft.client.renderer.ItemMeshDefinition() {
			
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return location;
			}
		});
		ModelLoader.setCustomStateMapper(fluidblockTeer, new StateMapperBase() {
			
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return location;
			}
		});}
	}
}
