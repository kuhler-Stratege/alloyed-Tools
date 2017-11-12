package net.modding.util;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class UnluckEffekte {
	public static String teerText = EnumChatFormatting.DARK_RED + StatCollector.translateToLocal("text.teer.text");
	
	public static void unluckItem (Item unluckItem, Entity entityIn) {
		if (entityIn instanceof EntityLivingBase) {
			EntityLivingBase player = ((EntityLivingBase) entityIn);
			String itemString = unluckItem.toString();
			PotionEffect unluckEffect = new PotionEffect(2, 300, 1, false, true);
			boolean gegeben = false;
			if (player.getHeldItem() != null) {
				if (player.getHeldItem().getItem().toString().contains(itemString)) {
					player.addPotionEffect(unluckEffect);
					if (gegeben == false) {
						//player.addChatMessage(new ChatComponentText("Item gegeben false"));
						gegeben = true;	
							}
						}
					}
				}
			}
	
	public static void unluckBlock (Block walkBlock, World worldIn, Entity entityIn, BlockPos pos) {
		if (entityIn instanceof EntityLivingBase) {
				if (worldIn.getBlockState(pos).getBlock() == walkBlock) {
					//((EntityLivingBase)entityIn).addChatMessage(new ChatComponentText("Block gegeben false"));
					((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(2, 300, 1, false, true));
			}
		}
	}
}