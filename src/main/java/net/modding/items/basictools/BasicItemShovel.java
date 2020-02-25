package net.modding.items.basictools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;
import net.modding.main.modding;
import net.modding.registry.Benennung_Registry;

public class BasicItemShovel extends ItemSpade{

	public static Benennung_Registry registry = modding.registry;
	
	public BasicItemShovel(ToolMaterial material, String Materialname, CreativeTabs tab) {
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
