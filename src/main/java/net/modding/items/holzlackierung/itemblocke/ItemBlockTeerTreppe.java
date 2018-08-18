package net.modding.items.holzlackierung.itemblocke;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;

public class ItemBlockTeerTreppe extends ItemBlockTeer {

	public ItemBlockTeerTreppe(Block block) {
		super(block);
	}
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		tooltip.add(TextFormatting.AQUA + "" + TextFormatting.ITALIC + I18n.translateToLocal("text.Teertreppe.text"));
		
	}
}
