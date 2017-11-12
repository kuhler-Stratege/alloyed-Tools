package net.modding.fludis;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fluids.Fluid;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class BasicFluid extends Fluid{

	public static Benennung_Registry registry = modding.registry;
	
	public BasicFluid(String fluidName, String still, String fliesend) {
		super(fluidName, new ResourceLocation(still), new ResourceLocation(fliesend));
	}

}
