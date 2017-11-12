package net.modding.items.holzlackierung;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemKohle_eimer extends BasicItemTeer{

	public ItemKohle_eimer() {
		super("kohle_eimer");
		maxStackSize = 3;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		if (!worldIn.isRemote) {		
			Item item = itemStackIn.getItem();
			if (item == registry.kohle_eimer) {
				EntityItem droppeditem = new EntityItem(worldIn, playerIn.posX, playerIn.posY -1, playerIn.posZ, new ItemStack(Items.coal));
				worldIn.spawnEntityInWorld(droppeditem);
				return super.onItemRightClick(new ItemStack(Items.bucket), worldIn, playerIn);
				}
			}
			return super.onItemRightClick(itemStackIn, worldIn, playerIn);
		}
	
	@Override
	public boolean hasContainerItem() {
		return true;
	}
	
	@Override
	public ItemStack getContainerItem(ItemStack stack) {
		return new ItemStack(Items.bucket);
	}
}