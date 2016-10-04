import com.retro.engine.AppProcess;
import com.retro.engine.Framework;
import com.retro.engine.RetroEngine;
import com.retro.engine.debug.Debug;
import com.retro.engine.debug.DebugMode;
import com.retro.engine.ui.Window;
import com.retro.engine.util.string.UtilString;

/**
 * Created by Michael on 7/29/2016.
 */
public class Main {

    public static void main(String[] args){
        Debug.out("Starting up", DebugMode.DEBUG_NOTICE);
        Framework.useOpenGL();
        final AppProcess app = RetroEngine.createApp("Game Trial", 1080, 720, new Game());
        Debug.out("Done up", DebugMode.DEBUG_NOTICE);
    }
}
