package net.modding.util;

import java.net.MalformedURLException;
import java.net.URL;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class Events {

	private boolean hasShownUp = false;
	public static String DownloadURL = "https://goo.gl/YPKlEl";
	public static Minecraft getter = Minecraft.getMinecraft();
	public static Benennung_Registry registry = modding.registry;
	
	@SubscribeEvent
	public void onClientTick(ClientTickEvent event) {
		if (getter.currentScreen == null) {
		if (UpdateChecker.isNewVersionAvailable() && !hasShownUp) {
			getter.thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "" + EnumChatFormatting.BOLD + StatCollector.translateToLocal("text.UpdateChecker.text") + DownloadURL + "."));
			hasShownUp = true;
			}
		}
	}
}
