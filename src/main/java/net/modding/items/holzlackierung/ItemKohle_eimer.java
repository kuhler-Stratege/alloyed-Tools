package net.modding.items.holzlackierung;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemKohle_eimer extends BasicItemTeer{

	public ItemKohle_eimer() {
		super("kohle_eimer");
		maxStackSize = 3;
	}
	
	@Override
	public boolean hasContainerItem() {
		return true;
	}
	
	@Override
	public ItemStack getContainerItem(ItemStack stack) {
		return new ItemStack(Items.BUCKET);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if (!worldIn.isRemote) {
			if (playerIn.getHeldItemMainhand().getItem() != null) {
				Item item = playerIn.getHeldItemMainhand().getItem();
			if (item == registry.kohle_eimer) {
				EntityItem droppeditem = new EntityItem(worldIn, playerIn.posX, playerIn.posY -1, playerIn.posZ, new ItemStack(Items.COAL));
				worldIn.spawnEntity(droppeditem);
				return ActionResult.newResult(EnumActionResult.SUCCESS, new ItemStack (Items.BUCKET));
					}
				}
			}
			return super.onItemRightClick(worldIn, playerIn, handIn);
		}
	}