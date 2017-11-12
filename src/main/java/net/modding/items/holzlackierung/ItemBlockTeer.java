package net.modding.items.holzlackierung;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.modding.blocks.holzlackierung.BasicBlockTeer;
import net.modding.fludis.holzlackierung.Teer;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;
import net.modding.util.UnluckEffekte;

public class ItemBlockTeer extends ItemBlock{
	
	public static Benennung_Registry registry = modding.registry;
	
	public ItemBlockTeer(Block block) {
		super(block);
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
