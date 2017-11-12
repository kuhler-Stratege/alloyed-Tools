package net.modding.blocks.goldlegierung;

import java.util.Random;

import javax.annotation.Nullable;

import net.modding.main.modding;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockPlatinOre extends BasicBlockGold {

	public BlockPlatinOre() {
		super("platin_ore", Material.rock, 1, 4.5F, soundTypeStone);
	}
	
	@Override
	public Item getItemDropped(int i, Random rand, int j) {
		if(rand.nextBoolean()) {
			return Item.getItemFromBlock(this);
		}
		else {
			return null;
		}
	}
}
