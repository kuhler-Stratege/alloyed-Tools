package net.modding.items.basictools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.Item.ToolMaterial;
import net.modding.main.Benennung_Registry;

public class BasicItemShovel extends ItemSpade{

	public static Benennung_Registry registry = new Benennung_Registry();
	
	protected BasicItemShovel(ToolMaterial material, String Materialname, CreativeTabs tab) {
		super(material);
		setUnlocalizedName(Materialname + "_shovel");
		setCreativeTab(tab);
		setRegistryName(Materialname + "_shovel");
		
	}


}
