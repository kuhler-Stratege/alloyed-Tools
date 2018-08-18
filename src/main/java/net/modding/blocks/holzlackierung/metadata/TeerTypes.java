package net.modding.blocks.holzlackierung.metadata;

import net.minecraft.block.BlockPlanks;
import net.minecraft.util.IStringSerializable;

public enum TeerTypes implements IStringSerializable{
	
	oak(0, "oak"),
	spruce(1, "spruce"),
	birke(2, "birke"),
	jungle(3, "jungle"),
	steppe(4, "steppe"),
	dark_oak(5, "darkoak")
	;
	
	private int meta;
	private String metaName;
	public static int length = TeerTypes.values().length;
	
	private TeerTypes(int meta, String metaName) {
		this.meta = meta;
		this.metaName =metaName;
	}
	
	public String getName() {
		return metaName;
	}
	
	public int getMetadata() {
		return meta; 
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
	public static TeerTypes byName (String name) {
		if (name.equals(oak.getName()) || name.equals(BlockPlanks.EnumType.OAK.getName())) {
			return oak;
		}
		if (name.equals(spruce.getName()) || name.equals(BlockPlanks.EnumType.SPRUCE.getName())) {
			return spruce;
		}
		if (name.equals(birke.getName()) || name.equals(BlockPlanks.EnumType.BIRCH.getName())) {
			return birke;
		}
		if (name.equals(jungle.getName()) || name.equals(BlockPlanks.EnumType.JUNGLE.getName())) {
			return jungle;
		}
		if (name.equals(steppe.getName()) || name.equals(BlockPlanks.EnumType.ACACIA.getName())) {
			return steppe;
		}
		if (name.equals(dark_oak.getName()) || name.equals(BlockPlanks.EnumType.DARK_OAK.getName())) {
			return dark_oak;
		}
		
		throw new IllegalArgumentException("None of the EnumTypes has the name " + name + ".");
	}
	
	public static TeerTypes byMetadata(int meta) {
		if (meta == 0) {
			return oak;
		}
		if (meta == 1) {
			return spruce;
		}
		if (meta == 2) {
			return birke;
		}
		if (meta == 3) {
			return jungle;
		}
		if (meta == 4) {
			return steppe;
		}
		if (meta == 5) {
			return dark_oak;
		}
		
		throw new IllegalArgumentException("None of the EnumTypes has metadata " + meta + ".");
	}
}
