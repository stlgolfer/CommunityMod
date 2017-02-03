package xyz.amtstl.community.chatcommands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class CommandSend implements ICommand {	 
	private final List aliases;
	
	public CommandSend() {
		aliases = new ArrayList();
		aliases.add("send");
	}
	
	@Override
	public int compareTo(ICommand arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "send";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "send <text>";
	}

	@Override
	public List<String> getAliases() {
		// TODO Auto-generated method stub
		return this.aliases;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		// TODO Auto-generated method stub
		World world = sender.getEntityWorld(); 
	    
        if (world.isRemote) 
        { 
            System.out.println("Not processing on Client side"); 
        } 
        else 
        { 
            System.out.println("Processing on Server side"); 
            if(args.length == 0) 
            { 
                sender.sendMessage(new TextComponentString("Not valid argument!"));
                return;
            }
            else {
            	for (String arg : args) {
            		sender.sendMessage(new TextComponentString("Your arguments: " + arg.toString()));	
            	}
            }
        }
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		// TODO Auto-generated method stub
		sender.canUseCommand(0, this.getName());
		
		return true;
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args,
			BlockPos targetPos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		// TODO Auto-generated method stub
		return false;
	}

}
