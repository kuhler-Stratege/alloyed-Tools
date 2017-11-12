package net.modding.blocks.eisenlegierung;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockChrom_Block extends BasicBlockEisen{

	public BlockChrom_Block() {
		super("chrom_block", Material.iron, 2, 8.5F, soundTypeMetal);
		
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return registry.chrom_ingot;
	}
	
	@Override
	public int quantityDropped(Random p_149745_1_) {
		return 9;
	}
}
