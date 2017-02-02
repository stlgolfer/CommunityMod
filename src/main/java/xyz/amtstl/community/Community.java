package xyz.amtstl.community;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import xyz.amtstl.community.init.ModBlocks;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class Community {
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		ModBlocks.registerBlocks();
	}
}