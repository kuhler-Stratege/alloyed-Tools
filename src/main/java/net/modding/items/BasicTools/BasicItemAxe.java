package net.modding.items.basicTools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.modding.main.Benennung_Registry;

public class BasicItemAxe extends ItemAxe{

	public static Benennung_Registry registry = new Benennung_Registry();
	
	public BasicItemAxe(ToolMaterial material, String Materialname, CreativeTabs tab) {
		super(material);
		setUnlocalizedName(Materialname + "_axe");
		setCreativeTab(tab);
		
	}

}
