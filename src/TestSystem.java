import com.jogamp.opengl.GL2;
import com.retro.engine.Messaging.RetroMessage;
import com.retro.engine.debug.Debug;
import com.retro.engine.debug.DebugMode;
import com.retro.engine.entity.Entity;
import com.retro.engine.system.System;

import java.awt.*;

/**
 * Created by Michael on 7/29/2016.
 */
public class TestSystem extends System {

    public TestSystem(){
        super(TestComponent.class, true);
    }

    public void handleMessage(RetroMessage m){
        Debug.out("MESSAGE "+m.getRawData(), DebugMode.DEBUG_NOTICE);
    }

    @Override
    public void processEntity(Entity e, GL2 gl){
        Debug.out("Runnfing", DebugMode.DEBUG_NOTICE);
        TestComponent tc = ((TestComponent)e.get(TestComponent.class));


        gl.glTranslatef(0.0f,0.0f,-5.0f);

        gl.glRotatef(tc.rot, 0.0f, 1.0f, 1.0f);
        tc.rot+=1;

        // draw a triangle filling the window
        gl.glBegin( gl.GL_QUADS );

        gl.glColor3f(0.0f,0.0f,0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);

        gl.glColor3f(0.0f,1.0f,0.0f);
        gl.glVertex3f(-1.0f, -1.0f, 1.0f);
        gl.glVertex3f(1.0f, -1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, 1.0f);

        gl.glColor3f(1.0f,0.0f,0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glVertex3f(-1.0f, -1.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);

        gl.glColor3f(0.0f,0.0f,1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(1.0f, -1.0f, 1.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);

        gl.glEnd();
        gl.glFlush();
    }
    @Override
    public void processEntity(Entity e, Graphics2D gl){
        Debug.out("Running", DebugMode.DEBUG_NOTICE);

        gl.fillRect(0, 0, 50, 50);
    }
}
