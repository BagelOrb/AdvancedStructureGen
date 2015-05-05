package main;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.PluginManager;
import com.massivecraft.massivecore.MassivePlugin;

import commands.CmdASG;



public class AdvancedStructureGen extends MassivePlugin {

	public CmdASG outerCommand;

	public static World defaultWorld;
	
	
	public static AdvancedStructureGen getCurrentPlugin() {
//		return currentPlugin; 
		return (AdvancedStructureGen) Bukkit.getServer().getPluginManager().getPlugin("AdvancedStructureGen"); 
	}
	
	@Override
	public void onEnable() {
		

		defaultWorld = Bukkit.getServer().getWorld("world");


		PluginManager pm = getServer().getPluginManager();
//		pm.registerEvents(this.AllListener, this);		
		outerCommand = new CmdASG();
		outerCommand.register(getCurrentPlugin());
		
//		new BukkitRunnable() {
//			
//			@Override
//			public void run() {
//			    IO.checkAllFactions();
//			}
//		}.runTaskLater(this, 10);
	}
}
