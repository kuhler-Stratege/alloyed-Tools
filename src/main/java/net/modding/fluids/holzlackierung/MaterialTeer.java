package net.modding.fluids.holzlackierung;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLiquid;

public class MaterialTeer extends MaterialLiquid {

	public MaterialTeer() {
		super(MapColor.OBSIDIAN);
		setBurning();
	}
	
	@Override
	public boolean blocksLight() {
		return true;
	}
	@Override
	public boolean getCanBurn() {
		return true;
	}
	@Override
	public boolean isLiquid() {
		return true;
	}
	@Override
	public boolean isOpaque() {
		return true;
	}
	
	@Override
	public boolean isSolid() {
		return false;
	}
}
