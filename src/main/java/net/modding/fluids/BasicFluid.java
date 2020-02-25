package net.modding.fluids;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.modding.main.modding;
import net.modding.registry.Benennung_Registry;

public class BasicFluid extends Fluid{

	public static Benennung_Registry registry = modding.registry;
	public String fluidName;
	
	public BasicFluid(String fluidName, BlockFluidBase fluidBlock, SoundEvent fillSound, SoundEvent emptySound, int density, boolean gas, EnumRarity seltenheit, int temperatur, int viskusitaet) {
		super(fluidName, new ResourceLocation(modding.MODID + ":" + "blocks/" + fluidName + "_still"), new ResourceLocation(modding.MODID + ":" + "blocks/" + fluidName + "_flow"));
		setFillSound(fillSound);
		setEmptySound(emptySound);
		setDensity(density);
		setGaseous(gas);
		setRarity(seltenheit);
		setTemperature(temperatur);
		setViscosity(viskusitaet);
		setBlock(fluidBlock);
		this.fluidName = fluidName;
	}
	
	public String getFluidName() {
		return fluidName;
	}

}
