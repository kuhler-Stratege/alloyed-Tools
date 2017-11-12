package net.modding.items.holzlackierung;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.modding.fludis.holzlackierung.Teer;
import net.modding.util.UnluckEffekte;

public class ItemTeer_stick extends BasicItemTeer{

	public ItemTeer_stick() {
		super("teer_stick");
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		
		tooltip.add(TextFormatting.DARK_RED + I18n.translateToLocal("text.teer.text"));
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
		UnluckEffekte.unluckItem(this, entityIn);
	}
}
