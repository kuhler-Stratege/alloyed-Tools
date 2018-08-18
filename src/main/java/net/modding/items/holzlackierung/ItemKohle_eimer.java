package net.modding.items.holzlackierung;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemKohle_eimer extends BasicItemTeer{

	public ItemKohle_eimer() {
		super("kohle_eimer");
		maxStackSize = 3;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		if (!worldIn.isRemote) {
		Item item = itemStackIn.getItem();
		if (item == registry.holz.kohle_eimer) {
			EntityItem droppeditem = new EntityItem(worldIn, playerIn.posX, playerIn.posY -1, playerIn.posZ, new ItemStack(Items.COAL));
			worldIn.spawnEntityInWorld(droppeditem);
			return super.onItemRightClick(new ItemStack(Items.BUCKET), worldIn, playerIn, hand);
			}
		}
		return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
	}
	
	@Override
	public boolean hasContainerItem() {
		return true;
	}
	
	@Override
	public ItemStack getContainerItem(ItemStack stack) {
		return new ItemStack(Items.BUCKET);
	}
}