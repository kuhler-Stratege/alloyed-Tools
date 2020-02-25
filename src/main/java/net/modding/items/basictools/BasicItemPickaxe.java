package net.modding.items.basictools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
import net.modding.main.modding;
import net.modding.registry.Benennung_Registry;

public class BasicItemPickaxe extends ItemPickaxe{

	public static Benennung_Registry registry = modding.registry;
	
	public BasicItemPickaxe(ToolMaterial material, String Materialname, CreativeTabs tab) {
		super(material);
		setUnlocalizedName(Materialname + "_pickaxe");
		setCreativeTab(tab);
		setRegistryName(Materialname + "_pickaxe");
		
	}
	
	@Override
	public boolean isRepairable() {
		return true;
	}

}
