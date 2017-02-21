package xyz.amtstl.community.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import xyz.amtstl.community.Reference;
import xyz.amtstl.community.init.ModItems;
import xyz.amtstl.community.misc.HTTPHandler;

public class BlockCommunity extends Block {

	public BlockCommunity() {
		super(Material.ROCK);
		
		// set block config
		this.setUnlocalizedName("blockcommunity");
		this.setRegistryName("blockcommunity");
		this.setCreativeTab(ModItems.communitytab);
		this.setLightLevel(5.0f);
		this.setHardness(1.0f);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if (!worldIn.isRemote)
		{
			try {
				playerIn.sendMessage(new TextComponentString(HTTPHandler.sendGet(Reference.CHAT_GET_IP)));
				// playerIn.openGui(Reference.MOD_ID, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
			} catch (Exception e) {
				playerIn.sendMessage(new TextComponentString("Couldn't connect to the Community, try again later maybe?"));
			}
		}
		return true;
	}
}