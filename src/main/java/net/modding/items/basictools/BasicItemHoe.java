package net.modding.items.basictools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;
import net.modding.main.modding;
import net.modding.registry.Benennung_Registry;

public class BasicItemHoe extends ItemHoe{

	public static Benennung_Registry registry = modding.registry;
	
	public BasicItemHoe(ToolMaterial material, String Materialname, CreativeTabs tab) {
		super(material);
		setUnlocalizedName(Materialname + "_hoe");
		setCreativeTab(tab);
		setRegistryName(Materialname + "_hoe");
	}
	
	@Override
	public boolean isRepairable() {
		return true;
	}

}
