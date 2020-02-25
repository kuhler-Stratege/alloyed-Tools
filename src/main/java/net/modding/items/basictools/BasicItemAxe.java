package net.modding.items.basictools;

import net.minecraft.creativetab.CreativeTabs;
import net.modding.main.modding;
import net.modding.registry.Benennung_Registry;

public class BasicItemAxe extends ItemAdvancedAxe{

	public static Benennung_Registry registry = modding.registry;
	
	public BasicItemAxe(ToolMaterial material, String Materialname, CreativeTabs tab, float attackSpeed) {
		super(material, attackSpeed);
		setUnlocalizedName(Materialname + "_axe");
		setCreativeTab(tab);
		setRegistryName(Materialname + "_axe");
	}
	
	@Override
	public boolean isRepairable() {
		return true;
	}
}
