package net.modding.items.eisenlegierung;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class ItemFerroArmor extends ItemArmor{
	
	public ItemFerroArmor(ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn, String name) {
		super(materialIn, 0, equipmentSlotIn);
		setCreativeTab(Benennung_Registry.chromTab);
		setUnlocalizedName(name);
		setRegistryName(name);
	}

	@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
			if (slot == EntityEquipmentSlot.HEAD  || slot == EntityEquipmentSlot.CHEST || slot == EntityEquipmentSlot.FEET) {
				return modding.MODID + ":textures/models/armor/mix_layer_1.png";
			}else if (slot == EntityEquipmentSlot.LEGS) {
				return modding.MODID + ":textures/models/armor/mix_layer_2.png";
			}else {
				return null;	
			}
		}

}