package net.modding.items.basictools;

import net.minecraft.creativetab.CreativeTabs;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class BasicItemAxe extends ItemAdvancedAxe{

	public static Benennung_Registry registry = modding.registry;
	
	protected BasicItemAxe(ToolMaterial material, String Materialname, CreativeTabs tab, float attackSpeed) {
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
