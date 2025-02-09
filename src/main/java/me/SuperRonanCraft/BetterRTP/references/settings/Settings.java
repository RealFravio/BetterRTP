package me.SuperRonanCraft.BetterRTP.references.settings;

import me.SuperRonanCraft.BetterRTP.references.file.FileBasics;
import me.SuperRonanCraft.BetterRTP.BetterRTP;

public class Settings {

    public boolean debug;
    public boolean delayEnabled;
    public boolean rtpOnFirstJoin_Enabled;
    public String rtpOnFirstJoin_World;
    public boolean rtpOnFirstJoin_SetAsRespawn;
    public boolean statusMessages; //Send more information about rtp
    public int preloadRadius; //Amount of chunks to load around a safe rtp location (clamped (0 - 16))
    //Dependencies
    private final SoftDepends depends = new SoftDepends();

    public void load() { //Load Settings
        FileBasics.FILETYPE config = getPl().getFiles().getType(FileBasics.FILETYPE.CONFIG);
        debug = config.getBoolean("Settings.Debugger");
        delayEnabled = config.getBoolean("Settings.Delay.Enabled");
        rtpOnFirstJoin_Enabled = config.getBoolean("Settings.RtpOnFirstJoin.Enabled");
        rtpOnFirstJoin_World = config.getString("Settings.RtpOnFirstJoin.World");
        rtpOnFirstJoin_SetAsRespawn = config.getBoolean("Settings.RtpOnFirstJoin.SetAsRespawn");
        preloadRadius = config.getInt("Settings.PreloadRadius");
        statusMessages = config.getBoolean("Settings.StatusMessages");
        depends.load();
    }

    public SoftDepends getsDepends() {
        return depends;
    }

    private BetterRTP getPl() {
        return BetterRTP.getInstance();
    }
}
