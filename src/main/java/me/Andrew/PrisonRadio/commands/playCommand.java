package me.Andrew.PrisonRadio.commands;

import com.corundumstudio.socketio.SocketIOClient;
import me.Andrew.PrisonRadio.PrisonRadio;
import me.piggypiglet.pigapi.objects.CMD;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Andrew on 01/01/2018.
 */
public class playCommand extends CMD {

    public playCommand() {
        this.cmd="play";
    }

    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
                Player p = (Player) sender;
                SocketIOClient client = PrisonRadio.getInstance().sb.getClient(p);
                if (client == null) {
                    p.sendMessage("your not on the link");
                    return;
                }
                if (args.length == 2) {
                    //for (SocketIOClient client2 : sb.server.getAllClients()) {
                    client.sendEvent("playaudio", args[1]);
                    //}
                }
                return;
            }
        if (args.length == 2) {
            for (SocketIOClient client : PrisonRadio.getInstance().sb.server.getAllClients()) {
            client.sendEvent("playaudio", args[1]);
            }
        }
    }
}
