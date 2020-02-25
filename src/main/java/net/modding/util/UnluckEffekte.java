package net.modding.util;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.modding.registry.Holzlackierung;

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
	
	public static void unluckBlock (Block walkBlock, World worldIn, EntityLivingBase entityIn, BlockPos pos) {
			boolean gegebenn = false;
				if (worldIn.getBlockState(pos).getBlock() == walkBlock && entityIn != null) {
					entityIn.addPotionEffect(new PotionEffect(Potion.getPotionById(27), 300, 1));
					gegebenn = true;
				}
			}
	
	public static void teereAxt (EntityPlayer player, World worldIn, BlockPos pos, Block block, IBlockState state, Holzlackierung registry) {
			if (player.getHeldItemMainhand() != null) {
			if (player.getHeldItemMainhand().getItem() == Items.WOODEN_AXE) {
				player.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(registry.teer_axe));
				block.spawnAsEntity(worldIn, pos, new ItemStack(Item.getItemFromBlock(block)));
				}
			} else if (player.getHeldItemOffhand() != null) {
			if (player.getHeldItemOffhand().getItem() == Items.WOODEN_AXE) {
				player.setHeldItem(EnumHand.OFF_HAND, new ItemStack(registry.teer_axe));
				block.spawnAsEntity(worldIn, pos, new ItemStack(Item.getItemFromBlock(block)));
				}
			}
			else if (block.getHarvestTool(state).equals("axe") && block.getHarvestLevel(state) >= 0) {
				block.spawnAsEntity(worldIn, pos, new ItemStack(Item.getItemFromBlock(block)));
			}
		}
	}