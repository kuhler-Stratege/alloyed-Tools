package net.modding.blocks.eisenlegierung;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockSilicium_Block extends BasicBlockEisen{
	
	public BlockSilicium_Block() {
		super("sili_block", Material.iron, 2, 6.5F, soundTypeMetal, 7.5F);
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return registry.sili_ingot;
	}
	
	@Override
	public int quantityDropped(Random p_149745_1_) {
		return 9;
	}
}
