package net.modding.blocks.goldlegierung;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockMixBlock extends BasicBlockGold {
		
		public BlockMixBlock() {
		super("mix_block", Material.IRON, 2, 4.5F, SoundType.METAL, 12F);
	}//TODO: Texturen randomisieren

		@Override
		public Item getItemDropped(IBlockState state, Random rand, int fortune) {
			return registry.gold.mix_ingot;
		}
		
		@Override
		public int quantityDropped(IBlockState state, int fortune, Random random) {
			return 9;
		}
}