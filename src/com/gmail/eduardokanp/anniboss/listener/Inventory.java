package com.gmail.eduardokanp.anniboss.listener;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.lynx7478.anni.anniGame.Game;

public class Inventory implements Listener {

	HashMap<Player, UUID> hmKit = new HashMap<Player, UUID>();
	HashMap<UUID, ItemStack[]> inv2 = new HashMap<UUID, ItemStack[]>();
	HashMap<UUID, ItemStack[]> arm = new HashMap<UUID,ItemStack[]>();
	
	HashMap<UUID, String> inv = new HashMap<UUID, String>();
	
	/*@EventHandler
	public void onKitChange(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		if(hmKit.containsKey(p)) {
			
		}
	}*/
		
	/*@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {
		if(hmKit.containsKey(e.getPlayer())) {
			//clearInventory(e.getPlayer());
			new java.util.Timer().schedule( 
					new java.util.TimerTask() {
					@Override
					public void run() {
						//restoreInventory(e.getPlayer());
					}
							        }, 
							        15
							);
		}
	}*/
	
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent e) {
		Player p = (Player) e.getPlayer();
		if(e.getInventory().getName().equals(p.getName() + "'s Kits")) {
			hmKit.put(p, p.getUniqueId());	
			
			ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);

			exec.schedule(new Runnable() {
			          public void run() {
			        	  hmKit.remove(p);
			          }
			     }, 2, TimeUnit.SECONDS);
			
			
			//clearSavedInventory(p);
			//saveInventory(p);
		}
	}
	
	protected void saveInventory(Player p) {
		ItemStack iAir = new ItemStack(Material.AIR);
		if(Game.isGameRunning()) {
			for(int i = 0; i < 35; i += 1) {
				if(!p.getInventory().getItem(i).equals(iAir)) {
					ItemMeta ismeta = p.getInventory().getItem(i).getItemMeta();
					List<String> lore = ismeta.getLore();
					if(lore.contains(ChatColor.GOLD + "Soulbound")) {
						p.getInventory().clear(i);
					} else {
						String item = i + "/" + p.getInventory().getItem(i).toString();
						inv.put(p.getUniqueId(), item);
					}
				}
			}
		}
		else {
			
		}
	}
	
	/*public void saveInventory(Player p) {
		inv.put(p.getUniqueId(), p.getInventory().getContents());
		arm.put(p.getUniqueId(), p.getInventory().getArmorContents());
		p.sendMessage(ChatColor.GREEN + "Se ha guardado tu inventario");
	}
	
	public void saveInventory(Player p) {
		for (int i = 0; i < 35; i += 1) {
			if(!p.getInventory().getItem(i).equals(new ItemStack(Material.AIR))) {
				if(!isSoulbond(p.getInventory().getItem(i))) {
					p.sendMessage(ChatColor.AQUA + "Se ha guardado un: " + p.getInventory().getItem(i).toString());
				} else {
					p.sendMessage(ChatColor.RED + "No se ha guardado: " + p.getInventory().getItem(i).toString() + " porque es Soulbound");
				}
			} else {
				p.sendMessage(ChatColor.YELLOW + "El item que tienes en " + i + " es aire");
			}
		}
	}
	
	public boolean isSoulbond(ItemStack is) {
		ItemMeta ismeta = is.getItemMeta();
		List<String> lr = ismeta.getLore();
		if(lr.contains(ChatColor.GOLD + "Soulbound")) {
			return true;
		} else {
			return false;
		}
	}
	
	public void restoreInventory(Player p) {
		p.getInventory().setArmorContents(arm.get(p.getUniqueId()));
		p.getInventory().setContents(inv.get(p.getUniqueId()));
		p.sendMessage(ChatColor.GREEN + "Se ha restaurado tu inventario");
	}
	
	public void clearSavedInventory(Player p) {
		inv.remove(p.getUniqueId());
		p.sendMessage(ChatColor.GREEN + "Se ha limpiado el inventario guardado");
	}
	
	public void clearInventory(Player p) {
		p.getInventory().clear();
		p.sendMessage(ChatColor.GREEN + "Tu inventario se ha limpiado");
	}*/
}
