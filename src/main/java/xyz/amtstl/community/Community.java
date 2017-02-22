package xyz.amtstl.community;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xyz.amtstl.community.chatcommands.CommandSend;
import xyz.amtstl.community.gui.testgui.GuiHandler;
import xyz.amtstl.community.init.ModBlocks;
import xyz.amtstl.community.init.ModItems;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class Community {
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		ModBlocks.registerBlocks();
		ModItems.init();
	}
	
	@EventHandler @SideOnly(Side.CLIENT)
	public static void init(FMLInitializationEvent e) {
		// init stuff
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(ModBlocks.communityblock), 0, new ModelResourceLocation("community:blockcommunity", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ModItems.link, 0, new ModelResourceLocation("community:itemlink", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ModItems.optool, 0, new ModelResourceLocation("community:optool", "inventory"));
	}
	
	@EventHandler @SideOnly(Side.SERVER)
	public void serverLoad(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new CommandSend());
	}
}