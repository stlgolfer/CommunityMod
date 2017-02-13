package xyz.amtstl.community.init;

import com.google.common.io.Resources;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import xyz.amtstl.community.Reference;
import xyz.amtstl.community.blocks.BlockCommunity;

public class ModBlocks {
	public static Block communityblock;
	
	public static void registerBlocks() {
		// init classes
		communityblock = new BlockCommunity();
		
		// register blocks
		registerBlock(communityblock);
		
		// recipes
		GameRegistry.addShapelessRecipe(new ItemStack(communityblock, 1), new ItemStack(Blocks.ANVIL, 1));
		
		// smelting
		GameRegistry.addSmelting(new ItemStack(Blocks.ANVIL, 1), new ItemStack(communityblock, 3), 3f);
		
		// registerRender(communityblock);
	}
	
	public static void registerBlock(Block block) 
	{
		registerBlock(block, new ItemBlock(block));
	}
	
	public static void registerBlock(Block block, ItemBlock item) 
	{
		GameRegistry.register(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
	}
	
	public static void registerRender(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getUnlocalizedName(), "inventory"));
		System.out.println("RESOURCE LOCATION: " + Reference.MOD_ID + ":" + block.getUnlocalizedName().substring(5));
	}
}