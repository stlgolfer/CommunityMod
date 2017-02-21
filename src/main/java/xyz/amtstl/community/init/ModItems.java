package xyz.amtstl.community.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import xyz.amtstl.community.items.ItemCommunityLink;

public class ModItems {
	public static Item link = new ItemCommunityLink();
	
	public static void init() {
		GameRegistry.register(link);
		GameRegistry.addShapedRecipe(new ItemStack(link), new Object[] {"###", "#I#", "###", '#', Blocks.DIRT, 'I', Items.REDSTONE});
	}
	
	// Creative Tab
	public static CreativeTabs communitytab = new CreativeTabs("Community Mod") {
		@Override public ItemStack getTabIconItem() {
			return new ItemStack(link);
		}
	};
}