package net.modding.blocks.eisenlegierung;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockSilicium_Block extends BasicBlockEisen{
	
	public BlockSilicium_Block() {
		super("sili_block", Material.IRON, 2, 6F, SoundType.METAL, 7.5F);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return registry.eisen.sili_ingot;
	}
	
	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return 9;
	}
}
