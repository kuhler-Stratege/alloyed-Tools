package net.modding.items.holzlackierung;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.modding.fludis.BasicBucket;
import net.modding.fludis.holzlackierung.Teer;
import net.modding.util.UnluckEffekte;

public class ItemTeer_eimer extends BasicItemTeer{

	public ItemTeer_eimer() {
		super("teer_eimer");
		setMaxStackSize(1);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		
		tooltip.add(UnluckEffekte.teerText);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
		UnluckEffekte.unluckItem(this, entityIn);
		}
	
	@Override
	public boolean hasContainerItem() {
		return true;
		}
	
	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
			return new ItemStack(Items.bucket);
		}
	}
	
