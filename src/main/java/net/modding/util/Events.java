package net.modding.util;

import java.net.MalformedURLException;
import java.net.URL;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class Events {

	private boolean hasShownUp = false;
	public static Minecraft getter;
	public static String DownloadURL = "https://goo.gl/YPKlEl";
	public static Benennung_Registry registry = modding.registry;
	
	@SubscribeEvent
	public void onClientTick(ClientTickEvent event) {
		getter = Minecraft.getMinecraft();
		if (getter.currentScreen == null) {
		if (UpdateChecker.isNewVersionAvailable() && !hasShownUp) {
			getter.player.sendMessage(new TextComponentString(TextFormatting.GOLD + "" + TextFormatting.BOLD + I18n.translateToLocal("text.UpdateChecker.text") + DownloadURL + "."));
			hasShownUp = true;
			}
		}
	}
	@SubscribeEvent
	public static void onCrafted(ItemCraftedEvent event) {
		IInventory matrix = event.craftMatrix;
		ItemStack stack = matrix.getStackInSlot(1);
		int i = 0;
		if (CraftingHelper.getIngredient(stack) != null) {
			if (CraftingHelper.getIngredient(stack) == Ingredient.fromItem(Item.getItemFromBlock(Blocks.PLANKS))) {
				if (event.crafting.getItem() == Item.getItemFromBlock(registry.plank_teer)) {
				int meta = Item.getItemFromBlock(Blocks.PLANKS).getMetadata(stack);
				NBTInt.writeIntToNBT(meta, "metadata " + Integer.toString(i));
				i++;
				}
			}
		}
		if (stack.getItem() != null) {
			if (stack.getItem() == Item.getItemFromBlock(registry.plank_teer)) {
				if (event.crafting.getItem() == Item.getItemFromBlock(Blocks.PLANKS)) {
					int metaOut; 
					metaOut = NBTInt.readIntFromNBT("metadata " + Integer.toString(i));
					new ItemCraftedEvent(event.player, new ItemStack (Blocks.PLANKS, 1, metaOut), event.craftMatrix);
				}
			}
		}
	}
	
}
