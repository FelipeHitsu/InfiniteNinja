package com.example.felip.projetoinfiniterunner;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felip on 10/04/2017.
 */
public class GameResources {
    private static GameResources ourInstance = new GameResources();

    List<GameObject> gameObjectList = new ArrayList<>();

    public static GameResources getInstance() {
        return ourInstance;
    }

    private GameResources() {

    }

    public void addObject(GameObject obj){
        for(int i = 0;i<gameObjectList.size();i++){
            GameObject obj2 = gameObjectList.get(i);
            if(obj.layer <= obj2.layer){
                gameObjectList.add(i,obj);
            }
        }
        gameObjectList.add(obj);
    }

    public void removeObject(GameObject obj){
        gameObjectList.remove(obj);
    }

    public void updateAndDraw(float deltaTime, Canvas canvas, Paint paint){

        for(GameObject obj:gameObjectList){
            obj.Update(deltaTime);
            obj.Draw(canvas,paint);
        }
    }
}
