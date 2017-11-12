package net.modding.util;

import java.net.MalformedURLException;
import java.net.URL;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class Events extends UnluckEffekte{

	private boolean hasShownUp = false;
	public static String DownloadURL = "https://goo.gl/YPKlEl";
	public static Minecraft getter = Minecraft.getMinecraft();
	public static Benennung_Registry registry = modding.registry;
	
	@SubscribeEvent
	public void onClientTick(LivingUpdateEvent event) {
		if (getter.currentScreen == null) {
			if (event.entityLiving instanceof EntityPlayer) {
				if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
					if (UpdateChecker.isNewVersionAvailable() && !hasShownUp) {
						getter.thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "" + EnumChatFormatting.BOLD + StatCollector.translateToLocal("text.UpdateChecker.text") + DownloadURL + "."));
						hasShownUp = true;
					}
				}
			}
		}
	}
}
