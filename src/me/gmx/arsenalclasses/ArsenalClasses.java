package me.gmx.arsenalclasses;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.gmx.arsenalclasses.util.ParticleUtil;
import me.gmx.arsenalclasses.util.PlayerUtil;



public class ArsenalClasses extends JavaPlugin{

	public static String prefix;
	  public DefaultListeners deflist;
	  private static ArsenalClasses plugin;
	  public Commands c;
	  public PlayerUtil pu;
	  public ParticleUtil parutil;
	  public Logger log = Logger.getLogger("Minecraft");
	  
	  
	  
	 @Override
	public void onEnable()
	  {
		 
		 
		  plugin = this;
	    Bukkit.getPluginManager().registerEvents(new DefaultListeners(plugin), plugin);
	    Bukkit.getPluginManager().registerEvents(new SpecialListeners(plugin), plugin);

		  
	    getCommand("arsenalclasses").setExecutor(new Commands(plugin));


	    prefix = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + getDescription().getName() + ChatColor.DARK_GRAY + "] ";
	    
	    createConfig();
	    
	   
	    
	    this.getLogger().log(Level.INFO, String.format("[%s] Successfully enabled version %s!", new Object[] { getDescription().getName(), getDescription().getVersion() }));
	    createInstances();
	    //InvenUtil.createClass();
	    
	    /*new BukkitRunnable() {
	    	
	    	public void run() {
	    		for (Player p : Bukkit.getServer().getOnlinePlayers()) {
	    			Bukkit.broadcastMessage(p.getDisplayName() + " ----> "  + p.getStatistic(Statistic.PLAY_ONE_TICK));
	    			Bukkit.broadcastMessage("classDenialFramework_221.ACTIVATION\\ Invoke $1classErrorAssignment0" + ChatColor.DARK_RED + " = IKELOS.223/25 25 01 28 53 21 093 1");
	    		}
	    		
	    		
	    	}
	    }.runTaskTimer(this, 100, 100);*/
	  }
	 
	 
	 
	 private void createInstances(){
		  new BukkitRunnable(){
			  
			  @Override
			public void run(){
				    deflist = new DefaultListeners(plugin);
				    c = new Commands(plugin);
				    pu = new PlayerUtil(plugin);
				    parutil = new ParticleUtil(plugin);
		    plugin.getConfig();
			  }
			  
		  }.runTaskLater(this,50L);
	 }

	 
	 
	 @Override
	public void onDisable()
	  {
		  this.saveConfig();
	    this.getLogger().log(Level.INFO, String.format("[%s] Successfully disabled version %s!", new Object[] { getDescription().getName(), getDescription().getVersion() }));
	  }
	 
	 private void createConfig() {
	      try {
	          if (!getDataFolder().exists()) {
	              getDataFolder().mkdirs();
	          }
	          File file = new File(getDataFolder(), "config.yml");
	          if (!file.exists()) {
	        	 /* 	getConfig().addDefault("spiritstompcooldown", 120);
	        	    getConfig().addDefault("dragonbuffcooldown", 60);
	        	    getConfig().addDefault("cataclysmcooldown", 180);
	        	    getConfig().addDefault("voidrocketcooldown", 50);
	        	    getConfig().addDefault("smokebomb", 60);*/
	              saveDefaultConfig();
	              getConfig().options().copyDefaults();
	              saveConfig();
	          } else {
	              getLogger().info("Config.yml found, loading!");
	          }
	          if (this.getConfig().getConfigurationSection("classes") == null){
	        	  this.getConfig().createSection("classes");
	          }
	          plugin.saveConfig();
	      } catch (Exception e) {
	          e.printStackTrace();

	      }

	  }



	
	
	
}
