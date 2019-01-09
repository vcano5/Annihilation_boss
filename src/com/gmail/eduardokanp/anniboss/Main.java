package com.gmail.eduardokanp.anniboss;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.eduardokanp.anniboss.listener.StarPickup;
import com.gmail.eduardokanp.anniboss.listener.BossBoots;
import com.gmail.eduardokanp.anniboss.listener.BossChestplate;
import com.gmail.eduardokanp.anniboss.listener.BossHelmet;
import com.gmail.eduardokanp.anniboss.listener.BossLeggings;
import com.gmail.eduardokanp.anniboss.listener.BossPoisonSw;
import com.gmail.eduardokanp.anniboss.listener.HastePotion;
import com.gmail.eduardokanp.anniboss.listener.Inventory;
import com.gmail.eduardokanp.anniboss.listener.KillWither;
import com.gmail.eduardokanp.anniboss.listener.OpenInventory;
import com.gmail.eduardokanp.anniboss.listener.Soulbound;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		if(pm.isPluginEnabled("Annihilation")) {
		    //loadConfiguration();
			Bukkit.getServer().getLogger().info("Hooked to Annihilation Plugin");
	        pm.registerEvents(new KillWither(), this);
	        pm.registerEvents(new StarPickup(), this);
	        pm.registerEvents(new BossBoots(), this);
	        pm.registerEvents(new BossChestplate(), this);
	        pm.registerEvents(new BossHelmet(), this);
	        pm.registerEvents(new BossLeggings(), this);
	        pm.registerEvents(new BossPoisonSw(), this);
	        pm.registerEvents(new OpenInventory(), this);
	        pm.registerEvents(new StarPickup(), this);
	        pm.registerEvents(new Soulbound(), this);
	        pm.registerEvents(new HastePotion(), this);
	        pm.registerEvents(new Inventory(), this);
		} else {
			Bukkit.getServer().getLogger().severe("Do you have Annihilation.jar in your /plugins/ folder?");
			pm.disablePlugin(this);
		}
		Bukkit.getServer().getLogger().info(Bukkit.getBukkitVersion());
	}
	
	public void loadConfiguration(){
	     getConfig().options().copyDefaults(true);
	     saveConfig();
	}
	
	// If you can see this send me a private message on Spigot
	// Reward code: S3BC9
	
	public static ItemStack star() {
		  ItemStack is = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta ismeta = is.getItemMeta();
			ismeta.setDisplayName(ChatColor.GOLD + "Boss Buff <Rigth Click>");
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(ChatColor.DARK_PURPLE + "Right click me to open shop");
			ismeta.setLore(lore);
			is.setItemMeta(ismeta);
			return is;
	  }
	
	public static ItemStack wStar() {
		  ItemStack is = new ItemStack(Material.NETHER_STAR, 1);
			ItemMeta ismeta = is.getItemMeta();
			ismeta.setDisplayName(ChatColor.GOLD + "Boss Buff");
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(ChatColor.DARK_PURPLE + "Pickup this item and change for a star with Boss Buff");
			ismeta.setLore(lore);
			is.setItemMeta(ismeta);
			return is;
	  }
	
	public static ItemStack hPotion() {
		ItemStack is = new ItemStack(Material.POTION);
		ItemMeta ismeta = is.getItemMeta();
		ismeta.setDisplayName(ChatColor.WHITE + "Haste potion");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GOLD + "Soulbound");
		ismeta.setLore(lore);
		is.setItemMeta(ismeta);
		
		return is;
		
	}
	
	public static ItemStack boots() {
		ItemStack is = new ItemStack(Material.GOLD_BOOTS);
		ItemMeta ismeta = is.getItemMeta();
		ismeta.setDisplayName(ChatColor.DARK_PURPLE + "Boots of Grace");
		ismeta.addEnchant(Enchantment.DURABILITY, 3, true);
		ismeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GOLD + "Soulbound");
		ismeta.setLore(lore);
		is.setItemMeta(ismeta);
		return is;
	}
	
	public static ItemStack chestplate() {
		ItemStack is = new ItemStack(Material.GOLD_CHESTPLATE);
		ItemMeta ismeta = is.getItemMeta();
		ismeta.setDisplayName(ChatColor.DARK_PURPLE + "Chestplate of Fortitude");
		ismeta.addEnchant(Enchantment.DURABILITY, 3, true);
		ismeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GOLD + "Soulbound");
		ismeta.setLore(lore);
		is.setItemMeta(ismeta);
		return is;
	}
	
	public static ItemStack helmet() {
		ItemStack is = new ItemStack(Material.GOLD_HELMET);
		ItemMeta ismeta = is.getItemMeta();
		ismeta.setDisplayName(ChatColor.DARK_PURPLE + "Helmet of Extiguishment");
		ismeta.addEnchant(Enchantment.DURABILITY, 3, true);
		ismeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GOLD + "Soulbound");
		ismeta.setLore(lore);
		is.setItemMeta(ismeta);
		return is;
	}
	
	public static ItemStack leggings() {
		ItemStack is = new ItemStack(Material.GOLD_LEGGINGS);
		ItemMeta ismeta = is.getItemMeta();
		ismeta.setDisplayName(ChatColor.DARK_PURPLE + "Leggings of Swiftness");
		ismeta.addEnchant(Enchantment.DURABILITY, 3, true);
		ismeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GOLD + "Soulbound");
		ismeta.setLore(lore);
		is.setItemMeta(ismeta);
		return is;
	}
	
	public static ItemStack sword() {
		ItemStack is = new ItemStack(Material.GOLD_SWORD);
		ItemMeta ismeta = is.getItemMeta();
		ismeta.setDisplayName(ChatColor.DARK_PURPLE + "Sword of Poison");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GOLD + "Soulbound");
		ismeta.setLore(lore);
		is.setItemMeta(ismeta);
		return is;
	}
	
	public static ItemStack fSword() {
		ItemStack is = new ItemStack(Material.GOLD_SWORD);
		ItemMeta ismeta = is.getItemMeta();
		ismeta.setDisplayName(ChatColor.DARK_PURPLE + "Sword of Flames");
		ismeta.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
		ismeta.addEnchant(Enchantment.DURABILITY, 10, true);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GOLD + "Soulbound");
		ismeta.setLore(lore);
		is.setItemMeta(ismeta);
		return is;
	}
	
	public static ItemStack bow() {
		ItemStack is = new ItemStack(Material.BOW);
		ItemMeta ismeta = is.getItemMeta();
		ismeta.setDisplayName(ChatColor.DARK_PURPLE + "Bow of Power");
		ismeta.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
		ismeta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GOLD + "Soulbound");
		ismeta.setLore(lore);
		is.setItemMeta(ismeta);
		return is;
	}
	
	public static ItemStack fPick() {
		ItemStack is = new ItemStack(Material.GOLD_PICKAXE);
		ItemMeta ismeta = is.getItemMeta();
		ismeta.setDisplayName(ChatColor.DARK_PURPLE + "Pick of Fortune");
		ismeta.addEnchant(Enchantment.DURABILITY, 10, true);
		ismeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GOLD + "Soulbound");
		ismeta.setLore(lore);
		is.setItemMeta(ismeta);
		return is;
	}
	
	public static ItemStack hPick() {
		ItemStack is = new ItemStack(Material.GOLD_PICKAXE);
		ItemMeta ismeta = is.getItemMeta();
		ismeta.setDisplayName(ChatColor.DARK_PURPLE + "Pick of Haste");
		ismeta.addEnchant(Enchantment.DIG_SPEED, 3, true);
		ismeta.addEnchant(Enchantment.DURABILITY, 10, true);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GOLD + "Soulbound");
		ismeta.setLore(lore);
		is.setItemMeta(ismeta);
		return is;
	}
}
