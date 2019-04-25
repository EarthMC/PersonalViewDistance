package com.karlofduty.personalviewdistance;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class AutoDistance implements Listener
{
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		if(event.getPlayer().hasPermission("viewdistance.autodistance"))
		{
			for(int i = 16; i > 1; i--)
			{
				if(event.getPlayer().hasPermission("viewdistance." + i))
				{
					event.getPlayer().setViewDistance(i);
					return;
				}
			}
		}
	}
}
