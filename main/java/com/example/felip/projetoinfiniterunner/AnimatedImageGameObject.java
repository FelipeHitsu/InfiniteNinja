package com.example.felip.projetoinfiniterunner;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.io.InputStream;

/**
 * Created by felip on 01/05/2017.
 */

public class AnimatedImageGameObject extends GameObject {
    Bitmap anim[];
    int frames;
    float elapsedTime = 0;
    public int timeToNextFrame = 125;
    int currentFrame = 0;

    public void loadImage(String file, AssetManager manager, int framesW, int framesH){

        try {
            InputStream is = manager.open(file);
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            frames = framesW*framesH;
            anim = new Bitmap[frames];
            width = bitmap.getWidth()/framesW;
            height  = bitmap.getHeight()/framesH;
            int indice = 0;

            for(int i=0;i<framesW;i++){
                for(int j=0;j<framesH;j++){
                    anim[indice++] = Bitmap.createBitmap(bitmap,i*w,j*h,w,h);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void Update(float deltaTime) {
        super.Update(deltaTime);
        elapsedTime += deltaTime;
        if (deltaTime > timeToNextFrame) {
            elapsedTime = 0;
            currentFrame++;
            if (currentFrame >= frames) {
                currentFrame = 0;
            }
        }

        x += 200;
    }

    @Override
    public void Draw(Canvas canvas, Paint paint) {
        super.Draw(canvas, paint);
        canvas.drawBitmap(anim[currentFrame],x,y,paint);
    }

}
