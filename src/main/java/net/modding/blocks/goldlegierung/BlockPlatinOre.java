package net.modding.blocks.goldlegierung;

import java.util.Random;

import javax.annotation.Nullable;

import net.modding.main.modding;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockPlatinOre extends BasicBlockGold {

	public BlockPlatinOre() {
		super("platin_ore", Material.ROCK, 1, 4.5F, SoundType.STONE);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if(rand.nextBoolean()) {
			return Item.getItemFromBlock(this);
		}
		else {
			return null;
		}
	}	
}
