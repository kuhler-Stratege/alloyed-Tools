package net.modding.util;

import java.net.MalformedURLException;
import java.net.URL;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class Events {

	private boolean hasShownUp = false;
	public static Minecraft getter;
	public static Benennung_Registry registry = modding.registry;
	
	@SubscribeEvent
	public void onClientTick(ClientTickEvent event) {
		getter = Minecraft.getMinecraft();
		if (getter.currentScreen == null) {
		if (UpdateChecker.isNewVersionAvailable() && !hasShownUp) {
			getter.player.sendMessage(new TextComponentString(TextFormatting.GOLD + "" + TextFormatting.BOLD + I18n.translateToLocal("text.UpdateChecker.text") + modding.modInfo.UPDATE_URL + "."));
			hasShownUp = true;
			}
		}
	}
}
