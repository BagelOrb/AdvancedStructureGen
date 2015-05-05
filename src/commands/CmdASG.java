package commands;

import java.util.Arrays;

import com.massivecraft.massivecore.cmd.HelpCommand;


public class CmdASG extends ASGCommand {

    public CmdASGDebug CmdASGDebug = new CmdASGDebug();
    public CmdASGFullStack CmdASGFullStack = new CmdASGFullStack();
	
	
    public CmdASG()
	{
		this.addSubCommand(HelpCommand.get());
        this.addSubCommand(this.CmdASGDebug);
        this.addSubCommand(this.CmdASGFullStack);
		
        this.setDesc(" gives access to AdvancedStructureGen commands");
        this.setHelp("This command is used for AdvancedStructureGen commands");
		
        this.addAliases(Arrays.asList(new String[]{"asg", "AdvancedStructureGen"}));
	}
	
}
