package net.modding.blocks.goldlegierung;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.modding.main.modding;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;

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
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
		tooltip.add(TextFormatting.WHITE + I18n.translateToLocal("text.platinOre.text"));
	}
}
