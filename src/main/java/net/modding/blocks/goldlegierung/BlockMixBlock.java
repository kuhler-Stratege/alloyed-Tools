package net.modding.blocks.goldlegierung;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.modding.main.modding;

public class BlockMixBlock extends BasicBlockGold {

		
		public BlockMixBlock() {
		super("mix_block", Material.IRON, 2, 6F, SoundType.METAL);
	}

		@Override
		public Item getItemDropped(IBlockState state, Random rand, int fortune) {
			return registry.mix_ingot;
		}
		
		@Override
		public int quantityDropped(IBlockState state, int fortune, Random random) {
			return 9;
		}
}