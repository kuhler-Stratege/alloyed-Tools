package net.modding.items.basictools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.modding.main.Benennung_Registry;

public class BasicItemSword extends ItemSword{

	public static Benennung_Registry registry = new Benennung_Registry();
	
	public BasicItemSword(ToolMaterial material, String Materialname, CreativeTabs tab) {
		super(material);
		setUnlocalizedName(Materialname + "_sword");
		setRegistryName(Materialname + "_sword");
		setCreativeTab(tab);
		
	}


}
