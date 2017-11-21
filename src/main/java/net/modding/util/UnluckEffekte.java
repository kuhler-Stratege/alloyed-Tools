package net.modding.util;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.modding.fludis.holzlackierung.Teer;

public class UnluckEffekte {
	
	public static String teerText = TextFormatting.DARK_RED + I18n.translateToLocal("text.teer.text");
	
	public static void unluckItem (Item unluckItem, Entity entityIn) {
		if (entityIn instanceof EntityLivingBase) {
			boolean gegeben = false;
			EntityLivingBase player = ((EntityLivingBase) entityIn);
			String itemString = unluckItem.toString();
			PotionEffect unluckEffect = new PotionEffect(Potion.getPotionById(27), 300, 1, false, true);
			if (player.getHeldItemMainhand() != null) {
				if (player.getHeldItemMainhand().getItem().toString().contains(itemString)) {
					player.addPotionEffect(unluckEffect);
					if (gegeben == false) {
						gegeben = true;
						}
					}
				}
			if (player.getHeldItemOffhand() != null) {
					if (gegeben == false){
						if (player.getHeldItemOffhand().getItem().toString().contains(itemString)) {
							player.addPotionEffect(unluckEffect);
							gegeben = true;
						}
					}
				}
			}
		}
	
	public static void unluckBlock (Block walkBlock, World worldIn, Entity entityIn, BlockPos pos) {
		if (entityIn instanceof EntityLivingBase) {
			boolean gegebenn = false;
				if (worldIn.getBlockState(pos).getBlock() == walkBlock) {
					((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(27), 300, 1));
					gegebenn = true;
				}
			}
		}
	}