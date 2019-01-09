package com.gmail.eduardokanp.anniboss.listener;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
//import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class Soulbound implements Listener {

	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		//Material m = e.getItemDrop().getItemStack().getType();
		Player p = e.getPlayer();
		Location pL = p.getEyeLocation();
		ItemMeta ismeta = e.getItemDrop().getItemStack().getItemMeta();
		List<String> lore = ismeta.getLore();
		if(lore.contains(ChatColor.GOLD + "Soulbound")) {
			for (int i = 0; i < 50; i += 1) {
				int m = (i % 2);
				if(m == 1) {
					Location lc2 = pL;
					String lc = "0." + i;
					Double lcd = Double.parseDouble(lc);
					lc2.add(lcd, 0, lcd);
					p.getWorld().playEffect(lc2, Effect.HEART,1);	
				} else {
					Location lc2 = pL;
					String lc = "-0." + i;
					Double lcd = Double.parseDouble(lc);
					lc2.add(lcd, 0, lcd);
					p.getWorld().playEffect(lc2, Effect.HEART,1);	
				}
			}	
		}
	}
}