package net.modding.items.holzlackierung.itemblocke;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;

public class ItemBlockTeerFence_gate extends ItemBlockTeer {

	private Block block;
	
	public ItemBlockTeerFence_gate(Block block) {
		super(block);
		this.block = block;
	}
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		tooltip.add(TextFormatting.AQUA + "" + TextFormatting.ITALIC + I18n.translateToLocal("text.Teerfence_gate.text"));
		
	}
}
