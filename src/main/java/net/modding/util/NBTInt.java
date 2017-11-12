package net.modding.util;

import net.minecraft.nbt.NBTTagCompound;

public class NBTInt {

	public static void writeIntToNBT (int meta, String metaName) {
		NBTTagCompound compound = new NBTTagCompound();
		compound.setInteger(metaName, meta);
	}
	
	public static int readIntFromNBT (String metaName) {
		int meta;
		NBTTagCompound compound = new NBTTagCompound();
		meta = compound.getInteger(metaName);
		return meta;
	}
	
}
