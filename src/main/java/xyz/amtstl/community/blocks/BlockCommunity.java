package xyz.amtstl.community.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import xyz.amtstl.community.misc.HTTPHandler;

public class BlockCommunity extends Block {

	public BlockCommunity() {
		super(Material.ROCK);
		
		// set block config
		this.setUnlocalizedName("blockCommunity");
		this.setRegistryName("blockCommunity");
		this.setCreativeTab(CreativeTabs.MISC);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if (!worldIn.isRemote)
		{
			try {
				playerIn.sendMessage(new TextComponentString(HTTPHandler.sendGet("http://45.56.70.141:1510/chat/get")));
			} catch (Exception e) {
				playerIn.sendMessage(new TextComponentString("Couldn't connect to the Community, try again later maybe?"));
			}
		}
		return true;
	}
}