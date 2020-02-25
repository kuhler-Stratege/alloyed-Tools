package net.modding.fluids.holzlackierung;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraftforge.fluids.BlockFluidBase;
import net.modding.fluids.BasicFluid;

public class FluidTeer extends BasicFluid{

	public FluidTeer(BlockFluidBase fluidBlock) {
		super("fluid_teer", fluidBlock, SoundEvents.ITEM_BUCKET_FILL_LAVA, SoundEvents.ITEM_BUCKET_EMPTY_LAVA, 4500, false, EnumRarity.RARE, 500, 2859);
	}


}
