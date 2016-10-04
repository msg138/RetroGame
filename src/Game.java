import com.jogamp.opengl.GL2;
import com.retro.engine.Framework;
import com.retro.engine.Messaging.RetroMessage;
import com.retro.engine.RetroProcess;
import com.retro.engine.debug.Debug;
import com.retro.engine.debug.DebugMode;
import com.retro.engine.entity.Entity;
import com.retro.engine.event.EventHandler;
import com.retro.engine.loading.LoadData;
import com.retro.engine.scene.SceneType;
import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;

/**
 * Created by Michael on 7/29/2016.
 */
public class Game extends RetroProcess{

    private Entity e;

    @Override
    public void initializeGL(GL2 gl){
    }

    public Game(){
        super(640, 480);
    }

    public void initialize(){
        Debug.out("Adding systems", DebugMode.DEBUG_NOTICE);
        TestSystem ts = new TestSystem();
        e = new Entity();
        e.add(new TestComponent());
        ((TestComponent)e.get(TestComponent.class)).oZ = -3;
        Framework.getInstance().getEntityStorage().addEntity(e);
        Debug.out("added systems " + e.has(TestComponent.class), DebugMode.DEBUG_NOTICE);
    }

    public LoadData load(){
        Framework.getInstance().getSystemManager().handleMessage(new RetroMessage(1, "LOADING", "NIL"));
        return null;
    }
// TODO NOT CLEARING SCREEN, NOT RENDERING WHEN SUPPOSED TO
    public void scene(SceneType sc){
        if(EventHandler.getInstance().isKeyPressed(KeyEvent.VK_E))
        {
            if(e.has(TestComponent.class)){
                Debug.out("Removing comp'", DebugMode.DEBUG_NOTICE);
                e.remove(TestComponent.class);
            }
        }
    }
}
