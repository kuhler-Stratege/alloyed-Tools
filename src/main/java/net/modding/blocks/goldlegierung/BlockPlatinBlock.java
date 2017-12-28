package net.modding.blocks.goldlegierung;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.modding.main.modding;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class BlockPlatinBlock extends BasicBlockGold {
	
	public BlockPlatinBlock() {
		super("platin_block", Material.iron, 2, 5.5F, soundTypeMetal, 10F);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return registry.platin_ingot;
	}
	
	@Override
	public int quantityDropped(Random p_149745_1_) {
		return 9;
	}
}
