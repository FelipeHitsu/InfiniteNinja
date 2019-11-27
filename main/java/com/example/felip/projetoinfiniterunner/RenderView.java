package com.example.felip.projetoinfiniterunner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by felip on 10/04/2017.
 */

public class RenderView extends View {

    Paint paint = new Paint();
    float startTIme = 0.0f;
    ParallaxGameObject parallaxGameObject,chaoGameObject;
    AnimatedImageGameObject ninja = new AnimatedImageGameObject();

    public RenderView(Context context) {
        super(context);
        startTIme = System.nanoTime();

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        float deltaTime = (System.nanoTime()-startTIme)/100000.0f;
        startTIme = System.nanoTime();

        canvas.drawRGB(200,200,200);
        GameResources.getInstance().updateAndDraw(deltaTime,canvas,paint);

        invalidate();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if(parallaxGameObject != null)
            return;
        parallaxGameObject = new ParallaxGameObject();
        parallaxGameObject.loadImage("introBackground.png",getContext().getAssets(),getWidth(),getHeight(),false,true);
        parallaxGameObject.layer = 1;
        GameResources.getInstance().addObject(parallaxGameObject);

        if(chaoGameObject != null)
            return;
        chaoGameObject = new ParallaxGameObject();
        chaoGameObject.loadImage("chao.png",getContext().getAssets(),(int)parallaxGameObject.width,getHeight(),true,false);
        chaoGameObject.layer = 2;
        chaoGameObject.y = getHeight();
        chaoGameObject.speed = 200;
        GameResources.getInstance().addObject(chaoGameObject);

        if(ninja != null)
            return;
        ninja.loadImage("CorrendoCaralho.png",getContext().getAssets(),10,1);
        ninja.x = 0;
        ninja.y = 5;
        GameResources.getInstance().addObject(ninja);
    }
}


