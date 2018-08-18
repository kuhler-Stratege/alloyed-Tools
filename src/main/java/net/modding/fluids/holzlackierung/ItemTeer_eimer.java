package net.modding.fluids.holzlackierung;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.modding.fluids.BasicBucket;
import net.modding.util.UnluckEffekte;

public class ItemTeer_eimer extends BasicBucket{

	public ItemTeer_eimer(BlockFluidBase fluidBlock) {
		super(fluidBlock, "teer_eimer", registry.holz.teerTab);
		setMaxStackSize(1);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		tooltip.add(TextFormatting.DARK_RED + "" + TextFormatting.BOLD + I18n.translateToLocal("text.Teereimer.text"));
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
			return new ItemStack(Items.BUCKET);
		}
	}
	
