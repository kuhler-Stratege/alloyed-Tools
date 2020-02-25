package net.modding.items.holzlackierung;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import net.modding.registry.Benennung_Registry;
import net.modding.registry.Holzlackierung;

public class TeerFuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		Item item = fuel.getItem();
		String name = item.getUnlocalizedName().substring(5);
		Holzlackierung reg = Benennung_Registry.holz;
		int plank_brenndauer = 75;
		if (item instanceof BasicTeerItem || name.contains("teer_")) {
			if (item == reg.teer_sword || item == reg.teer_axe || item == reg.teer_pickaxe || item == reg.teer_hoe || item == reg.teer_shovel) {
				return (plank_brenndauer / 10 + 13) * 20;
			}
			
			else if (name.contains(reg.plank_teer.getUnlocalizedName().substring(5))) {
				return plank_brenndauer * 20;
			}
			
			else if (name.contains(reg.teer_treppe.getUnlocalizedName().substring(5))) {
				return (plank_brenndauer * (3 / 4)) * 20;
			}
			
			else if (name.contains("teer_slab")) {
				return (plank_brenndauer / 2) * 20;
			}
			
			else if (item == item.getItemFromBlock(reg.teer_knopf) || name.equals(reg.teer_knopf.getUnlocalizedName().substring(5))) {
				return plank_brenndauer;
			}
		
			else if (item == reg.teer_stick) {
				return (plank_brenndauer / 10) * 20;
			}
			
			else if (name.contains(reg.teer_zaun.getUnlocalizedName().substring(5)) || name.contains(reg.teer_fence_gate.getUnlocalizedName().substring(5))) {
				return 17 * 20;
			}
			
			else if (item == reg.teer_eimer) {
				return 121 * 20;
			}
			
			else {
			return 5 * 20;
			}
		}
		return 0;
	}

}
