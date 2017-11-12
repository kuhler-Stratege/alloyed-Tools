package net.modding.blocks.goldlegierung;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.modding.main.modding;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;

public class BlockPlatinBlock extends BasicBlockGold {
	
	public BlockPlatinBlock() {
		super("platin_block", Material.IRON, 2, 5.5F, SoundType.METAL);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return registry.platin_ingot;
	}	
	
	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return 9;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
		tooltip.add(TextFormatting.RED + I18n.translateToLocal("text.platinBlock.text"));
	}
}
