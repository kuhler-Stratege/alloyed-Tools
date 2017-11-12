package net.modding.blocks.eisenlegierung;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockFerro_Block extends BasicBlockEisen{
	
	public BlockFerro_Block() {
		super("ferro_block", Material.iron, 2, 3.5F, soundTypeMetal);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return registry.ferro_ingot;
	}
	
	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return 9;
	}

}
