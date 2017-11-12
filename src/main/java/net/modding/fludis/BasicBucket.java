package net.modding.fludis;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class BasicBucket extends ItemBucket{
	
	public static Benennung_Registry registry = modding.registry;

	public BasicBucket(Block containedFluid, String name, CreativeTabs tab) {
		super(containedFluid);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		setMaxStackSize(1);
		setContainerItem(Items.bucket);
	}

}
