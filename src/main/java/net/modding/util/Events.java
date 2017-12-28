package net.modding.util;

import java.net.MalformedURLException;
import java.net.URL;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class Events extends UnluckEffekte{

	private boolean hasShownUp = false;
	public static Minecraft getter = Minecraft.getMinecraft();
	public static Benennung_Registry registry = modding.registry;
	
	@SubscribeEvent
	public void onClientTick(LivingUpdateEvent event) {
		if (getter.currentScreen == null && event.entityLiving instanceof EntityPlayer && FMLCommonHandler.instance().getSide() == Side.CLIENT && UpdateChecker.isNewVersionAvailable() && !hasShownUp) {
						getter.thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "" + EnumChatFormatting.BOLD + StatCollector.translateToLocal("text.UpdateChecker.text") + modding.modInfo.UPDATE_URL + "."));
						hasShownUp = true;
					}
				}
}
