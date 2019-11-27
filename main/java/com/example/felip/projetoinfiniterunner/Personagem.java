package com.example.felip.projetoinfiniterunner;

/**
 * Created by felip on 22/05/2017.
 */

public class Personagem extends AnimatedImageGameObject {

    float speed = 100;
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

        x += speed;
    }
}
