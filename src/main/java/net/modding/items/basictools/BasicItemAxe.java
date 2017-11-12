package net.modding.items.basictools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.modding.main.Benennung_Registry;

public class BasicItemAxe extends ItemAdvancedAxe{

	public static Benennung_Registry registry = new Benennung_Registry();
	
	protected BasicItemAxe(ToolMaterial material, String Materialname, CreativeTabs tab, float attackSpeed) {
		super(material, attackSpeed);
		setUnlocalizedName(Materialname + "_axe");
		setCreativeTab(tab);
		setRegistryName(Materialname + "_axe");
	}

}
