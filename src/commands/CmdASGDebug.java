package commands;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import structure.StructureGen;

import com.massivecraft.massivecore.cmd.arg.ARInteger;
import com.massivecraft.massivecore.util.Txt;



public class CmdASGDebug extends ASGCommand{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //

	public CmdASGDebug()
	{
		// Aliases
		this.addAliases("d", "debug");

		// Args
		this.addOptionalArg("optionalArg", "");

		this.setDesc("debug something");
		this.setHelp("This command is used to try out anything");

		// Requirements
		//		this.addRequirements(ReqFactionsEnabled.get());
		//		this.addRequirements(ReqHasPerm.get(Perm.LIST.node));
	}

	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //

	@Override
	public void perform()
	{
		if(player.isOp())
		{
			sendMessage("performing debug command!");


			int defaultInt = 1;
			int index = 0;
			Integer integerArg = this.arg(index, ARInteger.get(), defaultInt);

			if (integerArg == 2)
			{
				Block loc = player.getWorld().getBlockAt(player.getLocation());
				StructureGen.generate(loc, 7, 5, 6, BlockFace.EAST);

			}
			else {
				Block loc = player.getWorld().getBlockAt(player.getLocation());
				StructureGen.generate(loc, 7, 5, 6, BlockFace.NORTH);
			}







		}
		else
		{
			sendMessage(Txt.parse("<bad>You must be OP to do that!"));
		}
	}

}
