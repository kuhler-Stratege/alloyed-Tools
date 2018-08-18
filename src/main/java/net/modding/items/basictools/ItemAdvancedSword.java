package net.modding.items.basictools;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemSword;
import net.modding.main.modding;
import net.modding.registry.Benennung_Registry;

public class ItemAdvancedSword extends ItemSword{

	public static Benennung_Registry registry = modding.registry;
	
	private final float attackDamage;
	private final float attackSpeed;

	public ItemAdvancedSword(ToolMaterial material, float attackSpeed) {
		super(material);
		this.attackSpeed = attackSpeed;
		this.attackDamage = 3.0F + material.getDamageVsEntity();
}

	@Override
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = HashMultimap.<String, AttributeModifier>create();

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
        {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getAttributeUnlocalizedName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", attackSpeed - 2.0F, 0));
        }

        return multimap;
    }	
}