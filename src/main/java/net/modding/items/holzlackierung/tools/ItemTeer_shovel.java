package net.modding.items.holzlackierung.tools;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modding.items.basictools.BasicItemShovel;
import net.modding.util.UnluckEffekte;

public class ItemTeer_shovel extends BasicItemShovel{
	
	public ItemTeer_shovel() {
		super(registry.teerMaterial, "teer", registry.teerTab);
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