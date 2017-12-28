package net.modding.items.goldlegierung;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class ItemBlockGold extends ItemBlock{

	public static Benennung_Registry registry = modding.registry;
	
	public ItemBlockGold(Block block) {
		super(block);
		setUnlocalizedName(block.getUnlocalizedName());
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		if (this.getUnlocalizedName().substring(5).contains(registry.platin_block.getUnlocalizedName().substring(5))) {
			tooltip.add(EnumChatFormatting.RED + StatCollector.translateToLocal("text.platinBlock.text"));
			}
			else if (this.getUnlocalizedName().substring(5).contains(registry.platin_ore.getUnlocalizedName().substring(5))) {
				tooltip.add(EnumChatFormatting.RED + StatCollector.translateToLocal("text.platinOre.text"));
			}
	}
	
}
