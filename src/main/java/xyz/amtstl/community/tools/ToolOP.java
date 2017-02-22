package xyz.amtstl.community.tools;

import net.minecraft.item.ItemPickaxe;
import xyz.amtstl.community.init.ModItems;

public class ToolOP extends ItemPickaxe {
	public ToolOP (ToolMaterial material) {
		super(material);
		
		this.setUnlocalizedName("optool");
		this.setRegistryName("optool");
		this.setCreativeTab(ModItems.communitytab);
	}
}