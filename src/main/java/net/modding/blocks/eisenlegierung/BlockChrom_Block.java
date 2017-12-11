package net.modding.blocks.eisenlegierung;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockChrom_Block extends BasicBlockEisen{

	public BlockChrom_Block() {
		super("chrom_block", Material.iron, 2, 8.5F, soundTypeMetal, 8F);
		
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return registry.chrom_ingot;
	}
	
	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return 9;
	}
}
