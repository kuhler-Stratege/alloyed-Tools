package net.modding.items.holzlackierung.tools;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modding.items.basictools.BasicItemSword;
import net.modding.util.UnluckEffekte;

public class ItemTeer_sword extends BasicItemSword{
	
	public ItemTeer_sword() {
		super(registry.teerMaterial, "teer", registry.teerTab, 0.15F);
	}	
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		
		tooltip.add(UnluckEffekte.teerText);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
		UnluckEffekte.unluckItem(this, entityIn);
		}
}