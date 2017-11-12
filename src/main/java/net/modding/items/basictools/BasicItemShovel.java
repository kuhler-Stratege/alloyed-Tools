package net.modding.items.basictools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.Item.ToolMaterial;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class BasicItemShovel extends ItemSpade{

	public static Benennung_Registry registry = modding.registry;
	
	protected BasicItemShovel(ToolMaterial material, String Materialname, CreativeTabs tab) {
		super(material);
		setUnlocalizedName(Materialname + "_shovel");
		setCreativeTab(tab);
		setRegistryName(Materialname + "_shovel");
		
	}
	@Override
	public boolean isRepairable() {
		return true;
	}

}
