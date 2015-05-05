package commands;


import org.bukkit.entity.Player;


import com.massivecraft.massivecore.cmd.MassiveCommand;

public abstract class ASGCommand extends MassiveCommand
{
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //

	public Player player;

	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //

	@Override
	public void fixSenderVars()
	{	

		if (sender instanceof Player)
		{
			player = (Player) sender;
		}
		

	}


}
