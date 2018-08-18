package net.modding.items.holzlackierung.itemblocke;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.modding.blocks.holzlackierung.metadata.IMetaBlockName;

public class ItemBlockTeerPlank extends ItemBlockTeer{

	public ItemBlockTeerPlank(Block block) {
		super(block);
		if (!(block instanceof IMetaBlockName)) 
			throw new IllegalArgumentException(String.format("The given block , %s" + ", is not an instance of IMetaBlockName", block.getUnlocalizedName()));
		setMaxDamage(0);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int damage) {
		return damage;
	}
	
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> items) {
		for (int i = 0; i < teerTypesLength; i++) {
			items.add(new ItemStack(itemIn, 1, i));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName(stack) + "." + ((IMetaBlockName)this.block).getSpecialName(stack);
	}
	
}
