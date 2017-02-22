package xyz.amtstl.community.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import xyz.amtstl.community.items.ItemCommunityLink;
import xyz.amtstl.community.tools.ToolOP;

public class ModItems {
	public static Item link = new ItemCommunityLink();
	public static ItemPickaxe optool;
	
	public static ToolMaterial opmaterial = EnumHelper.addToolMaterial("opmaterial", 5, 1000000, 95, 0, 1);
	
	public static void init() {
		GameRegistry.register(link);
		GameRegistry.register(optool = new ToolOP(opmaterial));
		
		GameRegistry.addShapedRecipe(new ItemStack(link), new Object[] {"###", "#I#", "###", '#', Blocks.DIRT, 'I', Items.REDSTONE});
		GameRegistry.addShapedRecipe(new ItemStack(optool, 1), new Object[] {"#O#", " I ", " I ", '#', Items.DIAMOND, 'O', Items.EMERALD, 'I', Items.STICK});
	}
	
	// Creative Tab
	public static CreativeTabs communitytab = new CreativeTabs("Community Mod") {
		@Override public ItemStack getTabIconItem() {
			return new ItemStack(link);
		}
	};
}