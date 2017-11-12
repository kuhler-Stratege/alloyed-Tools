package net.modding.items.basictools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.Item.ToolMaterial;
import net.modding.main.Benennung_Registry;

public class BasicItemHoe extends ItemHoe{

	public static Benennung_Registry registry = new Benennung_Registry();
	
	protected BasicItemHoe(ToolMaterial material, String Materialname, CreativeTabs tab) {
		super(material);
		setUnlocalizedName(Materialname + "_hoe");
		setCreativeTab(tab);
		setRegistryName(Materialname + "_hoe");
	}


}
