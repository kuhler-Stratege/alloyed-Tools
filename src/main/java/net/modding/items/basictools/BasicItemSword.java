package net.modding.items.basictools;

import net.minecraft.creativetab.CreativeTabs;
import net.modding.main.modding;
import net.modding.registry.Benennung_Registry;

public class BasicItemSword extends ItemAdvancedSword{

	public static Benennung_Registry registry = modding.registry;
	
	public BasicItemSword(ToolMaterial material, String Materialname, CreativeTabs tab, float attackSpeed) {
		super(material, attackSpeed);
		setUnlocalizedName(Materialname + "_sword");
		setCreativeTab(tab);
		setRegistryName(Materialname + "_sword");
		
	}

	@Override
	public boolean isRepairable() {
		return true;
	}
}
