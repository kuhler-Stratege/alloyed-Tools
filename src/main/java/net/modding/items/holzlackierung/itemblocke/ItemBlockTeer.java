package net.modding.items.holzlackierung.itemblocke;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modding.blocks.holzlackierung.metadata.TeerTypes;
import net.modding.main.modding;
import net.modding.registry.Holzlackierung;
import net.modding.util.UnluckEffekte;

public class ItemBlockTeer extends ItemBlock{
	
	protected Holzlackierung registry = modding.registry.holz;
	public int teerTypesLength = TeerTypes.length;
	
	public ItemBlockTeer(Block block) {
		super(block);
		setRegistryName(block.getRegistryName());
		setUnlocalizedName(block.getUnlocalizedName().substring(5));
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
