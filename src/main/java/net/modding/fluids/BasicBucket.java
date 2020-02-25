package net.modding.fluids;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
import net.modding.main.modding;
import net.modding.registry.Benennung_Registry;

public class BasicBucket extends ItemBucket{
	
	public static Benennung_Registry registry = modding.registry;

	public BasicBucket(Block containedFluid, String name, CreativeTabs tab) {
		super(containedFluid);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		setMaxStackSize(1);
		setContainerItem(Items.BUCKET);
	}

}
